package com.revature.controllers;

import java.sql.Connection;
import java.sql.SQLException;
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
import com.revature.utils.ConnectionUtil;

public class CustomerController {
	
	private String tempUsername;
	private int tempId;
	private double tempBalance;
	private CustomerServices cs = new CustomerServices();
	private EmployeeServices es = new EmployeeServices();
	private AccountServices as = new AccountServices();
	private Scanner scan = new Scanner(System.in);
	
	
	//--------------------------------------------------------------------------------------
	
	public void greeting() {
		System.out.println("Please select one of the following:"
				+ "\n1. existing customer"
				+ "\n2. employee"
				+ "\n3. admin"
				+ "\n4. new customer and would like to apply for a bank account"
				+ "\n5. exit the premises");
		
		
		int userInput = 0;
			
			boolean bool1 = true;
			while(bool1) { // for valid input on userOption 
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
					existingCustomer();
						break;
				case 2:
						existingEmployee();
						break;
				case 3:
						existingEmployee();
						
						break;
				case 4:
						createCustomerMenu();
						createAccountMenu();
						break;
				case 5:
						System.out.println("Have a nice day!"); 
						break;
					
				default:
						System.out.println("Please insert a valid input.");
					}
			
		}
	//}
	
	//-------------------------------------------------------------------------Might want to change the boolean thing!-------------

	public void existingCustomer() {
		System.out.println("Welcome back sir. To verify it's you, we will first need your username.");
		String username = scan.nextLine();
		System.out.println("Now please provide your password.");
		String password = scan.nextLine();
				
		Customers cust = cs.getSingleCustomer(username, password);
		
		if (cust!=null) {
			
			System.out.println("You have successfully logged in.");
			System.out.println("Here is your info: " + cust);
			accountConfigurations(cust.getAccountNumber());
		}
		else {
			System.out.println("Sorry, invalid credentials. You will be directed back to main menu.");
		}
		greeting();
	}
	
	//--------------------------------------------------------------------------------------------------------

	public void createCustomerMenu() {
		System.out.println("Great! Thank you for registering. Please fill out the following information for the application:"
				+ "\nWhat username would you like for the account.");
		
		Customers customer = new Customers();
		tempUsername = scan.nextLine();
		customer.setUsername(tempUsername);
		
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
		customer.setZipcode(Integer.parseInt(scan.nextLine()));
		
		cs.createCustomer(customer);
		setTempIdByUsername(tempUsername);
	}

	//-------------------------------------------------------------------------AccountSettings-------------
	
	public void setTempIdByUsername(String username) {
		this.tempId = as.getAccountIDByUsername(username);
	}
	
	public int getTempIdByUsername(String username) {
		return this.tempId;
	}
	
	public void createAccountMenu() { // this creates a row in the database, making it available to link both tables
		System.out.println("Would you like to place an initial deposit on your new account?");
		
			String input1 = scan.nextLine().toLowerCase().trim();
			if (input1.equals("yes")) {
				System.out.println("How much would you like to deposit?");
				input1 = scan.nextLine();
				this.tempBalance = Double.parseDouble(input1);
				as.createAccount(this.tempId, this.tempBalance);
			} else {
				as.createAccount(this.tempId, 0.0);
			}
		greeting();
	}
	
	public static void main(String[] args) {
		CustomerController cc = new CustomerController();
		cc.createAccountMenu();
	}
	
	//-------------------------------------------------------------------------NOT USING existingEmployee!-------------
	
		public void existingEmployee() {
			System.out.println("Welcome back sir. To verify it's you, we will first need your username.");
			String username = scan.nextLine();
			System.out.println("Now please provide your password.");
			String password = scan.nextLine();
			
			Employees empl = es.getEmployeeByCredential(username, password);
			if (empl!=null) {
				
				System.out.println("You have successfully logged in.");
				System.out.println("Here is your info: " + empl);
			}
			else {
				System.out.println("Sorry, invalid credentials. You will be directed back to main menu.");
			}
			greeting();
		}
	
	//-------------------------------------------------------------------------NOT USING accountCOnfig Yet!-------------
	
	
	public void accountConfigurations(Accounts account) {
		
		//double acc = cs.getBalances(tempUsername);
		this.tempBalance = account.getBalance();
		
		System.out.println("You're current account balance is: $"+this.tempBalance);
		
		boolean bool = true;
		while (bool) {
			System.out.println(
					"What can we help with? Select 1 for withdraw, 2 for deposite, 3 for balance or 0 to exit.");
			int caseInput = Integer.parseInt(scan.nextLine());
			double amount = 0;

			boolean bool2 = true;
			switch (caseInput) {

			case 1:	
				while (bool2) {
					System.out.println("How much would you like to withdraw?");
					amount = Double.parseDouble(scan.nextLine());
					
					if (amount > 0) {

						this.tempBalance = withdraw(amount);
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
						this.tempBalance = deposit(amount);
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
				System.out.println("You are now exiting to main menu.");
				bool = false;
				break;
				
			default:
				System.out.println("Invalid input. Please try again.");
			}
		}
		
		as.updateAccount(this.tempId, this.tempBalance);
		//-----------------------------------------------------------------------------------Services------
	}
		public double withdraw(double withdrawAmount) {
			
			double newBalance = 0;
			
			if (withdrawAmount <= this.tempBalance) {
				newBalance = this.tempBalance - withdrawAmount;
				System.out.println("You have withdrawn $"+withdrawAmount+". Your new balance is $"+newBalance);
				return newBalance;
			} else {
				System.out.println("Sorry, not enough funds avaliable.");
				return this.tempBalance;
			}
		}
			
		
		public double deposit(double depositeAmount) {
			double newBalance = 0;
			newBalance = this.tempBalance + depositeAmount;
			System.out.println("You have deposite $"+depositeAmount+". Your new balance is $"+newBalance);
			return newBalance;
		}
}

	
	
	


