package com.revature;

import java.util.Scanner;

import com.revature.controllers.*;
import com.revature.services.AccountServices;

public class Driver {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		RegisterController rc = new RegisterController();
		AccountController ac = new AccountController();
		
		System.out.println("Hello, welcome to Bank of Jarib. Would you like to open an account with us?");
		
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
