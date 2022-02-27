package com.webApp.movieRecommendationApp.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Content {
	
	

	@Id
	@Column(columnDefinition = "int(11) NOT NULL")
	private Integer id;
	
	
	@Column(columnDefinition="varchar(200) NOT NULL")
	private String movie;
	
	@Column(columnDefinition="varchar(100) NOT NULL")
	private String year;
	
	@Column(columnDefinition="varchar(100) NOT NULL")
	private String runtime;
	
	@Column(columnDefinition="varchar(100) NOT NULL")
	private String ratings;
	
	@Column(columnDefinition="text NOT NULL")
	private String description;
	
	@Column(columnDefinition="text NOT NULL")
	private String coverImg;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="availability_id")
	private Availability availabilty;
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="genre_id")
	private Genre genre;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "content")
	private List<UsersWatch> usersWatched;
	
	
	public Content() {
		super();
	}
	
	public Content(Integer id, String movie, String year, String runtime,
			String ratings, String description, String coverImg) {
		this.id = id;
		this.movie = movie;
		this.year = year;
		this.runtime = runtime;
		this.ratings = ratings;
		this.description = description;
		this.coverImg = coverImg;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Availability getAvailabilty() {
		return availabilty;
	}

	public void setAvailabilty(Availability availabilty) {
		this.availabilty = availabilty;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<UsersWatch> getUsersWatched() {
		return usersWatched;
	}

	public void setUsersWatched(List<UsersWatch> usersWatched) {
		this.usersWatched = usersWatched;
	}
	
	
	
}
