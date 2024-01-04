package com.sjprogramming.emapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	static Connection con;
	public static  Connection createDBConnection() {
		
		try {
			// Load Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/employeeDB?useSSL=false";
			String username = "root";
			String password= "root_pass_1234";
			
			// Get connection 
			con = DriverManager.getConnection(url, username, password);
		
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
		
	}

}
