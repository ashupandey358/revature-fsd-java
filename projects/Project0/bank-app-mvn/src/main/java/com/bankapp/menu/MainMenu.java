package com.bankapp.menu;
import java.sql.SQLException;
import java.util.Scanner;

import com.bankapp.Details.CustomerUser;
import com.bankapp.Form.LoginEmployee;
import com.bankapp.Form.LoginUser;
import com.revature.bankapp.dao.UserDao;
import com.revature.bankapp.daoImpl.UserDaoImpl;

public class MainMenu extends Menu {

	public MainMenu(String name) {
		super(name);
		addMenuIteams("New User");
		addMenuIteams("customer login");
		addMenuIteams("Employee Login");
		addMenuIteams("Exit");
	}

	@Override
	public void handle() {
		Scanner scanner = new Scanner(System.in);
		switch(choice) {
		case 1:
			System.out.println("\n===");
			System.out.println("Register new customer");
			System.out.println("====\n");
			System.out.print("First Name: ");
			String firstName = scanner.nextLine();
			
			System.out.print("Last Name: ");
			String lastName = scanner.nextLine();

			System.out.print("Email: ");
			String email = scanner.nextLine();

			System.out.print("Password: ");
			String password = scanner.nextLine();
			UserDao dao = new UserDaoImpl();
			try {
				dao.insertUser(new CustomerUser(firstName,lastName,email,password));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Customer added successfully.");
			displaySelectionhandle();
			break;
		case 2:
			LoginUser loginUser = new LoginUser("Login Form");
			loginUser.captureDataAndPerformAction();
			break;
		case 3:
			LoginEmployee login = new LoginEmployee("Login Form");
			login.captureDataAndPerformAction();
			break;
		case 4:
			System.out.println("logout SuccesFully");
			break;
		}
	}



}
