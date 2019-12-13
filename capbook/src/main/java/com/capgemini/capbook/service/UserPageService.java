package com.capgemini.capbook.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capbook.model.CapComments;
import com.capgemini.capbook.model.HomePage;
import com.capgemini.capbook.model.PictureStatus;
import com.capgemini.capbook.model.ProfilePicture;
import com.capgemini.capbook.model.Registration;
import com.capgemini.capbook.repository.CommentsRepo;
import com.capgemini.capbook.repository.HomePageRepo;
import com.capgemini.capbook.repository.PicturesRepo;
import com.capgemini.capbook.repository.UserPageRepo;

@Service
public class UserPageService {
	
	@Autowired
	private UserPageRepo userRepo;
	
	@Autowired
	private HomePageRepo homepageRepo;
	
	@Autowired
	private PicturesRepo pictureRepo;
	
	@Autowired
	private CommentsRepo commentRepo;
	
	@Autowired
	private RegistrationService registrationService;
	
	//-----for profile pic add and change-------
		public List<ProfilePicture> getProfile() {
			
			return (List<ProfilePicture>) userRepo.findAll();
		}

	   
		public void addProfile(ProfilePicture profile) {
			if(userRepo.existsById(profile.getEmail())) {
				userRepo.deleteAll();
			}
			userRepo.save(profile);
		}

	   
		public void update(ProfilePicture profile) {
			
			userRepo.save(profile);
		}
		
		//------------for statusIntext------
		
		public List<HomePage> getAllStatusInText() {
			List<HomePage> hmp = new LinkedList();
			
		   homepageRepo.findAll().forEach(hmp::add);
			Collections.reverse(hmp);
			return hmp;	
			}


	   
		public void postStatusInText(HomePage hp) {
			homepageRepo.save(hp);
			
		}
	    
	   
	    public void removeStatus(int id) {
	    	homepageRepo.deleteById(id);
	    }
	    
	    //----for pictures status--------
 	   public List<PictureStatus> getPictures() {
 			List<PictureStatus> hmp = new ArrayList();
 				
 				pictureRepo.findAll().forEach(hmp::add);
 				//Collections.reverse(hmp);
 				System.out.println(hmp);
 				return hmp;
 			}


 			public void addPic(PictureStatus pictures) {
 				// TODO Auto-generated method stub
 				pictureRepo.save(pictures);
 			}


 			public void deletePicture(int id) {
				List<PictureStatus> hmp = new ArrayList<>();
				pictureRepo.findAll().forEach(hmp::add);
				List<CapComments> cap=(List<CapComments>) commentRepo.findAll();
				System.out.println(cap);
				for(PictureStatus p : hmp)
				{
					System.out.println("hello");
					if(p.getId()==id)
					{
						System.out.println("hello hi");
						for(CapComments c:cap)
						{
							if(c.getLocation().equals(p.getLocation()))
							{
								System.out.println("hello121123");
								commentRepo.deleteById(c.getId());
							}
						}
				}				}
 				pictureRepo.deleteById(id);
 			}
 			
 			//------comments------
 			
 			public List<CapComments> getAllCommentInText() {
 				// TODO Auto-generated method stub
 		     List<CapComments> hmp = new LinkedList();
 				
 				commentRepo.findAll().forEach(hmp::add);
 				Collections.reverse(hmp);
 				return hmp;	
 				}


 			
 			public void postCommentInText(CapComments hp) {
 				// TODO Auto-generated method stub
 				List<PictureStatus> pictures = (List<PictureStatus>) pictureRepo.findAll();
 				commentRepo.save(hp);	
 			}


 			public List<CapComments> getCapComments() {
 				// TODO Auto-generated method stub
 				List<CapComments> cap=(List<CapComments>) commentRepo.findAll();
 				Collections.reverse(cap);
 				return cap;
 			}
 			
 			//---------search method---------
 			public List<String> search(String name)
 			{
 				List<Registration> fname = registrationService.getAllRegistrations();
 				List<String> names= new ArrayList<>();
 				 for(Registration r: fname) {
 				if(name!=null)
 				{
 					if(r.getFirstName().toLowerCase().contains(name) || r.getFirstName().contains(name)|| r.getLastName().contains(name)) {
 						names.add(r.getEmail());
 					}
 				}
 			}return names;
 			}
}
