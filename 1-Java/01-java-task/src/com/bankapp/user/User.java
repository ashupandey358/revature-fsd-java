package com.bankapp.user;

public class User {
	String FirstName;
	String LastName;
	String emailid;
	String Password;
	public User(String firstName, String lastName, String emailid, String password) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.emailid = emailid;
		Password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	

}
