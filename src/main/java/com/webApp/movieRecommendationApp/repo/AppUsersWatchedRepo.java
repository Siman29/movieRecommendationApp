package com.webApp.movieRecommendationApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webApp.movieRecommendationApp.entity.UsersWatch;

@Repository
public interface AppUsersWatchedRepo extends JpaRepository<UsersWatch, Integer>{
	
	public List<UsersWatch> findByUserId(Integer userId);
	
	
	@Query("SELECT MAX(id) FROM UsersWatch")
	public Integer findLastId();

}
