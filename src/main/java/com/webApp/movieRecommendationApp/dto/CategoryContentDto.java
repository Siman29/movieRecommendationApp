package com.webApp.movieRecommendationApp.dto;

public class CategoryContentDto {
	
	private Integer contentId;
	private String categoryName;
	
	
	
	public CategoryContentDto(Integer contentId, String categoryName) {
		super();
		this.contentId = contentId;
		this.categoryName = categoryName;
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
	
	
	
	

}
