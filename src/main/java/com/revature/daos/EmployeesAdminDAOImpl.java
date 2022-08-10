package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Admin;
import com.revature.models.Employees;
import com.revature.utils.ConnectionUtil;

public class EmployeesAdminDAOImpl implements EmployeesAdminsDAO {
	
	public Employees getEmployeeByCredentials(String username, String password) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM employees_admin WHERE username = ? AND pass_word = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, username); // this is where SQL injection is checked for. Tim used the example of String though.
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				Employees employee = new Employees(
						result.getString("username"),
						result.getString("pass_word"),
						result.getString("job_role"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getBoolean("approval_authority"),
						result.getBoolean("account_authority")
						);
				return employee;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
