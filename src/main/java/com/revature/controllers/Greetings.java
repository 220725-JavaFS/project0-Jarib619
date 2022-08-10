package com.revature.controllers;

import java.util.Scanner;

public class Greetings {

	private Scanner scan = new Scanner(System.in);

	public void greeting() {
		
	System.out.println("Hello, welcome to Bank of Jarib. Are you:?"
			+ "\n1. an existing customer"
			+ "\n2. an employee"
			+ "\n3. an admin"
			+ "\n4. a new customer and would like to apply for a bank account"
			+ "\n5. exit the premises");
	CustomerController cust = new CustomerController();
	int userInput = 0;
	while(userInput!=5) {	
		
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
				cust.existingCustomer();
				break;
			case 2:
				EmployeeController empl = new EmployeeController();
				empl.employeeMenu();
				break;
			case 3:
				AdminController admin = new AdminController();
				admin.adminMenu();
				break;
			case 4:
				cust.createCustomerMenu();; 
				break;
			case 5:
				System.out.println("Have a nice day!"); 
				break;
			default:
				System.out.println("Please insert a valid input.");
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		Greetings greet = new Greetings();
		greet.greeting();
	
	}

}