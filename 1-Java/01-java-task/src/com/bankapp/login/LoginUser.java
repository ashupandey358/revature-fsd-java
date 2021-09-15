package com.bankapp.login;

import java.util.Scanner;

import com.bankapp.user.User;


public class LoginUser extends Login{
	private String email;
	private String password;

	public LoginUser(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void captureData() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Email: ");
		email = scanner.nextLine();
		
		System.out.print("Password: ");
		password = scanner.nextLine();
		
	}

	@Override
	public void action() {
		User data = new User(email,password);
		if(data.getEmailid().equals(email) && data.getPassword().equals(password))
		{
			System.out.println(data.getEmailid());
			success = true;
			System.out.println("Login Successful.");
			
		}
		else
		{
			System.out.println("Invaild user name and password");
		}
		
	}


}
