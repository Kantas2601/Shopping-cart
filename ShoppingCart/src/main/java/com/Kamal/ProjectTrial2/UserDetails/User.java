package com.Kamal.ProjectTrial2.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User 
{
	@Id
	private long userID;
	private String name;
	private String email;
	private String phone;
	/*
	 * @Autowired private Address address;
	 * 
	 * public Address getAddress() { return address; } public void
	 * setAddress(Address address) { this.address = address;
	 */

	public String getName() {
		return name;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
