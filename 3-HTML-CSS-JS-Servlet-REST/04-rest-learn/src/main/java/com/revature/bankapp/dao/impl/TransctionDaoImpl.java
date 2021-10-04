package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.TransctionDao;
import com.revature.bankapp.dao.UtilNew;
import com.revature.banknew.model.AccountModel;
import com.revature.banknew.model.CustomerModel;
import com.revature.banknew.model.TransctionModel;

public class TransctionDaoImpl implements TransctionDao {

	@Override
	public AccountModel currentAmount(String accountno) throws SQLException {
		AccountModel account = null;
		try (Connection connection = UtilNew.getConnection()) {
			String query = "SELECT balance from account where account_no=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, accountno);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				long balance = rs.getLong("balance");
				account = (new AccountModel(balance));
			}
		}
		return account;
	}

	@Override
	public void transctionCreate(TransctionModel transctionModel) throws SQLException {
		try (Connection connection = UtilNew.getConnection()) {
			String query = "INSERT INTO transcation (transcationType, Amount, accountnumber) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, transctionModel.getTransctionType());
			statement.setLong(2, transctionModel.getAmount());
			statement.setString(3, transctionModel.getAccountNumber());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void forWithdrawal(long updatedbalance, String accountno) throws SQLException {
		try (Connection connection = UtilNew.getConnection()) {
			String query = "update account set balance=? where account_no =?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, updatedbalance);
			statement.setString(2, accountno);
			statement.executeUpdate();

		}

	}

	@Override
	public void forDeposite(long updatedbalance1, String accountno2) throws SQLException {
		try (Connection connection = UtilNew.getConnection()) {
			String query = "update account set balance=? where account_no =?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, updatedbalance1);
			statement.setString(2, accountno2);
			statement.executeUpdate();

		}
	}

	@Override
	public ArrayList<TransctionModel> viewTransctionforSpecificAccount(String accountNo) throws SQLException {
		ArrayList<TransctionModel> transctionList = new ArrayList<>();
		try (Connection connection = UtilNew.getConnection()) {
			CustomerModel customer = new CustomerModel();
			String sql = "select * from transcation where accountnumber = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, accountNo);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
			  TransctionModel transctionModel = new TransctionModel();
				transctionModel.setAmount(resultset.getLong("Amount"));
				transctionModel.setTransctionType(resultset.getString("transcationType"));
				transctionList.add(0, transctionModel);
			}
		}

		return transctionList;
		
	}

	
}