package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.banknew.model.EmployeeModel;

public interface EmployeeDao {
	void employeeData(EmployeeModel employee) throws SQLException;
	public ArrayList<EmployeeModel> getemployeelist() throws SQLException;
}
