package com.webApp.movieRecommendationApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webApp.movieRecommendationApp.entity.UsersWatch;

@Repository
public interface AppUsersWatchedRepo extends JpaRepository<UsersWatch, Integer>{

}
