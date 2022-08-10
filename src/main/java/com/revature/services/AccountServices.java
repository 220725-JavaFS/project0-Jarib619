package com.revature.services;

import com.revature.models.Accounts;
import com.revature.models.Customers;

public class AccountServices {
	
	public String withdraw(double amount) {
		
		Accounts account = new Accounts();
		double newBalance = account.getBalance() - amount;
		
		if (newBalance > 0) {
			account.setBalance(newBalance);
			return "You have withdrawn $"+amount+". Your new balance is $"+newBalance;
		} else {
			return "Sorry, not enough funds avaliable.";
		}
	}
		
	public String deposit(double amount) {
		
		Accounts account = new Accounts();
		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
		return "You have deposite $"+amount+". Your new balance is $"+newBalance;
	}
	
	/*
	public String transfer(double amount) {
		
		Accounts acc = new Accounts();
		double newBalance = acc.getBalance() - amount;
		
		if (newBalance > 0) {
			acc.setBalance(newBalance);
			/// add $ to the transferring account
		}
		*/

}