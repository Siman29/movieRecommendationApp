package com.webApp.movieRecommendationApp.entity;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Content {
	
	

	@Id
	private Long id;
	private Long categoryId;
	private String movie;
	private String year;
	private String runtime;
	private String genre;
	private String ratings;
	private String description;
	private String coverImg;
	
	/*@OneToOne(targetEntity=Availability.class ,cascade=CascadeType.ALL)
	@JoinColumn(name="cont_avail_fk", referencedColumnName = "id")
	private List<Availability> availabilty;*/
	
	
	
	public Content() {}
	
	public Content(Long id, Long categoryId, String movie, String year, String runtime, String genre,
			String ratings, String description, String coverImg) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.movie = movie;
		this.year = year;
		this.runtime = runtime;
		this.genre = genre;
		this.ratings = ratings;
		this.description = description;
		this.coverImg = coverImg;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
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
	/*public List<Availability> getAvailabilty() {
		return availabilty;
	}
	public void setAvailabilty(List<Availability> availabilty) {
		this.availabilty = availabilty;
	}*/
	
}
