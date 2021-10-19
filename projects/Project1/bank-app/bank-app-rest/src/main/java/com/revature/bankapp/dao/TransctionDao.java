package com.revature.bankapp.dao;


import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.banknew.model.Transction;

public interface TransctionDao {
	public int currentAmount(String accountNo) throws AppException;

	public void transctionCreate(String accountNo,String type,int money) throws AppException;

	public void forWithdrawal(int updatedbalance, String accountno) throws AppException;
	public void forDeposite(int updatedbalance1, String accountno2) throws AppException;
	public List<Transction> viewTransctionforSpecificAccount(String accountNo) throws AppException;
}
