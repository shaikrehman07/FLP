package com.capgemini.capbook.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.capbook.model.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, String>{

}
