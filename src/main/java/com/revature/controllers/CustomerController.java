package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.Accounts;
import com.revature.models.Customers;
import com.revature.models.Employees;
import com.revature.services.AccountServices;
import com.revature.services.CustomerServices;
import com.revature.services.EmployeeServices;

public class CustomerController {
	
	private String username;
	private CustomerServices cs = new CustomerServices();
	private EmployeeServices es = new EmployeeServices();
	private Scanner scan = new Scanner(System.in);
	
	public boolean greeting() {
		
		System.out.println("Hello, welcome to Bank of Jarib. Are you:?"
				+ "\n1. an existing customer"
				+ "\n2. an employee"
				+ "\n3. an admin"
				+ "\n4. a new customer and would like to apply for a bank account"
				+ "\n5. exit the premises");
		
		boolean methodBool = true;
		int userInput = 0;
		boolean bool = true;	
		while(bool) {
			boolean bool1 = true;
			while(bool1) {
				try{
					userInput = Integer.parseInt(scan.nextLine());
					bool1 = false;
				}
				catch (Exception e){
					System.out.println("Invalid response, please insert one of the following numbers.");
				}
			}
			switch (userInput){
				case 1: 
					if (existingCustomer()) {
						bool = false;
					}else {
						bool=true;
					}
						break;
				case 2:
						if(existingEmployee()) {
							bool=false;
						} else {
							bool=true;
						}
						break;
				case 3:
						if(existingEmployee()) {
							bool=false;
						}
						else {
							bool=true;
						}  
						break;
				case 4:
						createCustomerMenu();
						bool=false;
						break;
				case 5:
						System.out.println("Have a nice day!"); 
						bool=false;
						return false;
				default:
						System.out.println("Please insert a valid input.");
						continue;
					}
			}return methodBool;
	}


	
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
			greeting();
			return false;
		}
	}
	
	public boolean existingEmployee() {
		System.out.println("Welcome back sir. To verify it's you, we will first need your username.");
		String username = scan.nextLine();
		System.out.println("Now please provide your password.");
		String password = scan.nextLine();
		
		Employees empl = es.getEmployeeByCredential(username, password);
		if (empl!=null) {
			
			System.out.println("You have successfully logged in.");
			System.out.println("Here is your info: " + empl);
		
		return true;
		}
		else {
			System.out.println("Sorry, invalid credentials. You will be directed back to main menu.");
			greeting();
			return false;
		}
	}

	public void createCustomerMenu() {
		System.out.println("Great! Thank you for registering. Please fill out the following information for the application:"
				+ "\nWhat username would you like for the account.");
		
		Customers customer = new Customers();
		customer.setUsername(scan.nextLine());
		
		System.out.println("Please provide a secure password.");
		customer.setPassword(scan.nextLine());
		
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
	

	public void accountConfigurations(Accounts account) {
		AccountServices accServ = new AccountServices();
		double acc = cs.getBalances(username);
		
		System.out.println("You're current account balance is: $"+acc);
		
		boolean bool = true;
		while (bool) {
			System.out.println(
					"What can we help with? Select 1 for withdraw, 2 for deposite, 3 for balance or 0 to exit.");
			int input = Integer.parseInt(scan.nextLine());
			double amount = 0;

			boolean bool2 = true;
			switch (input) {

			case 1:	
				while (bool2) {
					System.out.println("How much would you like to withdraw?");
					amount = Double.parseDouble(scan.nextLine());
					
					if (amount > 0) {
						System.out.println(accServ.withdraw(amount));
						bool2 = false;
					}
					else {
						System.out.println("Please provide a valid input.");
					}
				}
				break;

			case 2:
				while (bool2) {
					System.out.println("How much would you like to deposit?");
					amount = Double.parseDouble(scan.nextLine());
					if (amount > 0) {
						accServ.deposit(amount);
						bool2 = false;
					} else {
						System.out.println("Invalid input. Please try again.");
					}
				}
				break;
			case 3:
				System.out.println("Your account balance is: $" + account.getBalance());
				break;
				
			case 0:
				System.out.println("You are now exiting. Have a wonderful day.");
				bool = false;
				break;
				
			default:
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
	
	
	
	
	
	
	/*

	public void AdminControlls()
	List<Customers> list = cDao.getAllCustomers();
	System.out.println(list);
	for (Customers c: list) {
	    if (c.getUsername().equals("user2")){
	    	Customers cust1 = c;
	    	System.out.println(cust1);
	        break;
	    }
	}
	
	
	
	public static void main(String[] args) {
		EmployeeController ec = new EmployeeController();
		ec.employeeMenu();
		Customers cust = new Customers();
		System.out.println(cust);
		*/
		
		//creates new customer into database
	//	CustomerController cc = new CustomerController();
		//cc.createCustomerMenu();
	//	cc.existingCustomer();
		
		
		
		//Only Admin calls this.
	//	CustomerDAO cDao = new CustomerDAOImpl();
	//	List<Customers> list = cDao.getAllCustomers();
	//	System.out.println(list);
		
		
}
	


