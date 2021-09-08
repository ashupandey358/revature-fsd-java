package com.revature.oops;

import java.util.Scanner;

public class MainByUsingGetterAndSetter {
	public static void main(String[] args) {
		Encapsulation account = new Encapsulation("65767668689",776.0);
		

		System.out.println(" Entre the account number ");

		//Scanner sc = new Scanner(System.in);
		//String accountNumber = sc.next();

		//account.setAccountNumber(accountNumber);
		System.out.println(account.getAccountNumber());
		System.out.println("The balance is:-");
		//double balance=sc.nextDouble();
	

		//account.setBalance(balance);
		System.out.println(account.getBalance());

	}

}
