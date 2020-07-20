package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.oracle.OracleDatabaseConnector;

public class UserDAO {
	
	private OracleDatabaseConnector dbConnector = new OracleDatabaseConnector("localhost", 1521, "xe", "c##ora_user", "yeo");
	
	private final String tableName = "user2";
	
	public UserDAO() {
		createUserTable();
		Boolean isCreated = checkUser("jo", "jo");
		if (! isCreated)
			createUser("jo", "jo");
	}
	
	public Boolean createUserTable() {
		try{
			Connection conn = dbConnector.getConnection();
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE " + tableName + 
					" (" + 
					"    name VARCHAR2(255)," + 
					"    password VARCHAR2(255)" +  
					" )");
			create.execute();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public ArrayList<String> getUsers(){
		try {
			Connection con = dbConnector.getConnection();
			PreparedStatement statement = con.prepareStatement("Select * FROM " + tableName);
			ResultSet results = statement.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while(results.next()){
				list.add("name : "+ results.getString("name") + "\n" +
						" password "+ results.getString("password") + "\n");
			}
			return list;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Boolean checkUser(String name, String password){
		try {
			Connection con = dbConnector.getConnection();
			String query = "SELECT COUNT(*) AS total FROM " + tableName + " WHERE name='"+name+"' AND password='"+password+"'";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			results.next();
			int count = results.getInt("total");
			if (count > 0) {
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean createUser(String name,String password) {
		try {
			Connection con = dbConnector.getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO " + tableName
					+ "(name, password) "
					+ "VALUES "
					+ "('"+name+"','"+password+"')");
			insert.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
