package com.revature.models;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Objects;

public class Accounts {
	

	//private List <Double> customerAccounts = new ArrayList<>();
	private int accountNumber;
	private String username;
	private String password;
	private double balance;
	private boolean active;
	
	
	public Accounts(int accountNumber, String username, String password, double balance, boolean active) {
		super();
		this.accountNumber = accountNumber;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.active = active;
	}


	public Accounts() {
		super();
	}
	
	
	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, active, balance, password, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		return accountNumber == other.accountNumber && active == other.active
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", username=" + username + ", password=" + password
				+ ", balance=" + balance + ", active=" + active + "]";
	}
	
	
	
	

	
	
	
}
