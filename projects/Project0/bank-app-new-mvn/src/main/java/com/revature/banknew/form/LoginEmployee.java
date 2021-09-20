package com.revature.banknew.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.banknew.menu.CustomerMenu;
import com.revature.banknew.menu.EmployeeMenu;
import com.revature.banknew.model.CustomerModel;
import com.revature.banknew.model.EmployeeModel;

public class LoginEmployee extends LoginUser{
	
	public LoginEmployee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void dispalyLogin() {
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
	protected void loginAction() {
	EmployeeDaoImpl cs = new EmployeeDaoImpl();
		

		try {
			
			EmployeeModel customer = cs.getEmail(email);
			if (customer == null) {
				System.out.println("Invalid email / password");
				int n = 5;
				
					dispalyLoginPage();
				    n=n-1;
				
				
				dispalyLoginPage();
			}
			else if (customer.getPassword().equals(password)) {

				System.out.println("Login Successful.");
				System.out.println("Welcome " + customer.getName() );
			    EmployeeMenu menu = new EmployeeMenu("Employee Menu Items");
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
