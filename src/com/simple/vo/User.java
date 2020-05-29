package com.simple.vo;

import java.util.Date;

public class User {

	private String id;
	private String name;
	private String password;
	private String email;
	private String disabled;
	private Date userCreateDate;
	
	public User() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public Date getUserCreateDate() {
		return userCreateDate;
	}

	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}

	@Override
	public String toString() {
		return "User [disabled=" + disabled + ", email=" + email + ", id=" + id + ", name=" + name + ", password="
				+ password + ", userCreateDate=" + userCreateDate + "]";
	}

	
	
}