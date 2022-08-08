package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Accounts;
import com.revature.services.AccountServices;

public class AccountController {

	private Scanner scan = new Scanner(System.in);
	
	public void customerService() {
		System.out.println("Is there anything we can do for you? (yes or no)");
		if(scan.nextLine().toLowerCase().trim().equals("yes")) {
			accountConfigurations();
		}
		else {
			System.out.println("Have a wonderful day.");
		}
	}

	public void accountConfigurations() {
		
		AccountServices account = new AccountServices();
		Accounts acc = new Accounts();

		boolean bool = true;
		while (bool) {
			System.out.println(
					"What can we help with? Select 1 for withdraw, 2 for deposite, 3 for transfer, 4 for balance or 0 to exit.");
			int input = Integer.parseInt(scan.nextLine());
			double amount = 0;

			boolean bool2 = true;
			switch (input) {

			case 1:	
				while (bool2) {
					System.out.println("How much would you like to withdraw?");
					amount = Double.parseDouble(scan.nextLine());
					
					if (amount > 0) {
						System.out.println(account.withdraw(amount));
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
						account.deposit(amount);
						bool2 = false;
					} else {
						System.out.println("Invalid input. Please try again.");
					}
				}
				break;
				
			case 3:
				break;
				//System.out.println("Please insert account number to transfer funds to."); 
				//1) check if account is existing on AccountDAO or AccountRepo
				//System.out.println("Please enter an amount you would like to transfer.");
				//2) create transfer method on AccountServices
			//break;
				
			case 4:
				System.out.println("Your account balance is: $" + acc.getBalance());
				break;
				
			case 0:
				bool = false;
				break;
				
			default:
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
}

