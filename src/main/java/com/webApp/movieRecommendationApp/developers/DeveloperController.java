package com.webApp.movieRecommendationApp.developers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.webApp.movieRecommendationApp.entity.Availability;
import com.webApp.movieRecommendationApp.entity.Content;
import com.webApp.movieRecommendationApp.repo.AppAvailabilityRepo;
import com.webApp.movieRecommendationApp.repo.AppContentRepo;

@Controller
@Component
public class DeveloperController {
	
	@Autowired
	AppContentRepo contentRepo;
		
	@Autowired
	AppAvailabilityRepo availabilityRepo;
		
		
	
	@PostMapping(path="/login/addContent")
	public RedirectView addContent(HttpServletRequest request,Model m) 
	{
		Long categoryId = (long) Integer.parseInt(request.getParameter("category"));
		String movie = request.getParameter("movie");
		String year = "(" + request.getParameter("year") + ")";
		String runtime = request.getParameter("runtime") + " min";
		String genre = request.getParameter("genre");
		String ratings = request.getParameter("ratings");
		String description = request.getParameter("description");
		String coverImg = request.getParameter("cover_img");
		String hotstar = request.getParameter("hotstar");
		String amazonPrime = request.getParameter("amazonPrime");
		String netflix = request.getParameter("netflix");
		
		
		if(contentRepo.findByMovie(movie).isEmpty())
		{
			Long contentId = contentRepo.findLastContentId() + 1;
			Content content = new Content(contentId,categoryId,movie,year,runtime,genre,ratings,description,coverImg);
			contentRepo.save(content);
			Long availabilityId = availabilityRepo.findLastAvailabilityId() + 1;
			Availability available = new Availability(availabilityId,contentId,hotstar,amazonPrime,netflix);
			availabilityRepo.save(available);
		}
		
		m.addAttribute("name","admin");
		return new RedirectView("/admin");		
	}
	
	
	
	@PostMapping(path="/login/editContent")
	public RedirectView editContent(HttpServletRequest request,Model m) 
	{
		Long contentId = (long) Integer.parseInt(request.getParameter("content_id"));
		String ratings = request.getParameter("ratings_edit");
		String description = request.getParameter("description_edit");
		String coverImg = request.getParameter("cover_img_edit");
		String hotstar = request.getParameter("hotstar_edit");
		String amazonPrime = request.getParameter("amazonPrime_edit");
		String netflix = request.getParameter("netflix_edit");
		
		contentRepo.updateContent(contentId, ratings, description, coverImg);
		
		availabilityRepo.updateAvailability(contentId, hotstar, amazonPrime, netflix);
		
		
		m.addAttribute("name","admin");

		return new RedirectView("/admin");		
	}
	
	
		
}

