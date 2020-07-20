package database.oracle;

import java.sql.Connection;
import java.sql.SQLException;

import database.DatabaseConnector;

public class OracleDatabaseConnector extends DatabaseConnector {
	
	private static String className = "oracle.jdbc.driver.OracleDriver";
	
	public OracleDatabaseConnector(String host, Integer port, String db, String user, String password) {
		super("jdbc:oracle:thin:@" + host + ":" + port + ":" + db, user, password);
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		return this.getConnection(this.className);
	}
}
