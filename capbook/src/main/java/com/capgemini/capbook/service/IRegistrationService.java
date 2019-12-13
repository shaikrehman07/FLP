package com.capgemini.capbook.service;

import java.util.List;

import com.capgemini.capbook.exceptions.UserException;
import com.capgemini.capbook.model.Registration;

public interface IRegistrationService {
	
	 public List<Registration> getAllRegistrations();
	 public void addRegistration(Registration registration);
	 public Registration getUser(String email,String password) throws UserException;

}
