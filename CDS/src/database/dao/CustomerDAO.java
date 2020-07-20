package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.oracle.OracleDatabaseConnector;

public class CustomerDAO {
	
	private OracleDatabaseConnector dbConnector = new OracleDatabaseConnector("localhost", 1521, "xe", "c##ora_user", "yeo");
	
	private final String tableName = "customer2";
	
	public CustomerDAO() {
		createCustomerTable();
	}
	
	public Boolean createCustomerTable() {
		try{
			Connection conn = dbConnector.getConnection();
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE " + tableName + 
					" (" + 
					"    name VARCHAR2(255)," + 
					"    gender VARCHAR2(255)," + 
					"    year VARCHAR2(255)," + 
					"    month VARCHAR2(255)," + 
					"    day VARCHAR2(255)," + 
					"    admission VARCHAR2(255)," + 
					"    grade VARCHAR2(255)" + 
					" )");
			create.execute();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public ArrayList<String> getCustomers(){
		try{
			Connection con = dbConnector.getConnection();
			PreparedStatement statement = con.prepareStatement("Select * FROM " + tableName);
			ResultSet results = statement.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while(results.next()){
				list.add("Name : "+ results.getString("name") + "\n" +
						" gender "+ results.getString("gender") + "\n" + 
						" year : "+ results.getString("year")+ "\n" +
						"month :"+results.getString("month")+ "\n" +
						"day:"+results.getString("day")+ "\n" +
						"admission:"+results.getString("admission")+ "\n" +
						"grade:"+results.getString("grade") + "\n");
			}
			return list;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Boolean createCustomer(String name,String gendervalue, String year, String month, String day, String adyear, String gradevalue) {
		try {
			Connection con = dbConnector.getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO " + tableName
					+ "(name, gender, year, month, day, admission, grade) "
					+ "VALUES "
					+ "('"+name+"','"+gendervalue+"','"+year+"','"+month+"','"+day+"','"+adyear+"','"+gradevalue+"')");
			insert.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
