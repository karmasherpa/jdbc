package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteOperation {
static String dburl = "jdbc:mysql://localhost:3306/sampledb";
static String username = "root";
static String password = "root";
static Connection conn;

	public static void main(String[] args) {
		
		//load Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//create connection
			conn = DriverManager.getConnection(dburl,username,password);
			
			//fire query
			PreparedStatement ps = conn.prepareStatement("DELETE from user where id = ?");
			ps.setInt(1, 4);
			
			//execute query
			int i = ps.executeUpdate();
			
			if(i>0) {
				System.out.println("Deleted successfully");
			}
			else {
				System.out.println("Data not found");
			}
			
		} catch (ClassNotFoundException | SQLException e ) {
			
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
