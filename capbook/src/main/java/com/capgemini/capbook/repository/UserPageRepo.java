package com.capgemini.capbook.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.capbook.model.ProfilePicture;

public interface UserPageRepo extends CrudRepository<ProfilePicture,String > {

}
