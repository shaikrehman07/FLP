package com.capgemini.capbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CapComments {
	@Id
	@GeneratedValue
	private int id;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String location;
	private String comments;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public CapComments(String email,String location, String comments) {
		super();
		this.email=email;
		this.location = location;
		this.comments = comments;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public CapComments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CapComments(String comments) {
		super();
		this.comments = comments;
	}
	

}