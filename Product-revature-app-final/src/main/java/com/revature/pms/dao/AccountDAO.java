package com.revature.pms.dao;

import java.util.List;

import com.revature.pms.exceptions.AccountException;
import com.revature.pms.model.User;

public interface AccountDAO {

	public Integer updateAccount(Integer accountNo) throws AccountException;
	public Integer DeleteAccount(Integer accountNo) throws AccountException;
	public List ViewAccount(Integer accountNo) throws AccountException;
}
