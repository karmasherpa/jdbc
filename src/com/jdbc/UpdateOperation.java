package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateOperation {
	static String dburl = "jdbc:mysql://localhost:3306/sampledb";
	static String username = "root";
	static String password ="root";
	static Connection conn;
	
	public static void main(String[] args) {
		
		try {
			//load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//create connection
			conn = DriverManager.getConnection(dburl,username,password);
			
			//fire query
			PreparedStatement ps = conn.prepareStatement("UPDATE user SET first_name ='Lakpa' WHERE id =3");
			
			//execution
			int i = ps.executeUpdate();
			
			if(i>0) {
				System.out.println("Updated successfully");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				conn.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		

	}

}