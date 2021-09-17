package com.bankapp.Form;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.bankapp.Details.CustomerUser;
import com.bankapp.Details.EmployeeUser;
import com.revature.bankapp.dao.UserDao;
import com.revature.bankapp.daoImpl.UserDaoImpl;

public class LoginEmployee extends Login {
	private String email;
	private String password;
	private int id;
	public LoginEmployee(String name) {
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
		// TODO Auto-generated method stub
		UserDao dao = new UserDaoImpl();
		try {
			EmployeeUser customerUser = dao.getEmployeeUser(email);
			if (customerUser == null) {
				System.out.println("Invalid email / password");
			}
			else if(customerUser.getPassword().equals(password))
			{
				
				System.out.println("Login Successful.");
				
				
			}
			else
			{
				System.out.println("Invalid email / password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
