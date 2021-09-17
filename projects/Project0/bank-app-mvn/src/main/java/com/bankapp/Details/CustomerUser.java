package com.bankapp.Details;

public class CustomerUser {
	private String firstName;
	private String lastName;
	private String emailid;
	private String Password;

	public CustomerUser(String firstName, String lastName, String emailid, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailid = emailid;
		Password = password;
	}
	public CustomerUser() {
		super();
	}
	
	public CustomerUser(String emailid, String password) {
		super();
		this.emailid = emailid;
		Password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		lastName = lastName;
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
