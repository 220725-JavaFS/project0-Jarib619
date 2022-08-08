package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Accounts;
import com.revature.models.Customers;
import com.revature.utils.ConnectionUtil;


public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Customers getCustomersByID(int id) {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM customers WHERE customer_id = "+id+";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			//resultSets are cursor based, each time .next is called the cursor moves to the next group of values.
			//it starts one before so you always need to call next.
			if(result.next()) {
				Customers customer = new Customers(
						result.getInt("customer_id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("home_number"),
						result.getString("street_name"),
						result.getString("city"),
						result.getString("state"),
						result.getInt("zipcode"),
						// result.getInt("account_number") skipping atm
						null
						);
				int accountNumber = result.getInt("account_number");
				if(accountNumber!=0) { // checks if there's an accountNumber in the database
					AccountDAO accountDao = new AccountDAOImpl(); // if there is, accountDao gets that information
					Accounts account = accountDao.getAccountByNum(accountNumber); // make another call to the home??
					customer.setAccountNumber(account); // set the account into customer
				}
				
				return customer;
						
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	@Override
	public List<Customers> getAllCustomers() {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM customers LEFT JOIN accounts ON customers.account_number = accounts.account_number;"; //returns all info from both tables
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			//resultSets are cursor based, each time .next is called the cursor moves to the next group of values.
			//it starts one before so you always need to call next.
			
			List<Customers> customerList = new ArrayList<>();
			
			while(result.next()) { // instead of if statement, the while statement will keep returning the next result of the queue.
				Customers customer = new Customers(
						result.getInt("customer_id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("home_number"),
						result.getString("street_name"),
						result.getString("city"),
						result.getString("state"),
						result.getInt("zipcode"),
						// result.getInt("account_number") skipping atm
						null
						);
				int accountNumber = result.getInt("account_number");
				if(accountNumber!=0) { // checks if there's an accountNumber in the database
					Accounts account = new Accounts();
					account.setAccountNumber(accountNumber);
					account.setUsername(result.getString("username")); 
					account.setPassword(result.getString("pass_word"));
					account.setBalance(result.getDouble("account_balance"));
					account.setActive(result.getBoolean("account_status"));
					customer.setAccountNumber(account); // set the account into customer
				}
				customerList.add(customer); // this will add a customer to arrayList after every creation
			}
			return customerList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	public static void main(String[] args) {
		CustomerDAO cDao = new CustomerDAOImpl();
		
		List<Customers> list = cDao.getAllCustomers();
		System.out.println(list);
	}
}
