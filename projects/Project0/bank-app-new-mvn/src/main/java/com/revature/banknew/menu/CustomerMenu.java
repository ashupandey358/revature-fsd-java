package com.revature.banknew.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.TransctionDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.dao.impl.TransctionDaoImpl;
import com.revature.banknew.form.AccountDetails;
import com.revature.banknew.form.CustomerForm;
import com.revature.banknew.transction.Transction;

public class CustomerMenu extends Menu {

	public CustomerMenu(String name) {
		super(name);
		addMenuItem("Create Account With Starting Balance");
		addMenuItem("View the List of account with balance");
		addMenuItem("Withdrawal");
		addMenuItem("deposite");
		addMenuItem("view the transactions in a specific account");
		addMenuItem("post a money transfer to another account");
		addMenuItem("Exit to Main Menu");
	}

	@Override
	public void handle() {
		Scanner sc = new Scanner(System.in);
		if (option == 1) {
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
				dao.accountDetails(new AccountDetails(accountNumber, aadharNumber, mobileNumber, amount, typeAccount,
						statusAccount, customerId));
				System.out.println("Account details Added SuccesFully");
				mainDisplay();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (option == 2) {
			System.out.println("Entre your Customer id :");
			int customerId = sc.nextInt();
			CustomerDaoImpl dao = new CustomerDaoImpl();
			try {
				List<AccountDetails> form = dao.specficAccount(customerId);
				for (int i = 0; i < form.size(); i++) {
					System.out.println((i + 1) + ".  - " + form.get(i));
				}
				mainDisplay();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (option == 3) {

			System.out.println("Entre The Amount:-");
			long amount = sc.nextLong();

			String type = "W";

			System.out.println("Entre The accountNumber:-");
			String account = sc.next();

			TransctionDaoImpl dao = new TransctionDaoImpl();
			try {
				if (amount > 0) {
					AccountDetails c = dao.currentAmount(account);
					if ((c.getBalance()) < 0 || (c.getBalance()) <= (amount)) {
						System.out.println("Insufficent balance");
						mainDisplay();
					} else {
						dao.transctionCreate(new Transction(type, amount, account));
						System.out.println("Thank You For Transction **Transction done Succesfully**");
						long updateBalance = c.getBalance() - amount;
						TransctionDaoImpl dao1 = new TransctionDaoImpl();

						try {
							dao1.forWithdrawal(updateBalance, account);
							mainDisplay();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				} else {
					System.out.println("%%% Invalid Amount %%%");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (option == 4) {

			System.out.println("Entre The Amount:-");
			long amount1 = sc.nextLong();

			String type1 = "D";

			System.out.println("Entre The accountNumber:-");
			String account1 = sc.next();

			TransctionDaoImpl dao2 = new TransctionDaoImpl();
			try {
				if (amount1 > 0) {
					AccountDetails c = dao2.currentAmount(account1);
					if ((c.getBalance()) < 0 || (c.getBalance()) <= (amount1)) {
						System.out.println("Insufficent balance");
						mainDisplay();
					} else {
						dao2.transctionCreate(new Transction(type1, amount1, account1));
						System.out.println("Thank You For Transction **Transction done Succesfully**");
						long updateBalance = c.getBalance() + amount1;
						TransctionDaoImpl dao3 = new TransctionDaoImpl();

						try {
							dao3.forWithdrawal(updateBalance, account1);
							mainDisplay();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				} else {
					System.out.println("%%% Invalid Amount %%%");
					mainDisplay();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if(option==5)
		{
			System.out.println("Entre the account Number : ");
			String accountNo = sc.next();
			TransctionDaoImpl dao = new TransctionDaoImpl();
			try {
				ArrayList<Transction> s = dao.viewTransctionforSpecificAccount(accountNo);
				s.forEach(System.out::println);
				mainDisplay();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
