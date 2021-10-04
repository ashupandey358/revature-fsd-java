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
	public void account(Account account) throws AppException;
	public ArrayList<Account> specficAccount(int custmoer_id) throws AppException;


}
