package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.controllers.*;
import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.Customers;
import com.revature.services.AccountServices;

public class Driver {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		CustomerController custCom = new CustomerController();
		
		String looper = "";
		while (looper!="exit") {
			custCom.greeting();
			System.out.println("Would you to continue? type 'no' to exit");
			looper=scan.nextLine().toLowerCase().trim();
		}
		
		
		
		
		
		
		
		
		
		//custCom.accountConfigurations();
		


		/*
		System.out.println("Admin is now in control. Would you like to view all accounts");
		if (scan.nextLine().toLowerCase().trim().equals("yes")) {
			
		CustomerDAO cDao = new CustomerDAOImpl();
		List<Customers> list = cDao.getAllCustomers();
		System.out.println(list);
		
		}
		*/
		
		
		//CustomerDAO cDao = new CustomerDAOImpl();
		//cDao.getBalance("user2");
	
		
		scan.close();
	}
	
}
