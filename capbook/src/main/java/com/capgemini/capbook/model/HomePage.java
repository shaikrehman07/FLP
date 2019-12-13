package com.capgemini.capbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class HomePage {
	
	@Id
	@GeneratedValue
    private int id;
	
	private String email;
	
	private String statusInText;
	//private String commentInText;
	
	/*public String getCommentInText() {
		return commentInText;
	}
	public void setCommentInText(String commentInText) {
		this.commentInText = commentInText;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatusInText() {
		return statusInText;
	}
	public void setStatusInText(String statusInText) {
		this.statusInText = statusInText;
	}
	public HomePage() {
		super();
	
	}
    

}
