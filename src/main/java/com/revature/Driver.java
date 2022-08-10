package com.revature;

import java.util.Scanner;

import com.revature.controllers.*;
import com.revature.services.AccountServices;

public class Driver {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		AccountController ac = new AccountController();
		
		System.out.println("Hello, welcome to Bank of Jarib. Are you:?"
				+ "\n1. an existing customer"
				+ "\n2. an employee"
				+ "\n3. an admin"
				+ "\n4. a new customer and would like to apply for a bank account"
				+ "\n0. none of the above");
		
		String input = scan.nextLine();
		
		if(input.toLowerCase().trim().equals("yes")) {
			rc.register();
			ac.customerService();
			
		}
		else {
			System.out.println("Have a nice day.");
		}
		
	
	
		
		
	}
	
}
