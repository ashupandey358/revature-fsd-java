package com.revature.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
	//1st step
	
	public static Connection getConnection() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Wrong class ");
			e.printStackTrace();
		}
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bankapp",
				 "root",
				"@Shu1234");
	}

}
