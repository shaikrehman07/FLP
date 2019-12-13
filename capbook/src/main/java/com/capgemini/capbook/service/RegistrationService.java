package com.capgemini.capbook.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capbook.exceptions.UserException;
import com.capgemini.capbook.model.FriendRequest;
import com.capgemini.capbook.model.Registration;
import com.capgemini.capbook.repository.FriendRequestRepo;
import com.capgemini.capbook.repository.RegistrationRepository;

@Service
public class RegistrationService implements IRegistrationService{
	@Autowired  
    private RegistrationRepository registrationRepository;
	
	@Autowired  
    private FriendRequestRepo friendRepository;  
	
    public List<Registration> getAllRegistrations(){  
        List<Registration>registrations = new ArrayList<>();  
        registrationRepository.findAll().forEach(registrations::add);  
        return registrations;  
    }  
    public Optional<Registration> getRegistration(String id){  
        return registrationRepository.findById(id);  
    } 
    public void addRegistration(Registration registration){ 
    	String pass = registration.getPassword();
		String encodedString = Base64.getEncoder().encodeToString(pass.getBytes()); 
		registration.setPassword(encodedString);
        registrationRepository.save(registration);  
    }  
    /*public void delete(String id){  
        registrationRepository.deleteById(id);
    } */
    
    public Registration getUser(String email,String password) throws UserException
    {
    	List<Registration> user = new ArrayList<>();
          user =  getAllRegistrations();
    	boolean b = false;
    	
    	for(Registration u: user)
    	{
    		byte[] actualByte = Base64.getDecoder() .decode(u.getPassword()); 
			String actualString = new String(actualByte);
			
    		if(u.getEmail().equals(email) && (actualString.equals(password) && actualString!=null))
    		{
    			return u;
    		}
    	}
   
    	if(b==false) {
    		throw new UserException("data not found");
    	}
    	
    	return null;
    }
    
    public Registration getUser1(String email,String answer) throws UserException
    {
    	List<Registration> user = new ArrayList<>();
          user =  getAllRegistrations();
    	boolean b = false;
    	
    	for(Registration u: user)
    	{
    		
			
    		if(u.getEmail().equals(email) && (u.getSec_ques().equals(answer)) && u.getSec_ques()!=null)
    		{
    			return u;
    		}
    	}
   
    	if(b==false) {
    		throw new UserException("data not found");
    	}
    	
    	return null;
    }
    
    public void changePass(String email,Registration oldPass,  String newPass) 
	{
		System.out.println("service");
		List<Registration> cp = getAllRegistrations();
		for(Registration pwd : cp) 
		{
			if(pwd.getEmail().equalsIgnoreCase(email))
			{
				byte[] actualByte = Base64.getDecoder().decode(pwd.getPassword()); 
				String actualString = new String(actualByte); 
				if(actualString.equals(oldPass.getPassword()))
				{
					String encodedString = Base64.getEncoder().encodeToString(newPass.getBytes());
					pwd.setPassword(encodedString);
					registrationRepository.save(pwd);
				}
			}
		}
	}
    
    public void forgotPass1(String email,Registration oldPass,  String newPass) 
   	{
   		System.out.println("service");
   		List<Registration> cp = getAllRegistrations();
   		for(Registration pwd : cp) 
   		{
   			if(pwd.getEmail().equalsIgnoreCase(email))
   			{
   				
   					String encodedString = Base64.getEncoder().encodeToString(newPass.getBytes());
   					pwd.setPassword(encodedString);
   					registrationRepository.save(pwd);
   				
   			}
   		}
   	}
    
    public List<Registration> getAll(String email) 
    {
        List<Registration> login = (List<Registration>) registrationRepository.findAll();
        for(Registration l1 : login) {
            
            byte[] actualByte = Base64.getDecoder() 
                    .decode(l1.getPassword()); 

 

                String actualString = new String(actualByte); 
                l1.setPassword(actualString);

 

        }
        
        
        List<FriendRequest> friends = friendRepository.findAll();
        List<String> log =new ArrayList<String>();
        for(FriendRequest f : friends) {
            if(f.getFromName().equals(email)) {
                log.add(f.getToName());
            }
            else if(f.getToName().equals(email)) {
                log.add(f.getFromName());
            }
        }
        System.out.println(log);
        
        
        for(int i=0;i<login.size();i++) {
            Registration l=login.get(i);
            for(int j=0;j<log.size();j++) {
                String s = log.get(j);
                //System.out.println(l.getUsername()+" "+s);
                if(l.getEmail().equals(s)) {
                    //System.out.println("qwqwgggfgf"+""+l.getUsername()+" "+s);
                    login.remove(i);
                    break;
                }
                
            }
            //System.out.println(l.getUsername());
        }
        
        return login;
        
    }
}
