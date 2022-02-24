package com.webApp.movieRecommendationApp.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.webApp.movieRecommendationApp.repo.*;
import com.webApp.movieRecommendationApp.dto.CategoryContentAvailabilityDto;
import com.webApp.movieRecommendationApp.entity.*;

@Service
@Component
public class AppService {
	
	
	@Autowired
	AppCategoryRepo categoryRepo;

	@Autowired
	AppContentRepo contentRepo;
		
		
	public final String encryptPassword(String password)
	{
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode(password);
		return encoded;
	}

	public final boolean checksPassword(String encoded,String pw)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		boolean result = encoder.matches(pw, encoded);
		return result;
	}
	
	public final Model getContents(Model m)
	{
		int i,j;
		Long categoryId;
		String[] categories = new String[]{"Bollywood","Hollywood","TVSeries"};
		List<Category> category = categoryRepo.findAll();
		for(i=0;i<categoryRepo.count();i++)
		{
			categoryId = category.get(i).getId();
			List<CategoryContentAvailabilityDto> contents = contentRepo.fetchCategoryContentAvailabilityByCategoryId(categoryId);
			List<CategoryContentAvailabilityDto> content = new ArrayList<CategoryContentAvailabilityDto>();
			Random rand = new Random();
			for(j=0;j<5;j++)
			{
				content.add(contents.get(rand.nextInt(contents.size())));
			}
			m.addAttribute(categories[i],content);
		}
		return m;
	}
}
