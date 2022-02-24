package com.webApp.movieRecommendationApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webApp.movieRecommendationApp.entity.Users;

@Repository
public interface AppRepo extends JpaRepository<Users, Long>{
	
	Users findByMailIdAndPassword(String emailId,String password);
	Users findByMailId(String emailId);
	
	@Query("SELECT MAX(id) FROM Users")
	Long findLastUserId();

}
