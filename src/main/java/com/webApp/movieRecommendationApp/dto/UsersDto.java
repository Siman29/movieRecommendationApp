package com.webApp.movieRecommendationApp.dto;

import java.util.List;


public class UsersDto {
	
	private Integer userId;
	private String firstName;
	private String lastName;
	private String mailId;
	private Long phoneNo;
	private String password;
	private List<String> watched;
	
	public UsersDto(Integer userId, String firstName, String lastName, String mailId, Long phoneNo,
			String password,
			List<String> watched) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailId = mailId;
		this.phoneNo = phoneNo;
		this.password = password;
		this.watched = watched;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getWatched() {
		return watched;
	}
	public void setWatched(List<String> watched) {
		this.watched = watched;
	}
	
	

}
