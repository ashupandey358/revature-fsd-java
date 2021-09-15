package com.revature.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
			Connection connection = null;
	public static void main(String[] args) {
		try {
			// Driver driver = new Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/learndb",
					 "root",
					"@Shu1234");
			System.out.println(connection.getClass().getName());
			System.out.println("Connection successful.");
			String sql = "insert into department (name) values ('Innovation')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql); //insert to database
			//statement.executeQuery("") //use to get data
			connection.close();
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
