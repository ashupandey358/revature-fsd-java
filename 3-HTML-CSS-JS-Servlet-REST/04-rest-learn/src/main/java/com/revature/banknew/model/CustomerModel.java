package com.revature.banknew.model;

public class CustomerModel {
	
	
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String Password;
	public CustomerModel() {
		super();
	}
	
	




	public CustomerModel(String firstName) {
		super();
		this.firstName = firstName;
	}






	public CustomerModel(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		Password = password;
	}






	public CustomerModel(int id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		Password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}



	@Override
	public String toString() {
		return "CustomerForm [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", Password=" + Password + "]";
	}
	
	
}
