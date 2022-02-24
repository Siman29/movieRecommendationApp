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
import com.webApp.movieRecommendationApp.dto.CategoryContentDto;
import com.webApp.movieRecommendationApp.dto.ContentAvailabilityDto;
import com.webApp.movieRecommendationApp.dto.ContentGenreDto;
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
		String[] categories = new String[]{"Bollywood","Hollywood","TVSeries"};
		List<Category> category = categoryRepo.findAll();
		for(i=0;i<categoryRepo.count();i++)
		{
			List<CategoryContentAvailabilityDto> allContents = getAllContents();
			List<CategoryContentAvailabilityDto> contents = new ArrayList<>();
			for(j=0;j<allContents.size();j++)
			{
				if(allContents.get(j).getCategoryName().equals(category.get(i).getTitle()))
				{
					contents.add(allContents.get(j));
				}
			}
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
	public final List<CategoryContentAvailabilityDto> getAllContents()
	{
		List<CategoryContentAvailabilityDto> contents = new ArrayList<>();
		List<CategoryContentDto> catContent = contentRepo.fetchCategoryContentJoin();
		List<ContentAvailabilityDto> contAvail = contentRepo.fetchContentAndAvailabilityJoin();
		List<ContentGenreDto> contGenre = contentRepo.fetchContentGenreJoin();
		int i;
		for(i=0;i<contAvail.size();i++)
		{
			Integer contentId = catContent.get(i).getContentId();
			String categoryName = catContent.get(i).getCategoryName();
			String movie = contAvail.get(i).getMovie();
			String year = contAvail.get(i).getYear();
			String runtime = contAvail.get(i).getRuntime();
			List<String> genre = getGenre(contGenre.get(i));
			String ratings = contAvail.get(i).getRatings();
			String description = contAvail.get(i).getDescription();
			String coverImg = contAvail.get(i).getCoverImg();
			String hotstar = contAvail.get(i).getHotstar();
			String amazonPrime = contAvail.get(i).getAmazonPrime();
			String netflix = contAvail.get(i).getNetflix();
			contents.add(new CategoryContentAvailabilityDto(contentId,categoryName,movie,year,runtime,genre,ratings,description,coverImg,hotstar,amazonPrime,netflix));	
		}
		
		return contents;
	}
	
	public final List<String> getGenre(ContentGenreDto obj)
	{
			List<String> genre = new ArrayList<>();
			if(obj.getAction().intValue() == 1)
				genre.add("Action");
			if(obj.getAdventure().intValue() == 1)
				genre.add("Adventure");
			if(obj.getBiography().intValue() == 1)
				genre.add("Biography");
			if(obj.getComedy().intValue() == 1)
				genre.add("Comedy");
			if(obj.getCrime().intValue() == 1)
				genre.add("Crime");
			if(obj.getDrama().intValue() == 1)
				genre.add("Drama");
			if(obj.getFantasy().intValue() == 1)
				genre.add("Fantasy");
			if(obj.getHistory().intValue() == 1)
				genre.add("History");
			if(obj.getHorror().intValue() == 1)
				genre.add("Horror");
			if(obj.getMusical().intValue() == 1)
				genre.add("Musical");
			if(obj.getMystery().intValue() == 1)
				genre.add("Mystery");
			if(obj.getRomance().intValue() == 1)
				genre.add("Romance");
			if(obj.getSci_fi().intValue() == 1)
				genre.add("Sci-fi");
			if(obj.getThriller().intValue() == 1)
				genre.add("Thriller");
			if(obj.getWar().intValue() == 1)
				genre.add("War");
			if(obj.getWestern().intValue() == 1)
				genre.add("Western");
			return genre;
	}
	
	
	
	public final CategoryContentAvailabilityDto getContent(Integer contentId)
	{
		CategoryContentAvailabilityDto content;
		CategoryContentDto catContent = contentRepo.fetchCategoryContentJoinById(contentId);
		ContentAvailabilityDto contAvail = contentRepo.fetchContentAndAvailabilityJoinById(contentId);
		ContentGenreDto contGenre = contentRepo.fetchContentGenreJoinById(contentId);
		String categoryName = catContent.getCategoryName();
		String movie = contAvail.getMovie();
		String year = contAvail.getYear();
		String runtime = contAvail.getRuntime();
		List<String> genre = getGenre(contGenre);
		String ratings = contAvail.getRatings();
		String description = contAvail.getDescription();
		String coverImg = contAvail.getCoverImg();
		String hotstar = contAvail.getHotstar();
		String amazonPrime = contAvail.getAmazonPrime();
		String netflix = contAvail.getNetflix();
		content = new CategoryContentAvailabilityDto(contentId,categoryName,movie,year,runtime,genre,ratings,description,coverImg,hotstar,amazonPrime,netflix);	
		
		return content;
	}
	
	public final Genre getGenreObj(Integer genreId,List<String> genres)
	{
		Genre genre;
		Integer comedy = 0; 
		Integer drama = 0;
		Integer romance = 0;
		Integer action = 0;
		Integer sci_fi = 0;
		Integer adventure = 0;
		Integer thriller = 0;
		Integer history = 0;
		Integer crime = 0;
		Integer mystery = 0;
		Integer biography = 0;
		Integer musical = 0;
		Integer horror = 0;
		Integer western = 0;
		Integer war = 0;
		Integer fantasy = 0;
		int i;
		for(i=0;i<genres.size();i++)
		{
			if(genres.get(i).equals("comedy"))
				comedy = 1;
			else if(genres.get(i).equals("drama"))
				drama = 1;
			else if(genres.get(i).equals("romance"))
				romance = 1;
			else if(genres.get(i).equals("action"))
				action = 1;
			else if(genres.get(i).equals("sci_fi"))
				sci_fi = 1;
			else if(genres.get(i).equals("adventure"))
				adventure = 1;
			else if(genres.get(i).equals("thriller"))
				thriller = 1;
			else if(genres.get(i).equals("history"))
				history = 1;
			else if(genres.get(i).equals("crime"))
				crime = 1;
			else if(genres.get(i).equals("mystery"))
				mystery = 1;
			else if(genres.get(i).equals("biography"))
				biography = 1;
			else if(genres.get(i).equals("musical"))
				musical = 1;
			else if(genres.get(i).equals("horror"))
				horror = 1;
			else if(genres.get(i).equals("western"))
				western = 1;
			else if(genres.get(i).equals("war"))
				war = 1;
			else if(genres.get(i).equals("comedy"))
				fantasy = 1;
		}
		genre = new Genre(genreId,comedy,drama,romance,action,sci_fi,adventure,thriller,history,crime,mystery,biography,musical,horror,western,war,fantasy);
		return genre;
	}
}
