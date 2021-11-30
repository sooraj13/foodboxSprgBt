package com.foodbox.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="USER_DETAILS")
public class UserDetail {
	
	@ApiModelProperty(notes = "User Email Id",name="email",required=true,value="test email")
	@Id
	private String email;
	
	private String userName;
	
	private String phoneNr;
	
	//@JsonIgnore
	private String password;
	
	
	public UserDetail() {
		super();
	}
	
	public UserDetail(String email, String userName, String phoneNr, String password) {
		super();
		this.email = email;
		this.userName = userName;
		this.phoneNr = phoneNr;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
