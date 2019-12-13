package com.capgemini.capbook.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.capbook.model.CapComments;

public interface CommentsRepo extends CrudRepository<CapComments, Integer> {

}
