package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.CustomerDao;

import com.revature.bankapp.dao.UtilNew;
import com.revature.bankapp.exception.AppException;
import com.revature.banknew.model.Account;
import com.revature.banknew.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

	@Override
	public void create(Customer customer) throws AppException {
		LOGGER.info("start");
		LOGGER.debug("{}",customer);
		try (Connection connection = UtilNew.getConnection()) {
			String query = "INSERT INTO customer (Customer_id, first_name, last_name, email_id, password) VALUES (?, ?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, customer.getId());
			statement.setString(2, customer.getFirstName());
			statement.setString(3, customer.getLastName());
			statement.setString(4, customer.getEmail());
			statement.setString(5, customer.getPassword());
			statement.executeUpdate();
			LOGGER.debug("Queary excute succesfully");
			LOGGER.info("end");
			
		}
		

		catch (SQLException e) {
			LOGGER.error("error inserting customer",e);
			throw new AppException(e);
		}
	}

	@Override
	public Customer getLoginDetails(String email) throws AppException {
		LOGGER.info("start");
		LOGGER.debug("{}",email);
		Customer customer = null;
		try (Connection connection = UtilNew.getConnection()) {
			String query = "SELECT * FROM customer where email_id=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				int id = result.getInt("customer_id");
				String firstNmae = result.getString("first_name");
				String lastNmae = result.getString("last_name");
				String emails = result.getString("email_id");
				String passwords = result.getString("password");
				customer = new Customer(id,firstNmae, lastNmae, emails, passwords);
				LOGGER.debug("Queary excute succesfully");
				LOGGER.info("end");

			}

		}
		catch (SQLException e) {
			LOGGER.error("error inserting customer",e);
			throw new AppException(e);
		}

		return customer;
		
	}

	@Override
	public void createaccount(Account account,int customer_id) throws AppException {
		LOGGER.info("start");
		LOGGER.debug("{}",account);
		try (Connection connection = UtilNew.getConnection()) {
			Customer customer = new Customer();
			String sql = "insert into account (account_no , aadhar_no , phone , balance, accounttype,Customer_id) values(?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, account.getAccountNo());
			statement.setString(2, account.getAadharNumber());
			statement.setString(3, account.getMobileNumber());
			statement.setLong(4, account.getBalance());
			statement.setString(5, account.getAccountType());
		
			statement.setInt(6, customer_id);
			statement.executeUpdate();
			statement.close();
		}
		catch (SQLException e) {
			LOGGER.error("error inserting customer",e);
			throw new AppException(e);
		}

	}

	@Override
	public ArrayList<Account> getaccountDetails(int custmoer_id) throws AppException{
		LOGGER.info("start");
		LOGGER.debug("{}",custmoer_id);
		ArrayList<Account> accountList = new ArrayList<>();
		try (Connection connection = UtilNew.getConnection()) {
			Customer customer = new Customer();
			String sql = "select accounttype, balance,account_no from account where Customer_id= ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, custmoer_id);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Account account = new Account();
				account.setAccountNo(resultset.getString("account_no"));
				account.setAccountType(resultset.getString("accounttype"));
				account.setBalance(resultset.getLong("balance"));
				
				accountList.add(account);
			}
		}catch (SQLException e) {
			LOGGER.error("error inserting customer",e);
			throw new AppException(e);
		}
        
		return accountList;

	}

	@Override
	public Account getAccount(int custmoer_id) throws AppException{
		LOGGER.info("start");
		LOGGER.debug("{}",custmoer_id);
		Account account = new Account();
		try (Connection connection = UtilNew.getConnection()) {
			Customer customer = new Customer();
			String sql = "select accounttype, balance,account_no from account where Customer_id= ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, custmoer_id);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				account.setAccountNo(resultset.getString("account_no"));
				account.setAccountType(resultset.getString("accounttype"));
				account.setBalance(resultset.getLong("balance"));
			}
		}catch (SQLException e) {
			LOGGER.error("error inserting customer",e);
			throw new AppException(e);
		}
        
		return account;

	}

	
}
