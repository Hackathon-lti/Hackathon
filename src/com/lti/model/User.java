package com.lti.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
	@Table(name = "Usersexam")
	public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "password")
	private String password;

	@Column(name = "phone_no")
	private int phoneNo;

	@Column(name = "city")
	private String city;
	
	@Column(name = "State")
	private String State;
	
	@Column(name = "Qualification")
	private String qualification;
	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<Question> q;*/
	
@OneToOne
private Exam examdetails;

	public User() {
		super();
	}
	public User(String userName, String userEmail, String password, int phoneNo, String city, String state,
			String qualification) {
		super();
		
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.phoneNo = phoneNo;
		this.city = city;
		State = state;
		this.qualification = qualification;
	}






	public void setUserId(int userId) {
	this.userId = userId;
	}

	public int getUserId() {
	return userId;
	}

	public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
	}

	public String getUserEmail() {
	return userEmail;
	}

	public void setUserName(String userName) {
	this.userName = userName;
	}

	public String getUserName() {
	return userName;
	}

	public void setPassword(String password) {
	this.password = password;
	}

	public String getPassword() {
	return password;
	}

	public void setPhoneNo(int phoneNo) {
	this.phoneNo = phoneNo;
	}

	public int getPhoneNo() {
	return phoneNo;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", password="
				+ password + ", phoneNo=" + phoneNo + ", city=" + city + ", State=" + State + ", qualification="
				+ qualification + "]";
	}

	

	

	
	}

