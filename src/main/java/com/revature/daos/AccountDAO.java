package com.revature.daos;

import com.revature.models.Accounts;

public interface AccountDAO {

	public Accounts getAccountByNum(int number);
}
