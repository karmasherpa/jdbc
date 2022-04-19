package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectParticular {
	static String dburl = "jdbc:mysql://localhost:3306/sampledb";
	static String username = "root";
	static String password = "root";
	static Connection conn;

	public static void main(String[] args) {
		
		
		try {
			// loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection
			conn = DriverManager.getConnection(dburl, username, password);

			// fire statement
			PreparedStatement ps = conn.prepareStatement("select * from user where id =?");
			ps.setInt(1, 6);

			// excecute result
			ResultSet resultSet = ps.executeQuery();
			
			// can use while also
			if (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " "
						+ resultSet.getString(5));
			}
			else {
				System.out.println("Data not available");
			}
		
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

