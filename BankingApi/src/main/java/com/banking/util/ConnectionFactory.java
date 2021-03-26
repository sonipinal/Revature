package com.banking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * This is a utility class that will be used to return JDBC connections
 * as needed. Using this abstraction, we can write the code that handles
 * passing in our credentials a single time.
 */
public class ConnectionFactory {

	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			/*
			 * If your Driver class cannot be located, you can force Java to load
			 * the class like so:
			 */
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(
					System.getenv("url"),
					System.getenv("postgres_username"),
					System.getenv("postgres_password")
		);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
				
	}
}

