package com.capgemini.capbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PictureStatus {
	
	@Id
	@GeneratedValue
	private int id;
	private String email;
	private String location;

	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public PictureStatus( String location) {
		super();

		this.location = location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PictureStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

}
