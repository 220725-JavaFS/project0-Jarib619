package com.revature.controllers;

import java.util.Scanner;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.Customers;

public class EmployeeController {
	
	Scanner scan = new Scanner(System.in);

	public void employeeMenu() {
		System.out.println("Welcome back sir. To verify it's you, we will first need your username.");
		String username = scan.nextLine();
		System.out.println("Now please provide your password.");
		String password = scan.nextLine();

		CustomerDAO cDao = new CustomerDAOImpl();
		cDao.getCustomerByCredential(username, password);
			 
	}

	public static void main(String[] args) {
		EmployeeController ec = new EmployeeController();
		ec.employeeMenu();
		Customers cust = new Customers();
		System.out.println(cust);
	}
}
