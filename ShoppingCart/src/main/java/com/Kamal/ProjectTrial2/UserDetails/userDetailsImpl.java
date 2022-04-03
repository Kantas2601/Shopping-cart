package com.Kamal.ProjectTrial2.UserDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kamal.ProjectTrial2.dao.UserDao;

@Service
public class userDetailsImpl implements UserDetails {
	
	@Autowired
	private UserDao userdao;

	@Override
	public User addUser(User user) {
		userdao.save(user);
		
		
		return user;
	}

	@Override
	public User SearchUser(long userID) {
		
		return userdao.findById(userID).get();
	}

	@Override
	public List<User> getProfiles() {
		return userdao.findAll();
	}

	@Override
	public boolean validatelogin(String email, String Password) {
		User u = userdao.validateUserIdByPhone(email, Password);
		if(u==null) {
			return false;
		}else 
			return true;
	}
	
	

}
