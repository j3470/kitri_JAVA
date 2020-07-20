package cds;

import database.dao.UserDAO;

public class User {
	
	private static UserDAO dao = new UserDAO();
	
	public static Boolean createUser(String name, String password) {
		return dao.createUser(name, password);
	}
	
	public static Boolean CheckUser(String name, String password) {
		return dao.checkUser(name, password);
	}
}
