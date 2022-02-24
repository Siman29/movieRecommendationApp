package com.webApp.movieRecommendationApp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Availability {
	
	@Id
	private Long id;
	private Long contentId;
	private String hotstar;
	private String amazonPrime;
	private String netflix;
	
	
	
	public Availability() {
		
	}
	public Availability(Long id, Long contentId, String hotstar, String amazonPrime, String netflix) {
		super();
		this.id = id;
		this.contentId = contentId;
		this.hotstar = hotstar;
		this.amazonPrime = amazonPrime;
		this.netflix = netflix;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getContentId() {
		return contentId;
	}
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}
	public String getHotstar() {
		return hotstar;
	}
	public void setHotstar(String hotstar) {
		this.hotstar = hotstar;
	}
	public String getAmazonPrime() {
		return amazonPrime;
	}
	public void setAmazonPrime(String amazonPrime) {
		this.amazonPrime = amazonPrime;
	}
	public String getNetflix() {
		return netflix;
	}
	public void setNetflix(String netflix) {
		this.netflix = netflix;
	}
	
	
}
