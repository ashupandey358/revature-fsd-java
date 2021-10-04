package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.banknew.model.AccountModel;
import com.revature.banknew.model.CustomerModel;

public interface CustomerDao {
	public void customerData(CustomerModel customer) throws SQLException;
	public CustomerModel getEmail(String email) throws SQLException;
	public void accountModel(AccountModel account) throws SQLException;
	public ArrayList<AccountModel> specficAccount(int custmoer_id) throws SQLException;


}
