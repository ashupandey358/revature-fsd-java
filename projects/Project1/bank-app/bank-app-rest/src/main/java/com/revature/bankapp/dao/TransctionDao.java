package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.banknew.model.Account;
import com.revature.banknew.model.Customer;
import com.revature.banknew.model.Transction;

public interface TransctionDao {
	public Account currentAmount(String accountNo) throws SQLException;

	public void transctionCreate(Transction transction) throws SQLException;

	public void forWithdrawal(long updatedbalance, String accountno) throws SQLException;

	public void forDeposite(long updatedbalance1, String accountno2) throws SQLException;

	public List<Transction> viewTransctionforSpecificAccount(String accountNo) throws SQLException;

}
