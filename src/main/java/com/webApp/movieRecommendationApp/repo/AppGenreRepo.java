package com.webApp.movieRecommendationApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webApp.movieRecommendationApp.entity.Genre;

@Repository
public interface AppGenreRepo extends JpaRepository<Genre, Integer> {
	
	@Query("SELECT MAX(id) FROM Genre")
	public Integer findLastGenreId();

}
