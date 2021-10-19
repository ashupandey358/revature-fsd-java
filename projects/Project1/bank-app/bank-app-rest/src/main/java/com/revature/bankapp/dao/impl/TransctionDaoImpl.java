package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.TransctionDao;
import com.revature.bankapp.dao.UtilNew;
import com.revature.bankapp.exception.AppException;
import com.revature.banknew.model.Account;
import com.revature.banknew.model.Customer;
import com.revature.banknew.model.Transction;

public class TransctionDaoImpl implements TransctionDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransctionDaoImpl.class);

	@Override
	public int currentAmount(String accountno) throws AppException {
		int balance = 0;
		try (Connection connection = UtilNew.getConnection()) {
			String query = "SELECT balance from account where account_no=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, accountno);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				 balance = rs.getInt("balance");
				
			}
			
		}catch (SQLException e) {
			LOGGER.error("Getting Customer Details",e);
			throw new AppException(e);
		}
		return balance;
	}

	@Override
	public void transctionCreate(String accountNo,String type,int money) throws AppException {
		try (Connection connection = UtilNew.getConnection()) {
			String query = "INSERT INTO transcation (transcationType, Amount, accountnumber) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, type);
			statement.setLong(2, money);
			statement.setString(3, accountNo);
			statement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("Getting Customer Details",e);
			throw new AppException(e);
		}

	}

	@Override
	public void forWithdrawal(int updatedbalance, String accountno) throws AppException {
		try (Connection connection = UtilNew.getConnection()) {
			String query = "update account set balance=? where account_no =?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, updatedbalance);
			statement.setString(2, accountno);
			statement.executeUpdate();

		}
		catch (SQLException e) {
			LOGGER.error("Getting Customer Details",e);
			throw new AppException(e);
		}

	}

	@Override
	public void forDeposite(int updatedbalance1, String accountno2) throws AppException {
		try (Connection connection = UtilNew.getConnection()) {
			String query = "update account set balance=? where account_no =?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, updatedbalance1);
			statement.setString(2, accountno2);
			statement.executeUpdate();

		}
		catch (SQLException e) {
			LOGGER.error("Getting Customer Details",e);
			throw new AppException(e);
		}
	}

	@Override
	public ArrayList<Transction> viewTransctionforSpecificAccount(String accountNo) throws AppException {
		ArrayList<Transction> transctionList = new ArrayList<>();
		try (Connection connection = UtilNew.getConnection()) {
			Customer customer = new Customer();
			String sql = "select * from transcation where accountnumber = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, accountNo);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
			  Transction transction = new Transction();
				transction.setAmount(resultset.getInt("Amount"));
				transction.setTransctionType(resultset.getString("transcationType"));
				transctionList.add(0, transction);
			}
		}catch (SQLException e) {
			LOGGER.error("Getting Customer Details",e);
			throw new AppException(e);
		}

		return transctionList;
		
	}

	
}