package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertOperation {
	static String dbURL = "jdbc:mysql://localhost:3306/sampledb";
	static String username = "root";
	static String password = "root";
	static Connection conn;
	
	public static void main(String[] args) {

		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("To see if driver is loaded or not");
			
			//create connection
			conn = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connection is created");
			
			//prepare Statement
			PreparedStatement ps = conn.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?)");
			ps.setInt(1, 4);
			ps.setString(2, "Sam");
			ps.setString(3, "M");
			ps.setString(4, "Jackson");
			ps.setString(5, "samuel@gmail.com");
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				System.out.println("Record inserted successfully");
			}
			
			//close the connection
			conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				
			e.printStackTrace();
		}
		
	}
}
