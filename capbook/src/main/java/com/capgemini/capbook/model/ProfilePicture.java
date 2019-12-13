package com.capgemini.capbook.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfilePicture {
	
	@Id
	private String email;
	private String location;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ProfilePicture(String email, String location) {
		super();
		this.email = email;
		this.location = location;
	}
	public ProfilePicture() {
		super();
	
	}

}
