package com.bankapp.user;

import java.util.ArrayList;
import java.util.List;

public class CustomerUser extends User {
	static List<CustomerUser> cs = new ArrayList<>();
	
	public CustomerUser(String firstName, String lastName, String emailid, String password) {
		super(firstName, lastName, emailid, password);
		// TODO Auto-generated constructor stub
	}

	public static void addCustomer(CustomerUser cu) {
		// TODO Auto-generated method stub
		cs.add(cu);
		
		
		
	}

}
