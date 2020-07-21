package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.oracle.OracleDatabaseConnector;

public class UserDAO {
	
	private OracleDatabaseConnector dbConnector = new OracleDatabaseConnector("localhost", 1521, "xe", "c##testuser", "testuser");
	
	private final String tableName = "APP_USER";
	
	public UserDAO() {
		/*
		 * //createUserTable(); Boolean isCreated = checkUser("admin", "admin"); if
		 * (!isCreated) { //createUser("admin", "admin", "admin", "admin",
		 * "admin@admin.com", "010-1234-5678"); }
		 */
	}
	
	/*
	 * public Boolean createUserTable() { try{ Connection conn =
	 * dbConnector.getConnection(); PreparedStatement create =
	 * conn.prepareStatement( "CREATE TABLE " + tableName + " (" +
	 * "    name VARCHAR2(255)," + "    password VARCHAR2(255)" + " )");
	 * create.execute(); return true; } catch (Exception e) {
	 * System.out.println(e.getMessage()); } return false; }
	 */
	
		
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
			String query = "SELECT COUNT(*) AS total FROM " + tableName + " WHERE ID='"+name+"' AND PASSWD='"+password+"'";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			results.next();
			int count = results.getInt("total");
			if (count > 0) {
				System.out.println("test");
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean createUser(String id, String password, String type, String name, String email, String phone) {
		try {
			Connection con = dbConnector.getConnection();
			PreparedStatement insert1 = con.prepareStatement(""
					+ "INSERT INTO " + tableName
					+ "(ID, PASSWD, USER_TYPE) "
					+ "VALUES "
					+ "('"+id+"','"+password+"','"+type+"')");
			PreparedStatement insert2;
			
			if(type.equals("instructor")) {
				insert2 = con.prepareStatement(""
						+ "INSERT INTO INSTRUCTOR(ID, EMAIL, PHONE, NAME) "
						+ "VALUES "
						+ "('"+id+"','"+email+"','"+phone+"','"+name+"')");
			} else if(type.equals("staff")) {
				insert2 = con.prepareStatement(""
						+ "INSERT INTO STAFF(ID, EMAIL, PHONE, NAME) "
						+ "VALUES "
						+ "('"+id+"','"+email+"','"+phone+"','"+name+"')");
			} else 
				insert2 = null;
			insert1.executeUpdate();
			if(insert2 != null ) insert2.executeUpdate();
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
