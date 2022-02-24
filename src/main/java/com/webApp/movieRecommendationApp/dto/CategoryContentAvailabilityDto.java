package com.webApp.movieRecommendationApp.dto;

import java.util.List;

public class CategoryContentAvailabilityDto {
	
	private Integer contentId;
	private String categoryName;
	private String movie;
	private String year;
	private String runtime;
	private List<String> genre;
	private String ratings;
	private String description;
	private String coverImg;
	private String hotstar;
	private String amazonPrime;
	private String netflix;
	
	
	
	public CategoryContentAvailabilityDto(Integer contentId, String categoryName, String movie, String year,
			String runtime, List<String> genre, String ratings, String description, String coverImg, String hotstar,
			String amazonPrime, String netflix) {
		super();
		this.contentId = contentId;
		this.categoryName = categoryName;
		this.movie = movie;
		this.year = year;
		this.runtime = runtime;
		this.genre = genre;
		this.ratings = ratings;
		this.description = description;
		this.coverImg = coverImg;
		this.hotstar = hotstar;
		this.amazonPrime = amazonPrime;
		this.netflix = netflix;
	}
	public Integer getContentId() {
		return contentId;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public List<String> getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCoverImg() {
		return coverImg;
	}
	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
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
