package com.webApp.movieRecommendationApp.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webApp.movieRecommendationApp.dto.CategoryContentAvailabilityDto;
import com.webApp.movieRecommendationApp.dto.CategoryContentDto;
import com.webApp.movieRecommendationApp.dto.ContentAvailabilityDto;
import com.webApp.movieRecommendationApp.dto.ContentGenreDto;
import com.webApp.movieRecommendationApp.entity.Content;

@EnableJpaRepositories
@Repository
public interface AppContentRepo extends JpaRepository<Content, Integer> 
{
	List<Content> findByCategoryId(Integer categoryId);
	
	List<Content> findByRatings(String rating);
	
	public List<Content> findByMovie(String movie);
	
	@Query("SELECT MAX(id) FROM Content")
	public Integer findLastContentId();
	
	
	@Query("SELECT new com.webApp.movieRecommendationApp.dto.CategoryContentDto(c.id,ca.title) FROM "
			+ "Content c INNER JOIN Category ca ON c.category.id = ca.id")
	public List<CategoryContentDto> fetchCategoryContentJoin();
	
	@Query("SELECT new com.webApp.movieRecommendationApp.dto.ContentAvailabilityDto(c.id,c.movie,c.year,c.runtime,\r\n"
			+"c.ratings,c.description,c.coverImg,a.hotstar,a.amazonPrime,a.netflix) FROM"
			+ "Content c INNER JOIN Availability a ON c.availability.id = a.id")
	public List<ContentAvailabilityDto> fetchContentAndAvailabilityJoin();
	
	@Query("SELECT new com.webApp.movieRecommendationApp.dto.ContentGenreDto(c.id,g.comedy,g.drama,g.romance,g.action,g.sci_fi,\r\n"
			+ "g.adventure,g.thriller,g.history,g.crime,g.mystery,g.biography,\r\n"
			+ "g.musical,g.horror,g.western,g.war,g.fantasy) FROM"
			+ "Content c INNER JOIN Genre g ON c.genre.id = g.id")
	public List<ContentGenreDto> fetchContentGenreJoin();
	
	
	
	/*@Query("SELECT new com.webApp.movieRecommendationApp.dto.CategoryContentAvailabilityDto(co.id,ca.title,co.movie,co.year,co.runtime,co.genre,co.ratings,co.description,co.coverImg,a.hotstar,a.amazonPrime,a.netflix)"
			+ "FROM Category ca,Content co,Availability a WHERE ca.id = co.categoryId and co.id = a.contentId")
	public List<CategoryContentAvailabilityDto> fetchCategoryContentAvailabilityJoin();
	
	@Query("SELECT new com.webApp.movieRecommendationApp.dto.CategoryContentAvailabilityDto(co.id,ca.title,co.movie,co.year,co.runtime,co.genre,co.ratings,co.description,co.coverImg,a.hotstar,a.amazonPrime,a.netflix)"
			+ "FROM Category ca,Content co,Availability a WHERE ca.id = co.categoryId and co.id = a.contentId and co.id = ?1")
	public CategoryContentAvailabilityDto fetchCategoryContentAvailabilityById(Integer id);
	
	@Query("SELECT new com.webApp.movieRecommendationApp.dto.CategoryContentAvailabilityDto(co.id,ca.title,co.movie,co.year,co.runtime,co.genre,co.ratings,co.description,co.coverImg,a.hotstar,a.amazonPrime,a.netflix)"
			+ "FROM Category ca,Content co,Availability a WHERE ca.id = co.categoryId and co.id = a.contentId and co.categoryId = ?1")
	public List<CategoryContentAvailabilityDto> fetchCategoryContentAvailabilityByCategoryId(Integer id);*/
	
	@Transactional
	@Modifying
	@Query("UPDATE Content SET ratings=?2,description=?3,coverImg=?4 WHERE id=?1")
	public void updateContent(Integer id,String ratings,String description,String coverImg);
	
	
}
