package com.revature.banknew.form;

public class UserForm {
	private String name;
    private String emailId;
    private String password;
	public UserForm(String name) {
		super();
		this.name = name;
	}
	public UserForm(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
    
}
