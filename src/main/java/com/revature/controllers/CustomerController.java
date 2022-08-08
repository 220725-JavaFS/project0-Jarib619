package com.revature.controllers;

import com.revature.services.CustomerServices;

public class CustomerController {
	
	private CustomerServices customerService = new CustomerServices();
	
	public void customerMenu() {
		System.out.println("What would you like to do concerning the Customers?"
				+"\n1. Customer //
				+ "\n 2. Employee"
				+ "\n 3. Admin");
		
		seeCustomerInfo();
	}
	
	public void seeCustomerInfo() {
		System.out.println("Are you a new user or existing? 1 for new, 2 for existing");
		//String answer = scan.nextLine(); 
		
		//if ()
			//get all customers info
		
		//else if....
		
		//else {
		//int id = 0
		//try {id = Integer.parseInt(answer)} catch (NumberFormatException e){
		// System.out.println("Not valid answer, try again"); 
		//continue;}
		
		//Customers customer = customerServices.getSingleCustomer(id);
		//System.out.println("Here is your customer" + customer);
	}
		
}
