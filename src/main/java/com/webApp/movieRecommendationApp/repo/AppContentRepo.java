package com.webApp.movieRecommendationApp.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
	
	@Query("SELECT id FROM Content")
	public List<Integer> fetchContentId();
	

	@Transactional
	@Modifying
	@Query("UPDATE Content SET ratings=?2,description=?3,coverImg=?4 WHERE id=?1")
	public void updateContent(Integer id,String ratings,String description,String coverImg);
	
	
}
