package javadb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e); 
		}
	}
	
}
