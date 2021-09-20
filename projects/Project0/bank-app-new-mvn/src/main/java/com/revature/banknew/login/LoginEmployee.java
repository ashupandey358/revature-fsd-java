package com.revature.banknew.login;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.banknew.form.CustomerForm;
import com.revature.banknew.form.EmployeeForm;

public class LoginEmployee extends LoginUser{

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
			
			EmployeeForm customer = cs.getEmail(email);
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

			}

			else {

				System.out.println("Invalid email / password");
				int n = 5;

				dispalyLoginPage();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
