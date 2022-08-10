package com.revature.controllers;

import java.util.Scanner;

public class Greetings {

	private CustomerController cust = new CustomerController();
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
				if (cust.existingCustomer()) {
					//System.out.println
					//cust.viewAllAccounts();
					bool = false;
				}else {
					bool=true;
				}
					break;
			case 2:
					if(cust.existingEmployee()) {
						bool=false;
					} else {
						bool=true;
					}
					break;
			case 3:
					if(cust.existingEmployee()) {
						bool=false;
					}
					else {
						bool=true;
					}  
					break;
			case 4:
					cust.createCustomerMenu();
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

}
