package com.revature.banknew.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.TransctionDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.dao.impl.TransctionDaoImpl;
import com.revature.banknew.model.AccountModel;
import com.revature.banknew.model.CustomerModel;
import com.revature.banknew.model.TransctionModel;

public class CustomerMenu extends Menu {

	public CustomerMenu(String name) {
		super(name);
		addMenuItem("Create Account With Starting Balance");
		addMenuItem("View the List of account with balance");
		addMenuItem("Withdrawal");
		addMenuItem("deposite");
		addMenuItem("view the transactions in a specific account");
		addMenuItem("post a money transfer to another account");
		addMenuItem("Exit");
	}

	@Override
	public void handle() {
		Scanner sc = new Scanner(System.in);
		switch (option) {
		case 1: {
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mainDisplay();
			break;
		}
		case 2: {
			System.out.println("Entre your Customer id :");
			int customerId = sc.nextInt();
			CustomerDaoImpl dao = new CustomerDaoImpl();
			try {
				List<AccountModel> form = dao.specficAccount(customerId);
				for (int i = 0; i < form.size(); i++) {
					System.out.println((i + 1) + ".  - " + form.get(i));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			mainDisplay();
			break;
		}
		case 3: {

			System.out.println("Entre The Amount:-");
			long amount = sc.nextLong();

			String type = "W";

			System.out.println("Entre The accountNumber:-");
			String account = sc.next();

			TransctionDaoImpl dao = new TransctionDaoImpl();
			try {
				if (amount > 0) {
					AccountModel c = dao.currentAmount(account);
					if ((c.getBalance()) < 0 || (c.getBalance()) <= (amount)) {
						System.out.println("Insufficent balance");
						mainDisplay();
					} else {
						dao.transctionCreate(new TransctionModel(type, amount, account));
						System.out.println("Thank You For Transction **Transction done Succesfully**");
						long updateBalance = c.getBalance() - amount;
						TransctionDaoImpl dao1 = new TransctionDaoImpl();

						try {
							dao1.forWithdrawal(updateBalance, account);
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
			mainDisplay();
			break;
		}
		case 4: {

			System.out.println("Entre The Amount:-");
			long amount1 = sc.nextLong();

			String type1 = "D";

			System.out.println("Entre The accountNumber:-");
			String account1 = sc.next();

			TransctionDaoImpl dao2 = new TransctionDaoImpl();
			try {
				if (amount1 > 0) {
					AccountModel c = dao2.currentAmount(account1);
					if ((c.getBalance()) < 0) {
						System.out.println("Insufficent balance");
						mainDisplay();
					} else {
						dao2.transctionCreate(new TransctionModel(type1, amount1, account1));
						System.out.println("Thank You For Transction **Transction done Succesfully**");
						long updateBalance = c.getBalance() + amount1;
						TransctionDaoImpl dao3 = new TransctionDaoImpl();

						try {
							dao3.forWithdrawal(updateBalance, account1);

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
			mainDisplay();
			break;
		}
		case 5: {
			System.out.println("Entre the account Number : ");
			String accountNo = sc.next();
			TransctionDaoImpl dao = new TransctionDaoImpl();
			try {
				ArrayList<TransctionModel> s = dao.viewTransctionforSpecificAccount(accountNo);
				s.forEach(System.out::println);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mainDisplay();
			break;
		}
		case 6: {
			System.out.println("Entre The Amount:-");
			long amount = sc.nextLong();

			System.out.println("Entre The accountNumber:-");
			String account = sc.next();

			TransctionDaoImpl dao = new TransctionDaoImpl();
			try {
				if (amount > 0) {
					AccountModel c = dao.currentAmount(account);
					if ((c.getBalance()) < 0 || (c.getBalance()) < (amount)) {
						System.out.println("Insufficent balance");
						mainDisplay();
					} else {
						long updateBalance = c.getBalance() - amount;
						TransctionDaoImpl dao1 = new TransctionDaoImpl();

						try {
							dao1.forWithdrawal(updateBalance, account);
							
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
			System.out.println("");
			System.out.println("Entre The accountNumber where you transefer your money:-");
			String account1 = sc.next();

			TransctionDaoImpl dao2 = new TransctionDaoImpl();
			if(Integer.parseInt(account)!=Integer.parseInt(account1))
			{
				
			try {

				AccountModel c = dao2.currentAmount(account1);

				long updateBalance = c.getBalance() + amount;
				TransctionDaoImpl dao3 = new TransctionDaoImpl();

				try {
					dao3.forWithdrawal(updateBalance, account1);
					System.out.println("<<< ----  Transfer succesfully -----  >>>>");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else
			{
				System.out.println("Account Number Is Same It is Not possible");
			}
			
			
			mainDisplay();
			break;
		
		}

		case 7:

		{

			System.out.println("<<< ----  Thank You Have a Good Day -----  >>>>");
			System.out.println("<<<----     Logout succesFully      ----->>>>>>");
			break;

		}
		}
	}
}
