package com.Kamal.ProjectTrial2.UserDetails;

import java.util.List;

public interface UserDetails
{
	public User addUser(User user);
	
	public User SearchUser(long userID);
	
	public List<User> getProfiles();
	
	public boolean validatelogin(String email, String Password);

}
