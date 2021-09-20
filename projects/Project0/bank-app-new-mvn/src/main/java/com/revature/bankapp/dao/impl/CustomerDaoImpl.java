package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.CustomerDao;

import com.revature.bankapp.dao.UtilNew;
import com.revature.banknew.form.AccountDetails;
import com.revature.banknew.form.CustomerForm;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void customerData(CustomerForm customer) throws SQLException {

		try (Connection connection = UtilNew.getConnection()) {
			String query = "INSERT INTO customer (Customer_id, first_name, last_name, email_id, password) VALUES (?, ?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, customer.getId());
			statement.setString(2, customer.getFirstName());
			statement.setString(3, customer.getLastName());
			statement.setString(4, customer.getEmail());
			statement.setString(5, customer.getPassword());
			statement.executeUpdate();
			
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public CustomerForm getEmail(String email) throws SQLException {
		CustomerForm customer = null;
		try (Connection connection = UtilNew.getConnection()) {
			String query = "SELECT * FROM customer where email_id=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				String firstNmae = result.getString("first_name");
				String lastNmae = result.getString("last_name");
				String emails = result.getString("email_id");
				String passwords = result.getString("password");
				customer = new CustomerForm(firstNmae, lastNmae, emails, passwords);

			}

		}

		return customer;
	}

	@Override
	public void accountDetails(AccountDetails account) throws SQLException {
		try (Connection connection = UtilNew.getConnection()) {
			CustomerForm customer = new CustomerForm();
			String sql = "insert into account (account_no , aadhar_no , phone , balance, accounttype ,status,Customer_id) values(?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, account.getAccountNo());
			statement.setString(2, account.getAadharNumber());
			statement.setString(3, account.getMobileNumber());
			statement.setLong(4, account.getBalance());
			statement.setString(5, account.getAccountType());
			statement.setString(6, account.getAccountStatus());
			statement.setInt(7, account.getCustomerId());
			statement.executeUpdate();
			statement.close();
		}

	}

	@Override
	public ArrayList<AccountDetails> specficAccount(int custmoer_id) throws SQLException {
		ArrayList<AccountDetails> accountList = new ArrayList<>();
		try (Connection connection = UtilNew.getConnection()) {
			CustomerForm customer = new CustomerForm();
			String sql = "select accounttype, balance from account where Customer_id= ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, custmoer_id);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				AccountDetails account = new AccountDetails();
				account.setAccountType(resultset.getString("accounttype"));
				account.setBalance(resultset.getLong("balance"));
				accountList.add(account);
			}
		}

		return accountList;

	}
}
