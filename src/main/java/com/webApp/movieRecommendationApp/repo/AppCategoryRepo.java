package com.webApp.movieRecommendationApp.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webApp.movieRecommendationApp.entity.Category;

@Repository
public interface AppCategoryRepo extends JpaRepository<Category, Integer> {
	
	
}
