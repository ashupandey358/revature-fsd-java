package com.revature.banknew.model;

public class UserModel {
	private String name;
    private String emailId;
    private String password;
	public UserModel(String name) {
		super();
		this.name = name;
	}
	public UserModel(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
    
}
