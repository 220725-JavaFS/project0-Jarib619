package com.revature.services;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.Customers;

public class CustomerServices {
	
	private CustomerDAO customerDao = new CustomerDAOImpl();
	
	public Customers getSingleCustomer(int id) {
		return customerDao.getCustomersByID(id);
	}

}
