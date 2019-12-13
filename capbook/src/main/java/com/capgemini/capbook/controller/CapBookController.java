package com.capgemini.capbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capbook.exceptions.UserException;
import com.capgemini.capbook.model.CapComments;
import com.capgemini.capbook.model.FriendRequest;
import com.capgemini.capbook.model.HomePage;
import com.capgemini.capbook.model.PictureStatus;
import com.capgemini.capbook.model.ProfilePicture;
import com.capgemini.capbook.model.Registration;
import com.capgemini.capbook.repository.PicturesRepo;
import com.capgemini.capbook.service.FriendRequestService;
import com.capgemini.capbook.service.RegistrationService;
import com.capgemini.capbook.service.UserPageService;

@CrossOrigin(origins="http://localhost:4200") 
@RestController
public class CapBookController {
	@Autowired  
    private RegistrationService registrationService; 
	
	@Autowired
	private UserPageService userService;
	
	
	
    @RequestMapping("/")  
    public List<Registration> getAllRegistration(){  
        return registrationService.getAllRegistrations();  
    }     

    @RequestMapping(value="/add", method=RequestMethod.POST)  
    public void addRegistration(@RequestBody Registration registration){  
        registrationService.addRegistration(registration);  
    }  
  @RequestMapping(value="/{id}", method=RequestMethod.GET)  
    public Optional<Registration> updateRegistration(@PathVariable String id){  
        return registrationService.getRegistration(id);  
    } 
  /*@RequestMapping(value="/registration/{id}", method=RequestMethod.DELETE)  
  public void deleteRegistration(@PathVariable String id){  
      registrationService.delete(id);  
  } */
    
    @RequestMapping(value="/{email}/{password}", method=RequestMethod.GET) 
    public Registration getUser(@PathVariable String email,@PathVariable String password) throws UserException
    {
    	return registrationService.getUser(email, password);
    }
    @RequestMapping(value="/{email}/forgot/{password}") 
    public Registration getUser1(@PathVariable String email,@PathVariable String password) throws UserException
    {
    	return registrationService.getUser1(email, password);
    }
    
    @PutMapping("/{email}/{password}")
	public void changePass(@PathVariable String email,@RequestBody Registration pwd,@PathVariable String password) throws Exception
	{
		registrationService.changePass(email, pwd, password);
		
	}
    @PutMapping("/{email}/forgot/{password}")
	public void forgotPass1(@PathVariable String email,@RequestBody Registration pwd,@PathVariable String password) throws Exception
	{
		registrationService.forgotPass1(email, pwd, password);
		
	}
    
    //--------Friend Request-----------------

    	@Autowired
    	private FriendRequestService friendService;
    	
    	
    	@PostMapping("/addfriend")
    	public void saveReq(@RequestBody FriendRequest friendReq)
    	{
    		friendService.saveRequest(friendReq);
    	}
    	
    	@GetMapping("/addfriend/{toName}")
    	public List<String> getAllRequest(@PathVariable String toName){
    		return friendService.getAllRequest(toName);
    	}
    	
    	@DeleteMapping("/delete/{fromName}/{toNam}")
    	public void remove(@PathVariable String fromName,@PathVariable String toNam) {
    		friendService.remove(fromName,toNam);
    	}
    	
    	@PutMapping("/accept/{fromName}")
    	public void acceptRequest(@PathVariable String fromName,@RequestBody FriendRequest friendReq) {
    		friendService.acceptReq(fromName,friendReq);
    	}
    	
    	@GetMapping("/getFriends/{name}")
    	public HashSet<String> getFriendList(@PathVariable String name)
    	{
    		return friendService.getFriendList(name) ;
    	}
    	
    	@GetMapping("/getAll/{email}")
    	public List<Registration> getAllUser(@PathVariable String email) throws Exception
    	{
    		return registrationService.getAll(email);
    	}
    	
    	//------for profile------
    	 @RequestMapping("/profile")
    	   public List<ProfilePicture> getProfile(){
    	       return userService.getProfile();
    	   }
    	  
    	   @RequestMapping(value="/profile",method=RequestMethod.POST)
    	   public void addProfile(@RequestBody ProfilePicture profile)
    	       {
    		   userService.addProfile(profile);
    	      
    	   }
    	   @PutMapping("/update")
    	   public void update(@RequestBody ProfilePicture profile) {
    		   userService.update(profile);
    	   }
    	   
    	   //-------for status in text-------
    	   @RequestMapping("/posttext")
    	   public List<HomePage> getAllStatusInText(){
    		     return userService.getAllStatusInText();
    		  }
    		 
    		 
    	   @PostMapping(value="/posttext")
    	   public void postStatusInText(@RequestBody HomePage hp)
    	       {
    		   userService.postStatusInText(hp);
    	      
    	   }
    	  
    	   
    	   @DeleteMapping(value="/deletestatus/{id}")
    	   public void deleteStatus(@PathVariable int id) {
    		   userService.removeStatus(id);
    	   }
    	   
     //-------------for picture status--------------
    			
    			@GetMapping("/picture")
    			   public List<PictureStatus> getPictures(){
    				
    				return userService.getPictures();   
    			   }
    			   
    			   @PostMapping("/picture")
    			   public void addPicture(@RequestBody PictureStatus pictures) {
    				   userService.addPic(pictures);
    			   }
    			   @DeleteMapping("/delete/{id}")
    			   public void deletePicture(@PathVariable int id) {
    				   userService.deletePicture(id);
    			   }
  //---for comments ---------
    			   @GetMapping("/comment")
    			   public List<CapComments> getCapComments(){
    				 
    				   return userService.getCapComments() ;
    			   }
    			   
    			   @PostMapping(value="/comment")
    			   public void postCommentInText(@RequestBody CapComments com)
    			   {
    				
    			   userService.postCommentInText(com);
    			  
    			}
    //----------for search-------
    			   @GetMapping("/search/{name}")
    			   public List<String>  search(@PathVariable String name)
    			   {
    				   return userService.search(name);
    			   }
    			   
    			   //--------view profile-------
    			   @GetMapping("/check/{email1}/{email2}")
    			   public boolean check(@PathVariable String email1,@PathVariable String email2)
    			   {
    				   return friendService.check(email1, email2);
    			   }
}
