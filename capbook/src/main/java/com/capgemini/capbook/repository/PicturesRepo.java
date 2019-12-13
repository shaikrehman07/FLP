package com.capgemini.capbook.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.capbook.model.PictureStatus;

public interface PicturesRepo extends CrudRepository<PictureStatus,Integer> {

}
