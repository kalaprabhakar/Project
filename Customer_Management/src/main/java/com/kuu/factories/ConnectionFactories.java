package com.kuu.factories;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactories {

	private static Connection connection = null;
	
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prabhakar", "root", "root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		return connection;
	}
	
}
