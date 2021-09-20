package com.revature.banknew.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.banknew.form.CustomerForm;
import com.revature.banknew.form.EmployeeForm;
import com.revature.banknew.login.LoginCustomer;
import com.revature.banknew.login.LoginEmployee;

public class MainMenuItems extends Menu {

	public MainMenuItems(String name) {
		super(name);
		addMenuItem("New User");
		addMenuItem("Login Customer");
		addMenuItem("Login employee");
		addMenuItem("exit");
	}

	Scanner sc = new Scanner(System.in);

	@Override
	public void handle() {
		if (option == 1) {
			System.out.println("1. For Customer");
			System.out.println("2. For Employee");
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("Id Number :-");
				int id = sc.nextInt();

				System.out.println("First Name :-");
				String firstName = sc.next();

				System.out.println("Last name :-");

				String lastName = sc.next();

				System.out.println("Email Id");

				String emailId = sc.next();

				System.out.println("Password");
				String password = sc.next();

				CustomerDaoImpl customer = new CustomerDaoImpl();
				try {
					customer.customerData(new CustomerForm(id, firstName, lastName, emailId, password));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Customer added successfully.");
				mainDisplay();

			}
			if (choice == 2) {
				System.out.println("Id Number :-");
				int id = sc.nextInt();

				System.out.println("Name :-");
				String name = sc.next();

				System.out.println("Email Id");
				String emailId = sc.next();

				System.out.println("Password");
				String password = sc.next();

				System.out.println("Department");
				String department = sc.next();

				EmployeeDaoImpl emp = new EmployeeDaoImpl();
				try {
					emp.employeeData(new EmployeeForm(id, name, emailId, password, department));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("employee added successfully.");
				mainDisplay();

			}

		}
		if(option == 2)
		{
			LoginCustomer user = new LoginCustomer("Login Form");
			user.dispalyLoginPage();
		}
		if(option == 3)
		{
			LoginEmployee employee = new LoginEmployee();
			employee.dispalyLoginPage();
		}
		if(option == 4)
		{
			System.out.println("Logout SuccesFully");
		}
		

	}

}
