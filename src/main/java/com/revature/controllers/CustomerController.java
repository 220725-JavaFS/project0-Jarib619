package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.Customers;
import com.revature.services.CustomerServices;

public class CustomerController {
	
	private CustomerServices cs = new CustomerServices();
	private Scanner scan = new Scanner(System.in);

	
	public boolean existingCustomer() {
		System.out.println("Welcome back sir. To verify it's you, we will first need your username.");
		String username = scan.nextLine();
		System.out.println("Now please provide your password.");
		String password = scan.nextLine();
				
		Customers cust = cs.getSingleCustomer(username, password);
		if (cust!=null) {
			
			System.out.println("You have successfully logged in.");
			System.out.println("Here is your info: " + cust);
		
		return true;
		}
		else {
			System.out.println("Sorry, invalid credentials. You will be directed back to main menu.");
			Greetings greet = new Greetings();
			greet.greeting();
			return false;
		}
	}
	
	

	public void createCustomerMenu() {
		System.out.println("Great! Thank you for registering. Please fill out the following information for the application:"
				+ "\nWhat username would you like for the account.");
		
		Customers customer = new Customers();
		customer.setUsername(scan.nextLine());
		
		System.out.println("Please provide a secure password.");
		String encryptedPassword = CustomerServices.encryption(scan.nextLine());
		customer.setPassword(encryptedPassword);
		
		
		System.out.println("What is your first name?");
		customer.setFirstName(scan.nextLine());
		
		System.out.println("What is your last name?");
		customer.setLastName(scan.nextLine());
		
		System.out.println("What is your home number?");
		customer.setHomeNumber(scan.nextLine());
		
		System.out.println("What is your street name?");
		customer.setStreetName(scan.nextLine());
		
		System.out.println("What city do you live in?");
		customer.setCity(scan.nextLine());
		
		System.out.println("What state do you live in?");
		customer.setState(scan.nextLine());
		
		System.out.println("What's your area's zip code?");
		customer.setZipcode(scan.nextInt());
		
		cs.createCustomer(customer);
	}
	

	
	
	public static void main(String[] args) {
		/*EmployeeController ec = new EmployeeController();
		ec.employeeMenu();
		Customers cust = new Customers();
		System.out.println(cust);
		*/
		
		//creates new customer into database
		CustomerController cc = new CustomerController();
		//cc.createCustomerMenu();
		cc.existingCustomer();
		
		
		
		//Only Admin calls this.
	//	CustomerDAO cDao = new CustomerDAOImpl();
	//	List<Customers> list = cDao.getAllCustomers();
	//	System.out.println(list);
		
		
	}
	
}

