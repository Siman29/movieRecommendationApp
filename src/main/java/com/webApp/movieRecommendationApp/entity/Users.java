package com.webApp.movieRecommendationApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users {
	
	@Id
	@Column(columnDefinition = "int(11) NOT NULL")
	private Integer id;
	
	@Column(columnDefinition="varchar(255) NOT NULL")
	private String firstName;
	
	@Column(columnDefinition="varchar(255) NOT NULL")
	private String lastName;
	
	@Column(columnDefinition="varchar(255) NOT NULL")
	private String mailId;
	
	@Column(columnDefinition="bigint(20) NOT NULL")
	private Long phoneNo;
	
	@Column(columnDefinition="varchar(255) NOT NULL")
	private String password;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<UsersWatch> watched;
	
	
	public Users() {}
	
	public Users(String firstName, String lastName, String mailId, Long phoneNo, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailId = mailId;
		this.phoneNo = phoneNo;
		this.password = password;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mailId=" + mailId
				+ ", phoneNo=" + phoneNo + ", password=" + password + "]";
	}

	public List<UsersWatch> getWatched() {
		return watched;
	}

	public void setWatched(List<UsersWatch> watched) {
		this.watched = watched;
	}
	
	
	
	

}
