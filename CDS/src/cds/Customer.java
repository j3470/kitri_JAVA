package cds;

import java.util.ArrayList;

import database.dao.CustomerDAO;

public class Customer {
	
	private static CustomerDAO dao = new CustomerDAO();
	
	public static Boolean createCustomer(String name, String gender, String year, String month, String day, String addmission, String grade) {
		return dao.createCustomer(name, gender, year, month, day, addmission, grade);
	}
	
	public static void main(String[] args ) {
		Boolean isCreate;
		
		if (! dao.createCustomerTable()) {
			System.out.println("Customer Table Exist or Not Created");
		}
		
		isCreate = dao.createCustomer("jo", "male", "1994", "3", "31", "2013", "4");
		if (! isCreate) {
			System.out.println("Customer Not Created");
		}
		
		System.out.println("=====================================");
		ArrayList<String> list = dao.getCustomers();
		for(String item: list){
			System.out.println(item);
		}
		System.out.println("=====================================");
		
		isCreate = dao.createCustomer("kim", "female", "1994", "4","4","2016","2");
		if (! isCreate) {
			System.out.println("Customer Not Created");
		}
		
		list = dao.getCustomers();
		for(String item: list){
			System.out.println(item);
		}
		System.out.println("=====================================");
	}
}
