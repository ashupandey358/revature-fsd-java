package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.TransctionDao;
import com.revature.bankapp.dao.UtilNew;
import com.revature.banknew.model.Account;
import com.revature.banknew.model.Customer;
import com.revature.banknew.model.Transction;

public class TransctionDaoImpl implements TransctionDao {

	@Override
	public Account currentAmount(String accountno) throws SQLException {
		Account account = null;
		try (Connection connection = UtilNew.getConnection()) {
			String query = "SELECT balance from account where account_no=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, accountno);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				long balance = rs.getLong("balance");
				account = (new Account(balance));
			}
		}
		return account;
	}

	@Override
	public void transctionCreate(Transction transction) throws SQLException {
		try (Connection connection = UtilNew.getConnection()) {
			String query = "INSERT INTO transcation (transcationType, Amount, accountnumber) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, transction.getTransctionType());
			statement.setLong(2, transction.getAmount());
			statement.setString(3, transction.getAccountNumber());
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
	public ArrayList<Transction> viewTransctionforSpecificAccount(String accountNo) throws SQLException {
		ArrayList<Transction> transctionList = new ArrayList<>();
		try (Connection connection = UtilNew.getConnection()) {
			Customer customer = new Customer();
			String sql = "select * from transcation where accountnumber = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, accountNo);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
			  Transction transction = new Transction();
				transction.setAmount(resultset.getLong("Amount"));
				transction.setTransctionType(resultset.getString("transcationType"));
				transctionList.add(0, transction);
			}
		}

		return transctionList;
		
	}

	
}