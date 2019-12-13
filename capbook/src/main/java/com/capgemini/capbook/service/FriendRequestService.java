package com.capgemini.capbook.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capbook.model.FriendRequest;
import com.capgemini.capbook.model.Registration;
import com.capgemini.capbook.repository.FriendRequestRepo;

@Service
public class FriendRequestService {
	
	@Autowired
	private FriendRequestRepo friendRepo;


	public void saveRequest(FriendRequest friendReq) 
	{
		friendRepo.save(friendReq);	
	}

	public List<String> getAllRequest(String toName) {
		// TODO Auto-generated method stub
		List<FriendRequest> requests= friendRepo.findAll();
		List<String> list=new ArrayList<>();
		for(FriendRequest fr : requests) {
			if(fr.getToName().equals(toName) && fr.getFriendStatus()==1) {
				list.add(fr.getFromName());
			}
		}
		return list;
	}

	

	public void remove(String fromName, String toNam) {
		// TODO Auto-generated method stub
		List<FriendRequest> requests = friendRepo.findAll();
		for(FriendRequest fr : requests ) {
			if(fr.getFromName().equals(fromName) && fr.getToName().equals(toNam)) {
				friendRepo.deleteById(fr.getId());
			}
		}
	}

	public void acceptReq(String fromName, FriendRequest friendReq) {
		List<FriendRequest> requests = friendRepo.findAll();
		for(FriendRequest fr : requests) {
			if(fr.getFromName().equals(fromName) && fr.getToName().equals(friendReq.getToName())) {
				int id=fr.getId();
				friendReq.setId(id);
				friendRepo.save(friendReq);
			}
		}
	}

	public HashSet<String> getFriendList(String name) 
	{
		List<FriendRequest> request = friendRepo.findAll();
		HashSet<String> friends = new HashSet<>(); 
		for(FriendRequest fr : request)
		{
			if(fr.getFriendStatus() == 2)
			{
				if(fr.getFromName().equalsIgnoreCase(name))
				{
					friends.add(fr.getToName());
				}
				if((fr.getToName().equalsIgnoreCase(name)))
				{
					friends.add(fr.getFromName());
				}
			}
		}
		
		return friends;
	}
	
	public boolean check(String email1,String email2)
	{
		List<FriendRequest> request = friendRepo.findAll();
		for(FriendRequest f:request)
		{
			if(f.getFriendStatus()==2)
			{
				if(f.getFromName().equalsIgnoreCase(email1) && (f.getToName().equalsIgnoreCase(email2)))
						{
					       return true;
						}
				if(f.getFromName().equalsIgnoreCase(email2) && (f.getToName().equalsIgnoreCase(email1)))
				{
			       return true;
				}
			}
		}
		return false;
	}
	
	


}
