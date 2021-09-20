package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.banknew.model.AccountModel;
import com.revature.banknew.model.CustomerModel;
import com.revature.banknew.model.TransctionModel;


public interface TransctionDao {
	public AccountModel currentAmount(String accountNo) throws SQLException;
	public void transctionCreate(TransctionModel transctionModel) throws SQLException;
	public void forWithdrawal(long updatedbalance,String accountno) throws SQLException;
	public void forDeposite(long updatedbalance1,String accountno2) throws SQLException;
    public List<TransctionModel> viewTransctionforSpecificAccount(String accountNo) throws SQLException ;
}
