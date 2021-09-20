package com.revature.banknew.login;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.banknew.form.CustomerForm;
import com.revature.banknew.menu.CustomerMenu;

public class LoginCustomer extends LoginUser {

	public LoginCustomer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dispalyLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("+++++++++++++++");
		System.out.println(name);
		System.out.println("+++++++++++++++");

		System.out.println("Email :");
		email = sc.next();

		System.out.println("Password :");
		password = sc.next();

	}

	@Override
	public void loginAction() {
		CustomerDaoImpl cs = new CustomerDaoImpl();
		

		try {
			
			CustomerForm customer = cs.getEmail(email);
			if (customer == null) {
				System.out.println("Invalid email / password");
				dispalyLoginPage();
			}
			else if (customer.getPassword().equals(password)) {

				System.out.println("Login Successful.");
				System.out.println("Welcome " + customer.getFirstName() + " " + customer.getLastName());
				CustomerMenu menu = new CustomerMenu("Customer Menu Items");
				menu.mainDisplay();
				

			}

			else {

				System.out.println("Invalid email / password");
				dispalyLoginPage();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
