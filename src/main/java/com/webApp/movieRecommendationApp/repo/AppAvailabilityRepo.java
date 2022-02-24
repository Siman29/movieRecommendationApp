package com.webApp.movieRecommendationApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webApp.movieRecommendationApp.entity.Availability;

@Repository
public interface AppAvailabilityRepo extends JpaRepository<Availability, Long> {
	
	@Query("SELECT MAX(id) FROM Availability")
	public Long findLastAvailabilityId();
	
	@Query("SELECT id FROM Availability WHERE contentId = ?1")
	public Long findByContentId(Long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Availability SET hotstar=?2,amazonPrime=?3,netflix=?4 WHERE contentId=?1")
	public void updateAvailability(Long id,String hotstar,String amazonPrime,String netflix);
}
