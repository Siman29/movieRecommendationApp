package com.webApp.movieRecommendationApp.dto;

import javax.persistence.Column;

public class ContentGenreDto {
	
	private Integer contentId;
	private Integer comedy; 
	private Integer drama;
	private Integer romance;
	private Integer action;
	private Integer sci_fi;
	private Integer adventure;
	private Integer thriller;
	private Integer history;
	private Integer crime;
	private Integer mystery;
	private Integer biography;
	private Integer musical;
	private Integer horror;
	private Integer western;
	private Integer war;
	private Integer fantasy;
	
	
	
	public ContentGenreDto(Integer contentId, Integer comedy, Integer drama, Integer romance, Integer action,
			Integer sci_fi, Integer adventure, Integer thriller, Integer history, Integer crime, Integer mystery,
			Integer biography, Integer musical, Integer horror, Integer western, Integer war, Integer fantasy) {
		super();
		this.contentId = contentId;
		this.comedy = comedy;
		this.drama = drama;
		this.romance = romance;
		this.action = action;
		this.sci_fi = sci_fi;
		this.adventure = adventure;
		this.thriller = thriller;
		this.history = history;
		this.crime = crime;
		this.mystery = mystery;
		this.biography = biography;
		this.musical = musical;
		this.horror = horror;
		this.western = western;
		this.war = war;
		this.fantasy = fantasy;
	}
	public Integer getContentId() {
		return contentId;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public Integer getComedy() {
		return comedy;
	}
	public void setComedy(Integer comedy) {
		this.comedy = comedy;
	}
	public Integer getDrama() {
		return drama;
	}
	public void setDrama(Integer drama) {
		this.drama = drama;
	}
	public Integer getRomance() {
		return romance;
	}
	public void setRomance(Integer romance) {
		this.romance = romance;
	}
	public Integer getAction() {
		return action;
	}
	public void setAction(Integer action) {
		this.action = action;
	}
	public Integer getSci_fi() {
		return sci_fi;
	}
	public void setSci_fi(Integer sci_fi) {
		this.sci_fi = sci_fi;
	}
	public Integer getAdventure() {
		return adventure;
	}
	public void setAdventure(Integer adventure) {
		this.adventure = adventure;
	}
	public Integer getThriller() {
		return thriller;
	}
	public void setThriller(Integer thriller) {
		this.thriller = thriller;
	}
	public Integer getHistory() {
		return history;
	}
	public void setHistory(Integer history) {
		this.history = history;
	}
	public Integer getCrime() {
		return crime;
	}
	public void setCrime(Integer crime) {
		this.crime = crime;
	}
	public Integer getMystery() {
		return mystery;
	}
	public void setMystery(Integer mystery) {
		this.mystery = mystery;
	}
	public Integer getBiography() {
		return biography;
	}
	public void setBiography(Integer biography) {
		this.biography = biography;
	}
	public Integer getMusical() {
		return musical;
	}
	public void setMusical(Integer musical) {
		this.musical = musical;
	}
	public Integer getHorror() {
		return horror;
	}
	public void setHorror(Integer horror) {
		this.horror = horror;
	}
	public Integer getWestern() {
		return western;
	}
	public void setWestern(Integer western) {
		this.western = western;
	}
	public Integer getWar() {
		return war;
	}
	public void setWar(Integer war) {
		this.war = war;
	}
	public Integer getFantasy() {
		return fantasy;
	}
	public void setFantasy(Integer fantasy) {
		this.fantasy = fantasy;
	}
	
	
}
