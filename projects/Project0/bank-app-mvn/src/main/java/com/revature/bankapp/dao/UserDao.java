package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bankapp.Details.CustomerUser;
import com.bankapp.Details.EmployeeUser;
import com.bankapp.Details.NewAccount;

public interface UserDao {
	void insertUser(CustomerUser customerUser) throws SQLException;
	CustomerUser getCustomerUser(String emailid,String password) throws SQLException ;
	EmployeeUser getEmployeeUser(String emailid) throws SQLException;
	void createAccount(NewAccount newAccount)  throws SQLException;
	public ArrayList<NewAccount> viewAccount(int cid)  throws SQLException;
}
