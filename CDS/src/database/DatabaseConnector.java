package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	private String DB_URL;
	private String DB_USER;
	private String DB_PASSWORD;
	
	public DatabaseConnector(String url, String user, String password) {
		this.DB_URL = url;
		this.DB_USER = user;
		this.DB_PASSWORD = password;
	}

	public Connection getConnection(String className) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		
		Class.forName(className);
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return conn;
	}
	
}
