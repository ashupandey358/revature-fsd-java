package com.revature.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemoPrepared {

	public static void main(String[] args) {
		try {
			// Driver driver = new Driver
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learndb", "root",
					"@Shu1234");
			String sql = "insert into department (name) values (?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "Statistics");
			statement.executeUpdate(); // insert to database
			// statement.executeQuery("") //use to get data
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
