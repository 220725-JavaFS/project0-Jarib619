package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Accounts;
import com.revature.models.Employees;


public class RegisterController {

	private Scanner scan = new Scanner(System.in);
	
	
	public void register() {
		
		System.out.println("Great! We will need a username and a password.\nPlease provide a username for the account?");
		
		String username = scan.nextLine();
		
		System.out.println("Please provide a secure password for the account.");
		
		String password = scan.nextLine();
		
		System.out.println("Thank you. Please save the following information for your records:");
	
		//Account account = new Account(username, password);

		//System.out.println(account);
		
	}
	
	
	
	
}
