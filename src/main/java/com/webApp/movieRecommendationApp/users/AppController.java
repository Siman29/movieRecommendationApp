package com.webApp.movieRecommendationApp.users;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.webApp.movieRecommendationApp.repo.*;
import com.webApp.movieRecommendationApp.entity.*;

@Controller
@Component
public class AppController {
	
	
	@Autowired
	AppRepo repo;
		
	@Autowired
	AppCategoryRepo categoryRepo;

	@Autowired
	AppContentRepo contentRepo;
		
	@Autowired
	AppAvailabilityRepo availabilityRepo;
	
	@Autowired
	AppUsersWatchedRepo usersWatchedRepo;
		
	
	
	@Autowired
	private AppService service;
	
	
	
	@GetMapping("/")
	public String index(HttpServletRequest request,Model m)
	{ 
		if(request.getSession().getAttribute("loginVal")!=null)
		{
			String name = request.getSession().getAttribute("name").toString();
			if(name.equals("admin"))
			{
				return "redirect:admin";
			}
			else 
			{
				Integer id = (Integer) request.getSession().getAttribute("id");
				return "redirect:" + id;
			}
		}
		m = service.getContents(m);
		request.getSession().invalidate();
		return "home";
	}
	
	@GetMapping("/admin")
	public String admin(HttpServletRequest request,Model m)
	{ 
		if(request.getSession().getAttribute("loginVal")!=null)
		{
			String name = request.getSession().getAttribute("name").toString();
			if(name.equals("admin"))
			{
				m.addAttribute("name",name);
			}
			else
			{
				Integer id = (Integer) request.getSession().getAttribute("id");
				return "redirect:" + id;
			}
		}else {
			return "redirect:";
		}		
		return "developerHome";
	}
	
	@GetMapping(path = "/{id}")
	public String getUser(HttpServletRequest request,Model m,@PathVariable("id") Integer id)
	{ 
		int flag = 0;
		if(request.getSession().getAttribute("loginVal")!=null)
		{
			String name = request.getSession().getAttribute("name").toString();
			if(name.equals("admin"))
			{
				return "redirect:admin";
			}
			else
			{
				m.addAttribute("name",name);
				m.addAttribute("id",id);
				m.addAttribute("msg","Log In Successful");
			}
		}
		else
		{
			return "redirect:";
		}
		m = service.getContentsForUser(m,id);
		m.addAttribute("watched", service.getWatched(id));
		m.addAttribute("recommended",service.getRecommendationForUser(id));
		return "home";
	}
	
	
	@PostMapping("/login")
	public RedirectView login(HttpSession session,HttpServletRequest request,Model m)//,@RequestParam("uname_login") String email,@RequestParam("pw_login") String pw)
	{
			String email = request.getParameter("uname_login");
			String pw = request.getParameter("pw_login");
			String name;
			if(email.equals("admin@admin.com") && pw.equals("admin"))
			{
				session = request.getSession();
				session.setAttribute("name", "admin");
				session.setAttribute("loginVal", "yes");
				return new RedirectView("/admin");
			}
			Users user = repo.findByMailId(email);
			if(user!=null) {
				String encryptPw = user.getPassword();
				if(service.checksPassword(encryptPw, pw))
				{
					name = user.getFirstName() + " " + user.getLastName();
					Integer id = user.getId();
					session = request.getSession();
					session.setAttribute("name", name);
					session.setAttribute("id", id);
					session.setAttribute("loginVal", "yes");
					return new RedirectView("/" + id);
				}
			}
		return new RedirectView("/");
	}
	
	@PostMapping("/signup")
	public RedirectView signup(HttpSession session,HttpServletRequest request,Model m,
			@RequestParam("fname_signup") String first_name,
			@RequestParam("lname_signup") String last_name,
			@RequestParam("email_signup") String email,
			@RequestParam("phone_signup") Long phoneNo,
			@RequestParam("pw_signup") String pw)
	{
		String encryptPw = service.encryptPassword(pw);
		Users user = new Users(first_name,last_name,email,phoneNo,encryptPw);
		if(repo.findLastUserId()==null)
		{
			Integer n = 1;
			user.setId(n);
		}else {
			user.setId(repo.findLastUserId()+1);
		}
		if(repo.findByMailId(user.getMailId())==null) 
		{
			repo.save(user);
		}
		return new RedirectView("/");
	}
	
	@GetMapping("/logout-success")
	public RedirectView logout(HttpSession session, HttpServletRequest request,Model m)
	{
		request.getSession().removeAttribute("loginVal");
		request.getSession().removeAttribute("name");
		request.getSession().removeAttribute("id");
		request.getSession().invalidate();
		m = service.getContents(m);
		m.addAttribute("name",null);
		m.addAttribute("msg","GoodBye...Have a nice day ");
		
		return new RedirectView("/");
	}
	
	@PostMapping("addWatched")
	public RedirectView addWatched(HttpServletRequest request)
	{
		Integer contentId = Integer.parseInt(request.getParameter("c_id"));
		Integer id;
		Integer userId = Integer.parseInt(request.getParameter("u_id"));
		Float rating = Float.parseFloat(request.getParameter("user_rating"));
		String comments = request.getParameter("user_comments");
		if(usersWatchedRepo.findLastId()==null)
		{
			id = 1;
		}else {
			id = usersWatchedRepo.findLastId() +  1;
		}
		UsersWatch watched = new UsersWatch(id,rating,comments);
		watched.setContent(contentRepo.getById(contentId));
		watched.setUser(repo.getById(userId));
		usersWatchedRepo.save(watched);
		return new RedirectView("/" + userId);
	}
	
	

}
