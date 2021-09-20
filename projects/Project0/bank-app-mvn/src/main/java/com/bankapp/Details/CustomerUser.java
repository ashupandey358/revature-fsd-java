package com.bankapp.Details;

public class CustomerUser {
	private int cid;
	private String firstName;
	private String lastName;
	private String emailid;
	private String Password;
	public CustomerUser() {
		super();
	}
	public CustomerUser(String firstName, String lastName, String emailid, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailid = emailid;
		Password = password;
	}
	public CustomerUser(int cid, String firstName, String lastName, String emailid, String password) {
		super();
		this.cid = cid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailid = emailid;
		Password = password;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
