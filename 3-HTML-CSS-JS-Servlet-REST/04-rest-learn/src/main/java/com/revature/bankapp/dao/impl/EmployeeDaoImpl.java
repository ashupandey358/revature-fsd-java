package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			statement.setString(5, employee.getDepartment());
			statement.executeUpdate();
		}
	}

	@Override
	public ArrayList<EmployeeModel> getemployeelist() throws SQLException {
		ArrayList<EmployeeModel> employees = new ArrayList<>();
		EmployeeModel employee = null;
		try(Connection connection = UtilNew.getConnection()){
			String query = "SELECT * FROM employee";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				int id = result.getInt("employee_id");
				String name = result.getString("name");
				String emails = result.getString("email");
				String passwords = result.getString("password");
				String department = result.getString("deparment");
				employee = new EmployeeModel(id,name,emails,passwords,department);
				employees.add(employee);
				
			}
			
		}
		return employees;
	}

}
