package com.revature.banknew.form;

public class CustomerForm {
	
	
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String Password;
	public CustomerForm() {
		super();
	}
	
	




	public CustomerForm(String firstName) {
		super();
		this.firstName = firstName;
	}






	public CustomerForm(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		Password = password;
	}






	public CustomerForm(int id, String firstName, String lastName, String email, String password) {
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
