package com.revature.banknew.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.dao.impl.TransctionDaoImpl;
import com.revature.banknew.model.AccountModel;
import com.revature.banknew.model.TransctionModel;

public class EmployeeMenu extends Menu {

	public EmployeeMenu(String name) {
		super(name);
		addMenuItem("Approve or reject an account");
		addMenuItem("View Customer Bank Account");
		addMenuItem("Regsister For Customr Account");
		addMenuItem("Transtion Done by Customer");
		addMenuItem("Exit");

	}

	@Override
	public void handle() {
		Scanner sc = new Scanner(System.in);
		switch (option) {

		case 2: {
			System.out.println("Entre your Customer id :");
			int customerId = sc.nextInt();
			CustomerDaoImpl dao = new CustomerDaoImpl();
			try {
				List<AccountModel> form = dao.specficAccount(customerId);
				for (int i = 0; i < form.size(); i++) {
					System.out.println((i + 1) + ".  - " + form.get(i));
				}
				mainDisplay();
				break;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		case 3: {
			System.out.println("Entre Account Number :");
			String accountNumber = sc.next();

			System.out.println("Entre aadhar Number :");
			String aadharNumber = sc.next();

			System.out.println("Entre Mobile Number :");
			String mobileNumber = sc.next();

			System.out.println("Entre Intial Amount :");
			long amount = sc.nextLong();

			System.out.println("Entre Type Of Account :");
			String typeAccount = sc.next();

			System.out.println("Status :");
			String statusAccount = sc.next();

			System.out.println("Customer id :");
			int customerId = sc.nextInt();

			CustomerDaoImpl dao = new CustomerDaoImpl();
			try {
				dao.accountModel(new AccountModel(accountNumber, aadharNumber, mobileNumber, amount, typeAccount,
						statusAccount, customerId));
				System.out.println("Account details Added SuccesFully");
				mainDisplay();
				break;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		case 4: {
			System.out.println("Entre the account Number : ");
			String accountNo = sc.next();
			TransctionDaoImpl dao = new TransctionDaoImpl();
			try {
				ArrayList<TransctionModel> s = dao.viewTransctionforSpecificAccount(accountNo);
				s.forEach(System.out::println);
				mainDisplay();
				break;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		case 5: {
			System.out.println("<<<<<  Thank you for Visting  >>>>");
			System.out.println("<<<<     logout Succesfully    >>>>");

		}

		}
	}
}