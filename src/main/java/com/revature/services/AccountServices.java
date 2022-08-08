package com.revature.services;

import com.revature.models.Accounts;

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
		
		Account account = new Account();
		double newBalance = account.getBalance() - amount;
		
		if (newBalance > 0) {
			account.setBalance(newBalance);
			/// add $ to the transferring account
		}
		
	*/
	
	public void encryption() {
		
		Accounts account = new Accounts();
		
		char[] charay = account.getPassword().toCharArray();
		for (int i = 0; i < account.getPassword().length(); i++) {
			charay[i] = (char) (charay[i] + 20);
		}
		String newPassword = new String(charay);
		System.out.println(newPassword);
		
	}
	

}