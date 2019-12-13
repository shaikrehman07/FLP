package com.capgemini.capbook.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Registration {

	
	private String firstName;
	private String lastName;
	@Id
	private String email;
	private String password;
	private String phoneNumber;
	private String gender;
	private String dob;
	private String sec_ques;
	
	public String getSec_ques() {
		return sec_ques;
	}

	public void setSec_ques(String sec_ques) {
		this.sec_ques = sec_ques;
	}

	public Registration(String firstName, String lastName, String email, String password, String phoneNumber,
			String gender, String dob,String sec_ques) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.dob = dob;
		this.sec_ques = sec_ques;
	}

	
	

	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	
	public Registration() {
		super();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	

	
	
}
