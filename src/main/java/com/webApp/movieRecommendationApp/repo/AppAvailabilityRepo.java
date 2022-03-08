package com.webApp.movieRecommendationApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webApp.movieRecommendationApp.entity.Availability;

@Repository
public interface AppAvailabilityRepo extends JpaRepository<Availability, Integer> {
	
	@Query("SELECT MAX(id) FROM Availability")
	public Integer findLastAvailabilityId();

	@Transactional
	@Modifying
	@Query("UPDATE Availability SET hotstar=?2,amazonPrime=?3,netflix=?4 WHERE id=?1")
	public void updateAvailability(Integer id,String hotstar,String amazonPrime,String netflix);
}
