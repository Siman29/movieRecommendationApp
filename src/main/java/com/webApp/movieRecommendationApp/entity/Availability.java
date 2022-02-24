package com.webApp.movieRecommendationApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Availability {
	
	@Id
	@Column(columnDefinition = "int(11) NOT NULL")
	private Integer id;
	
	@Column(columnDefinition="enum('Yes','No') NOT NULL")
	private String hotstar;
	
	@Column(columnDefinition="enum('Yes','No') NOT NULL")
	private String amazonPrime;
	
	@Column(columnDefinition="enum('Yes','No') NOT NULL")
	private String netflix;
	
	
	
	public Availability() {
		super();
	}
	public Availability(Integer id, String hotstar, String amazonPrime, String netflix) {
		super();
		this.id = id;
		this.hotstar = hotstar;
		this.amazonPrime = amazonPrime;
		this.netflix = netflix;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
