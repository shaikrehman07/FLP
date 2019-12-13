package com.capgemini.capbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capbook.model.FriendRequest;

@Repository
public interface FriendRequestRepo extends JpaRepository<FriendRequest, Integer> 
{

}
