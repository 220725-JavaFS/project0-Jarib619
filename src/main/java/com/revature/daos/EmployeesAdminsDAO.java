package com.revature.daos;


import com.revature.models.Admin;
import com.revature.models.Employees;

public interface EmployeesAdminsDAO {

	public Employees getEmployeeByCredentials(String username, String password);
	
	public Admin getAdminByCredentials(String username, String password);
}
