package com.webApp.movieRecommendationApp.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webApp.movieRecommendationApp.dto.CategoryContentAvailabilityDto;
import com.webApp.movieRecommendationApp.entity.Content;

@EnableJpaRepositories
@Repository
public interface AppContentRepo extends JpaRepository<Content, Long> 
{
	List<Content> findByCategoryId(Long categoryId);
	
	List<Content> findByRatings(String rating);
	
	public List<Content> findByMovie(String movie);
	
	@Query("SELECT MAX(id) FROM Content")
	public Long findLastContentId();
	
	@Query("SELECT new com.webApp.movieRecommendationApp.dto.CategoryContentAvailabilityDto(co.id,ca.title,co.movie,co.year,co.runtime,co.genre,co.ratings,co.description,co.coverImg,a.hotstar,a.amazonPrime,a.netflix)"
			+ "FROM Category ca,Content co,Availability a WHERE ca.id = co.categoryId and co.id = a.contentId")
	public List<CategoryContentAvailabilityDto> fetchCategoryContentAvailabilityJoin();
	
	@Query("SELECT new com.webApp.movieRecommendationApp.dto.CategoryContentAvailabilityDto(co.id,ca.title,co.movie,co.year,co.runtime,co.genre,co.ratings,co.description,co.coverImg,a.hotstar,a.amazonPrime,a.netflix)"
			+ "FROM Category ca,Content co,Availability a WHERE ca.id = co.categoryId and co.id = a.contentId and co.id = ?1")
	public CategoryContentAvailabilityDto fetchCategoryContentAvailabilityById(Long id);
	
	@Query("SELECT new com.webApp.movieRecommendationApp.dto.CategoryContentAvailabilityDto(co.id,ca.title,co.movie,co.year,co.runtime,co.genre,co.ratings,co.description,co.coverImg,a.hotstar,a.amazonPrime,a.netflix)"
			+ "FROM Category ca,Content co,Availability a WHERE ca.id = co.categoryId and co.id = a.contentId and co.categoryId = ?1")
	public List<CategoryContentAvailabilityDto> fetchCategoryContentAvailabilityByCategoryId(Long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Content SET ratings=?2,description=?3,coverImg=?4 WHERE id=?1")
	public void updateContent(Long id,String ratings,String description,String coverImg);
	
	
}
