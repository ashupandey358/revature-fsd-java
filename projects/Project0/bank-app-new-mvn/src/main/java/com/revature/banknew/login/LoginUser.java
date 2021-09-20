package com.revature.banknew.login;

import java.util.Scanner;

public abstract class LoginUser {
	protected String name;
	protected String email;
	protected String password;

	public LoginUser(String name) {
		super();
		this.name = name;
	}

	protected abstract void loginAction();
	public LoginUser() {
		super();
	}

	protected abstract void dispalyLogin();

	public void dispalyLoginPage() {
		dispalyLogin();
		loginAction();
	}

	

}
