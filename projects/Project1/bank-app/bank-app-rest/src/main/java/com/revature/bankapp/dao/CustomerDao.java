package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.banknew.model.Account;
import com.revature.banknew.model.Customer;

public interface CustomerDao {
	public void create(Customer customer) throws AppException;
	public Customer getLoginDetails(String email) throws AppException;
	public void createaccount(Account account,int customer_id) throws AppException;
	public ArrayList<Account> getaccountDetails(int custmoer_id) throws AppException;
	public Account getAccount(int id) throws AppException;


}
