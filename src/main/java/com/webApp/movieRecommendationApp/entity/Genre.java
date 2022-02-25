package com.webApp.movieRecommendationApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Genre {
	
	@Id
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer id;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer comedy; 
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer drama;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer romance;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer action;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer sci_fi;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer adventure;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer thriller;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer history;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer crime;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer mystery;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer biography;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer musical;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer horror;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer western;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer war;
	
	@Column(columnDefinition="int(11) NOT NULL")
	private Integer fantasy;
	
	/*@OneToOne(fetch = FetchType.LAZY,mappedBy="genre")
	private Content content;
	*/
	
	
	

	public Genre(Integer id, Integer comedy, Integer drama, Integer romance, Integer action, Integer sci_fi,
			Integer adventure, Integer thriller, Integer history, Integer crime, Integer mystery, Integer biography,
			Integer musical, Integer horror, Integer western, Integer war, Integer fantasy) {
		super();
		this.id = id;
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

	public Genre() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
