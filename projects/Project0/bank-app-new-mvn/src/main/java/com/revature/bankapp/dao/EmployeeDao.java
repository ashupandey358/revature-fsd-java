package com.revature.bankapp.dao;

import java.sql.SQLException;
import com.revature.banknew.form.EmployeeForm;

public interface EmployeeDao {
	void employeeData(EmployeeForm employee) throws SQLException;
	public EmployeeForm getEmail(String email) throws SQLException;
}
