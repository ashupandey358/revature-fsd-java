package com.revature.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDemo {

	public static void main(String[] args) {
		
		try {
			// Driver driver = new Driver
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learndb", "root",
					"@Shu1234");
			//update employee set name =?,salary=?,gender=?,department_id=? where id=?
			//delete from employee where id = ?
			String sql = "select * from employee";
			PreparedStatement statement = connection.prepareStatement(sql);
			 
			 ResultSet resultSet= statement.executeQuery(); 
			 while(resultSet.next())
			 {
				 System.out.print(resultSet.getString("name"));
				 Sysout
				 System.out.println(resultSet.getInt("salary"));
			 }
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	}


