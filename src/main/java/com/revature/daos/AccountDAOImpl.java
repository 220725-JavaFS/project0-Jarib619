package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Accounts;
import com.revature.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Accounts getAccountByNum(int number) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM accounts WHERE account_number = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, number); // this is where SQL injection is checked for. Tim used the example of String though.
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				Accounts account = new Accounts();
				account.setAccountNumber(result.getInt("account_number"));
				account.setBalance(result.getDouble("account_balance"));
				account.setActive(result.getBoolean("account_active"));
				return account;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
