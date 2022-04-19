package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectOperation {
	static String dbURL = "jdbc:mysql://localhost:3306/sampledb";
	static String username = "root";
	static String password = "root";
	static Connection conn;
	

	public static void main(String[] args) {
		
		try {
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("To see if driver is loaded or not");
			
			//create a connection 
			conn = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connection is created");
			
			//prepare Statement
			PreparedStatement ps = conn.prepareStatement("select * from user");
			
			//execute result
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {

				System.out.println(resultSet.getInt(1)+ "  " + resultSet.getString(2) + " " +resultSet.getString(3)+ " " +resultSet.getString(4)+ " " +resultSet.getString(5));
			}
			
			//close the connection
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
