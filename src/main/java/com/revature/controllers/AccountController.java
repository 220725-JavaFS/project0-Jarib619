package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Accounts;
import com.revature.models.Customers;
import com.revature.services.AccountServices;

public class AccountController {

	private Scanner scan = new Scanner(System.in);
	private int tempId;
	private AccountServices as = new AccountServices();

	public void setTempIdByUsername(String username) {
		this.tempId = as.getAccountIDByUsername(username);
	}
	
	public int getTempIdByUsername(String username) {
		return this.tempId;
	}
	
	public void createAccountMenu() {
		System.out.println("Would you like to place an initial deposit on your new account?");
		String input = scan.nextLine();
		
		if (input.trim().toLowerCase() == "yes") {
			System.out.println("How much would you like to deposit?");
			as.createAccount(this.tempId, Double.parseDouble(scan.nextLine()));
		} else {
			as.createAccount(this.tempId, 0.0);
		}
	}
	
/*
	
	public void accountConfigurations() {
		
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
						System.out.println(as.withdraw(amount));
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
						as.deposit(amount);
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
				//System.out.println("Your account balance is: $" +// account.getBalance());
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
	
	*/
	
	
	
	
}

