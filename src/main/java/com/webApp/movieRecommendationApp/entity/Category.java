package com.webApp.movieRecommendationApp.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	
	@Id
	@Column(columnDefinition = "int(11) NOT NULL")
	private Integer id;
	
	@Column(columnDefinition="varchar(100) NOT NULL")
	private String title;
	
	@Column(columnDefinition="enum('Active','Suspend') NOT NULL")
	private String status;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "category")
	private List<Content> contents;
	
	
	public Category() {
		super();
	}

	public Category(Integer id, String title, String status) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Content> getContents() {
		return contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	
	
	
	
}
