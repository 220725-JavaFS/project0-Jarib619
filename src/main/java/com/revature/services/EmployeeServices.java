package com.revature.services;

import com.revature.daos.EmployeesAdminDAOImpl;

import com.revature.models.Employees;

public class EmployeeServices {
	
	private EmployeesAdminDAOImpl emplDao = new EmployeesAdminDAOImpl();

	public Employees getEmployeeByCredential(String username, String password) { //instead of ID, it's by username and password
		return emplDao.getEmployeeByCredentials(username, password);
}
}
