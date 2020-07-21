package cds;

import database.dao.UserDAO;

public class User {
	
	private static UserDAO dao = new UserDAO();
	
	public static Boolean createUser(String id, String password, String type, String name, String email, String phone) {
		return dao.createUser(id, password, type, name, email, phone);
	}
	
	public static Boolean CheckUser(String name, String password) {
		return dao.checkUser(name, password);
	}
	
}
