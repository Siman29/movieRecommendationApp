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
		
	
	private static String loginVal = "no";
	private static String name = null;
	
	
	@Autowired
	private AppService service;
	
	
	
	@GetMapping("/")
	public String index(Model m)
	{ 
		m = service.getContents(m);
		if(loginVal.equals("yes"))
		{
			if(name.equals("admin"))
			{
				return "redirect:admin";
			}
			else 
			{
				return "redirect:" + name;
			}
		}
		return "home";
	}
	
	@GetMapping("/admin")
	public String admin(Model m)
	{ 
		m = service.getContents(m);
		if(loginVal.equals("yes"))
		{
			m.addAttribute("name","admin");
		}else {
			return "redirect: ";
		}		
		return "developerHome";
	}
	
	@GetMapping(path = "/{name}")
	public String getUser(Model m,@PathVariable("name") String name)
	{ 
		m = service.getContents(m);
		if(loginVal.equals("yes"))
		{
			m.addAttribute("name",name);
		}else {
			return "redirect: ";
		}
		return "home";
	}
	
	
	@PostMapping("/login")
	public RedirectView login(HttpSession session,HttpServletRequest request,Model m)//,@RequestParam("uname_login") String email,@RequestParam("pw_login") String pw)
	{
			String email = request.getParameter("uname_login");
			String pw = request.getParameter("pw_login");
			if(email.equals("admin@admin.com") && pw.equals("admin"))
			{
				loginVal = "yes";
				name = "admin";
				return new RedirectView("/admin");
			}
			Users user = repo.findByMailId(email);
			if(user!=null) {
				String encryptPw = user.getPassword();
				if(service.checksPassword(encryptPw, pw))
				{
					name = user.getFirstName() + " " + user.getLastName();
					m = service.getContents(m);
					m.addAttribute("name", name);
					m.addAttribute("msg","Login Successful..WELCOME " + name);
					System.out.println("Getting executed");
					loginVal = "yes";
					return new RedirectView("/" + name);
				}
			}
		return new RedirectView("/");
	}
	
	@PostMapping("/signup")
	public RedirectView signup(HttpSession session,HttpServletRequest request,Model m,@RequestParam("fname_signup") String first_name,@RequestParam("lname_signup") String last_name,@RequestParam("email_signup") String email,@RequestParam("phone_signup") Long phoneNo,@RequestParam("pw_signup") String pw)
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
			if(repo.save(user)!=null)
			{
				name = user.getFirstName() + " " + user.getLastName();
				m = service.getContents(m);
				m.addAttribute("name", name);
				m.addAttribute("msg","Sign Up Successful..WELCOME " + name);
				System.out.println("Getting executed");
				loginVal = "yes";
				return new RedirectView("/" + name);
			}
		}
		return new RedirectView("/");
	}
	
	@GetMapping("/logout-success")
	public RedirectView logout(HttpSession session, HttpServletRequest request,Model m)
	{
		m = service.getContents(m);
		m.addAttribute("name",null);
		m.addAttribute("msg","GoodBye...Have a nice day ");
		loginVal = "no";
		name = null;
		return new RedirectView("/");
	}
	
	

}
