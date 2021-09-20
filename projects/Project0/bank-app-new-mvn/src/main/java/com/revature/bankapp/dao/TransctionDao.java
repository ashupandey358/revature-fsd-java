package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.banknew.form.AccountDetails;
import com.revature.banknew.form.CustomerForm;
import com.revature.banknew.transction.Transction;


public interface TransctionDao {
	public AccountDetails currentAmount(String accountNo) throws SQLException;
	public void transctionCreate(Transction transction) throws SQLException;
	public void forWithdrawal(long updatedbalance,String accountno) throws SQLException;
	public void forDeposite(long updatedbalance1,String accountno2) throws SQLException;
    public List<Transction> viewTransctionforSpecificAccount(String accountNo) throws SQLException ;
}
