package com.webApp.movieRecommendationApp.developers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.webApp.movieRecommendationApp.repo.*;
import com.webApp.movieRecommendationApp.entity.*;
import com.webApp.movieRecommendationApp.dto.*;

@RestController
@Component
public class DeveloperRestController {
	
	
	@Autowired
	AppRepo repo;
		
	@Autowired
	AppContentRepo contentRepo;
		
	@Autowired
	AppAvailabilityRepo availabilityRepo;
		
	
	@GetMapping(path="/login/admin/users/all", produces= {"application/json"})
	public List<Users> getAllUsers()
	{
		return repo.findAll();
	}

	@GetMapping(path="/login/admin/contents", produces= {"application/json"})
	public List<CategoryContentAvailabilityDto> getAllContents()
	{
		List<CategoryContentAvailabilityDto> list = contentRepo.fetchCategoryContentAvailabilityJoin();
		return list;
	}
	
	@GetMapping(path="/login/admin/get/content/{content_id}", produces = {"application/json"})
	public CategoryContentAvailabilityDto getContent(@PathVariable("content_id") Long id)
	{
		return contentRepo.fetchCategoryContentAvailabilityById(id);
	}
	
	
	@GetMapping(path="/login/admin/remove/content/{content_id}", produces = {"application/json"})
	public List<CategoryContentAvailabilityDto> removeContent(@PathVariable("content_id") Long id)
	{
		contentRepo.deleteById(id);
		availabilityRepo.deleteById(availabilityRepo.findByContentId(id));
		return contentRepo.fetchCategoryContentAvailabilityJoin();
	}
	
	@GetMapping(path = "/login/admin/remove/user/{user_id}", produces = {"application/json"})
	public List<Users> removeUser(@PathVariable("user_id") Long id)
	{
		repo.deleteById(id);
		return repo.findAll();
	}
		
}
