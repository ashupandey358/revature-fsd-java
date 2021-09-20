package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.banknew.form.AccountDetails;
import com.revature.banknew.form.CustomerForm;

public interface CustomerDao {
	public void customerData(CustomerForm customer) throws SQLException;
	public CustomerForm getEmail(String email) throws SQLException;
	public void accountDetails(AccountDetails account) throws SQLException;
	public ArrayList<AccountDetails> specficAccount(int custmoer_id) throws SQLException;

}
