package com.capgemini.capbook.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RequestMasterTable")
public class FriendRequest 
{
	@Id
	@GeneratedValue
	int id;
	
	@Column(length = 30)
	String fromName;
	
	@Column(length = 30)
	String toName;

	int friendStatus = 0;
	
	//Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public int getFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(int friendStatus) {
		this.friendStatus = friendStatus;
	}
	
	//Constructors

	public FriendRequest(int id, String fromName, String toName, int friendStatus) 
	{
		this.id = id;
		this.fromName = fromName;
		this.toName = toName;
		this.friendStatus = friendStatus;
	}

	public FriendRequest()
	{

	}

}