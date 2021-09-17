package com.revature.bankapp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.bankapp.Details.CustomerUser;
import com.bankapp.Details.EmployeeUser;
import com.bankapp.Details.NewAccount;
import com.bankapp.Form.LoginUser;
import com.revature.bankapp.dao.UserDao;
import com.revature.bankapp.dao.Util;

public class UserDaoImpl implements UserDao {

	@Override
	public void insertUser(CustomerUser customerUser) throws SQLException {
		// TODO Auto-generated method stub

		try (Connection connection = Util.getConnection()) {
			String sql = "insert into customer (first_name,last_name,email_id,password) values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, customerUser.getFirstName());
			statement.setString(2, customerUser.getLastName());
			statement.setString(3, customerUser.getEmailid());
			statement.setString(4, customerUser.getPassword());
			statement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public CustomerUser getCustomerUser(String emailid, String password) throws SQLException {
		// TODO Auto-generated method stub
		CustomerUser customerUser = null;

		try (Connection connection = Util.getConnection()) {

			String sql = "SELECT * FROM bankapp.customer where email_id=? and password=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, emailid);
			statement.setString(2, password);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {

				String email = resultset.getString("email_id");
				String passworD = resultset.getString("password");
				String name = resultset.getString("first_name");
				String last = resultset.getString("last_name");
				customerUser = new CustomerUser(name, last, email, passworD);
			}

		}
		return customerUser;
	}

	@Override
	public EmployeeUser getEmployeeUser(String EmailId) throws SQLException {
		// TODO Auto-generated method stub
		EmployeeUser employeeUser = null;

		try (Connection connection = Util.getConnection()) {

			String sql = "SELECT * FROM bankapp.employee where email=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, EmailId);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {

				String email = resultset.getString("email");
				String passworD = resultset.getString("password");
				employeeUser = new EmployeeUser(email, passworD);
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("Given a vaild employee id");
		}

		return employeeUser;
	}

	@Override
	public void createAccount(NewAccount newAccount) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into account (aadhar,mobile_no,type,balance,customerid) values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newAccount.getAddharNumber());
			statement.setString(2, newAccount.getMobileNumber());
			statement.setString(3, newAccount.getAccountType());
			statement.setString(4, newAccount.getBalance());
			statement.setInt(5,newAccount.getCid());
			statement.executeUpdate();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<NewAccount> viewAccount(int cid) {
		ArrayList<NewAccount> emp = new ArrayList<NewAccount>();
	
		try (Connection connection = Util.getConnection()) {
			String sql = "select type,balance from customer c inner join account a on c.id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, cid);
			NewAccount account = new NewAccount();
	
			ResultSet rs = statement.executeQuery();
			if(rs.next())
			{
			  account.setAccountType(rs.getString("type"));
			  account.setBalance(rs.getString("balance"));
			  emp.add(account);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
		
}
