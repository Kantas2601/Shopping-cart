package com.Kamal.ProjectTrial2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Kamal.ProjectTrial2.UserDetails.User;
import com.Kamal.ProjectTrial2.UserDetails.UserDetails;

@RestController
public class ControllerClass {
	
	@Autowired
	private UserDetails userDetails;
	
	 /* 
	  * Here use phone as password to LOGIN
	  
	  */
	 // Data need to be send through x-www-form-urlencoded post
	 @RequestMapping(value ="/login", method=RequestMethod.POST)
	 public ResponseEntity<String> vaildateUser(@RequestParam(name="email") String email,@RequestParam(name="password") String password) {
		 System.out.println(email);
		 System.out.println(password);
		 
		 if(this.userDetails.validatelogin(email, password)) {
			 return new ResponseEntity<>("User Validation is Valid", HttpStatus.OK);
		 }else
			 return new ResponseEntity<>("User Validation is Invalid",HttpStatus.BAD_REQUEST);
	 }
	
	@PostMapping("/SignUp")
	public User addUser(@RequestBody User user) {
		return this.userDetails.addUser(user);
	}
	// To save the updated profile
	@PostMapping("/updateProfile")
	public User updateUser(@RequestBody User user) {
		return this.userDetails.addUser(user);
	}
	
	// To fetch list of allprofiles in database
	@RequestMapping("/getprofiles")
	public List<User> getProfilesOfAll(){
		return this.userDetails.getProfiles();
		
	}
	
	// To Fetch User by his Id
	 @GetMapping("/getprofiles/{userId}")
	 public User usersearch(@PathVariable String userId) {
		 System.out.println(userId);
	 return this.userDetails.SearchUser(Long.parseLong(userId)); 
	 }
	 
	 
	
	 
	 
	 
	

}
