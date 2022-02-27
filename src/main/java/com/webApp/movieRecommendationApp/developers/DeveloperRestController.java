package com.webApp.movieRecommendationApp.developers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.webApp.movieRecommendationApp.repo.*;
import com.webApp.movieRecommendationApp.users.AppService;
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
	
	@Autowired
	AppService service;
		
	
	@GetMapping(path="/login/admin/users/all", produces= {"application/json"})
	public List<UsersDto> getAllUsers()
	{
		return service.getAllUsers();
	}

	@GetMapping(path="/login/admin/contents", produces= {"application/json"})
	public List<ContentDto> getAllContents()
	{
		List<ContentDto> list = service.getAllContents();
		return list;
	}
	
	@GetMapping(path="/login/admin/contentsForUser/{userId}", produces= {"application/json"})
	public List<ContentDto> getAllContentsForUser(@PathVariable("userId") Integer userId)
	{
		List<ContentDto> list = service.getAllContentsForUser(userId);
		return list;
	}
	
	@GetMapping(path="/login/admin/get/content/{content_id}", produces = {"application/json"})
	public ContentDto getContent(@PathVariable("content_id") Integer id)
	{
		return service.getContent(id);
	}
	
	
	@GetMapping(path="/login/admin/remove/content/{content_id}", produces = {"application/json"})
	public List<ContentDto> removeContent(@PathVariable("content_id") Integer id)
	{
		contentRepo.deleteById(id);
		return service.getAllContents();
	}
	
	@GetMapping(path = "/login/admin/remove/user/{user_id}", produces = {"application/json"})
	public List<UsersDto> removeUser(@PathVariable("user_id") Integer id)
	{
		repo.deleteById(id);
		return service.getAllUsers();
	}
		
}
