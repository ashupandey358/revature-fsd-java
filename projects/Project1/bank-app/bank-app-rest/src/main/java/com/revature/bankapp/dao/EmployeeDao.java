package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.bankapp.exception.AppException;
import com.revature.banknew.model.Employee;

public interface EmployeeDao {
	void create(Employee employee) throws AppException;
	public Employee getLoginDetails(String email) throws AppException;
}
