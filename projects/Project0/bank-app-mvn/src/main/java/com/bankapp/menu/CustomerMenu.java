package com.bankapp.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bankapp.Details.NewAccount;
import com.revature.bankapp.dao.UserDao;
import com.revature.bankapp.daoImpl.UserDaoImpl;

public class CustomerMenu extends Menu {

	public CustomerMenu(String name) {
		super(name);
		addMenuIteams("Create An Account");
		addMenuIteams("View Acoount");
		addMenuIteams("Exit");
		displaySelectionhandle();
	}

	@Override
	public void handle() {
		Scanner sc = new Scanner(System.in);
		switch (choice) {
		case 1:
			System.out.println("\n===");
			System.out.println("Create a new account");
			System.out.println("====\n");
			System.out.println("Aadhar number :");
			String aadharno = sc.nextLine();
			System.out.println("Mobile Number :");
			String mobile = sc.nextLine();
			System.out.println("Type of account :");
			String accountType = sc.nextLine();
			System.out.println("Intial balance :");
			String balance = sc.nextLine();
			System.out.println("Customer Id :");
			int cid = sc.nextInt();
			UserDaoImpl dao = new UserDaoImpl();
			try {
				dao.createAccount(new NewAccount(aadharno, mobile, accountType, balance, cid));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("View your account detail");
			System.out.println("Entre the customer id : ");
			int c = sc.nextInt();
			UserDao dao1 = new UserDaoImpl();

			ArrayList<NewAccount> view;
			try {
				view = dao1.viewAccount(c);
				view.forEach(System.out::println);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case 3:
			System.out.println("login Sucessfully");
			break;
		}

	}
}
