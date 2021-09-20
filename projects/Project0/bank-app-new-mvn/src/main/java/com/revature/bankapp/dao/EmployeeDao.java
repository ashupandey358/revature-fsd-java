package com.revature.bankapp.dao;

import java.sql.SQLException;

import com.revature.banknew.model.EmployeeModel;

public interface EmployeeDao {
	void employeeData(EmployeeModel employee) throws SQLException;
	public EmployeeModel getEmail(String email) throws SQLException;
}
