package com.bankapp.Form;


import java.sql.SQLException;
import java.util.Scanner;

import com.bankapp.Details.CustomerUser;
import com.bankapp.menu.CustomerMenu;
import com.revature.bankapp.dao.UserDao;
import com.revature.bankapp.daoImpl.UserDaoImpl;


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
		UserDao dao = new UserDaoImpl();
		try {
			CustomerUser customerUser = dao.getCustomerUser(email, password);
			if (customerUser == null) {
				System.out.println("Invalid email / password");
			}
			else if(customerUser.getPassword().equals(password))
			{
				
				System.out.println("Login Successful.");
				System.out.println("Welcome "+customerUser.getFirstName()+customerUser.getLastName());
				CustomerMenu cm = new CustomerMenu("Customer Menu");
				cm.displaySelectionhandle();
				
				
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



