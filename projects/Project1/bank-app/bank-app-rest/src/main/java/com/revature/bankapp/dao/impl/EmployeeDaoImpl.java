package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.UtilNew;
import com.revature.bankapp.exception.AppException;
import com.revature.banknew.model.Customer;
import com.revature.banknew.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);


	@Override
	public void employeeData(Employee employee) throws SQLException {
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
	public ArrayList<Employee> getEmail() throws AppException {
		LOGGER.info("Start");
		LOGGER.debug("{}");
		ArrayList<Employee> employees = new ArrayList<>();
		Employee employee =null;
		try(Connection connection = UtilNew.getConnection()){
			String query = "SELECT * FROM employee";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				String name = result.getString("name");
				String emails = result.getString("email");
				String passwords = result.getString("password");
				employee = new Employee(name,emails,passwords);
				employees.add(employee);
			}
		}
			catch(SQLException e){
				LOGGER.error("Error inserting customer",e);
				throw new AppException();
			}
			
		
		return employees;
		
	}

}

