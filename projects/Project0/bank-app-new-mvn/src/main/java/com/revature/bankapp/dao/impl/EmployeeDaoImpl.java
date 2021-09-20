package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.UtilNew;
import com.revature.banknew.model.CustomerModel;
import com.revature.banknew.model.EmployeeModel;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void employeeData(EmployeeModel employee) throws SQLException {
		try (Connection connection = UtilNew.getConnection()) {
			String query = "INSERT INTO employee (employee_id, name, email, password, deparment) VALUES (?, ?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, employee.getEmployeeId());
			statement.setString(2, employee.getName());
			statement.setString(3, employee.getEmail());
			statement.setString(4, employee.getPassword());
			statement.setString(5, employee.getPassword());
			statement.executeUpdate();
		}
	}

	@Override
	public EmployeeModel getEmail(String email) throws SQLException {
		
		EmployeeModel employee = null;
		try(Connection connection = UtilNew.getConnection()){
			String query = "SELECT * FROM employee where email=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				String name = result.getString("name");
				String emails = result.getString("email");
				String passwords = result.getString("password");
				employee = new EmployeeModel(name,emails,passwords);
				
			}
			
		}
		return employee;
	}

}
