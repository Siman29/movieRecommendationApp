package com.webApp.movieRecommendationApp.developers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.webApp.movieRecommendationApp.entity.Availability;
import com.webApp.movieRecommendationApp.entity.Category;
import com.webApp.movieRecommendationApp.entity.Content;
import com.webApp.movieRecommendationApp.entity.Genre;
import com.webApp.movieRecommendationApp.repo.AppAvailabilityRepo;
import com.webApp.movieRecommendationApp.repo.AppCategoryRepo;
import com.webApp.movieRecommendationApp.repo.AppContentRepo;
import com.webApp.movieRecommendationApp.repo.AppGenreRepo;
import com.webApp.movieRecommendationApp.users.AppService;

@Controller
@Component
public class DeveloperController {
	
	@Autowired
	AppContentRepo contentRepo;
	
	@Autowired
	AppCategoryRepo categoryRepo;
		
	@Autowired
	AppAvailabilityRepo availabilityRepo;
	
	@Autowired
	AppGenreRepo genreRepo;
	
	@Autowired
	AppService service;
		
		
	
	@PostMapping(path="/login/addContent")
	public RedirectView addContent(HttpServletRequest request,Model m,@RequestParam("genre") List<String> genres) 
	{
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String movie = request.getParameter("movie");
		String year = "(" + request.getParameter("year") + ")";
		String runtime = request.getParameter("runtime") + " min";
		String ratings = request.getParameter("ratings");
		String description = request.getParameter("description");
		String coverImg = request.getParameter("cover_img");
		String hotstar = request.getParameter("hotstar");
		String amazonPrime = request.getParameter("amazonPrime");
		String netflix = request.getParameter("netflix");
		//content
		
		if(contentRepo.findByMovie(movie).isEmpty())
		{
			Integer contentId = contentRepo.findLastContentId() + 1;
			Content content = new Content(contentId,movie,year,runtime,ratings,description,coverImg);
			
			Integer availabilityId = availabilityRepo.findLastAvailabilityId() + 1;
			Availability available = new Availability(availabilityId,hotstar,amazonPrime,netflix);
			content.setAvailabilty(available);
			
			Integer genreId = genreRepo.findLastGenreId() + 1;
			Genre genre = service.getGenreObj(genreId,genres); //to be done
			content.setGenre(genre);
			
			
			Category category = categoryRepo.getById(categoryId);
			content.setCategory(category);
			contentRepo.save(content);

			
			
		}
		
		m.addAttribute("name","admin");
		return new RedirectView("/admin");		
	}
	
	
	
	@PostMapping(path="/login/editContent")
	public RedirectView editContent(HttpServletRequest request,Model m) 
	{
		Integer contentId = Integer.parseInt(request.getParameter("content_id"));
		String ratings = request.getParameter("ratings_edit");
		String description = request.getParameter("description_edit");
		String coverImg = request.getParameter("cover_img_edit");
		String hotstar = request.getParameter("hotstar_edit");
		String amazonPrime = request.getParameter("amazonPrime_edit");
		String netflix = request.getParameter("netflix_edit");
		
		Integer availabilityId = contentRepo.findById(contentId).get().getAvailabilty().getId();
		
		contentRepo.updateContent(contentId, ratings, description, coverImg);
		
		availabilityRepo.updateAvailability(availabilityId, hotstar, amazonPrime, netflix);
		
		m.addAttribute("name","admin");
		
		return new RedirectView("/admin");		
	}
	
	
		
}

