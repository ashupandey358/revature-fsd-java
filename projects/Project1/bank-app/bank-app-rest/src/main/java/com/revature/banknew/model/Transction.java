package com.revature.banknew.model;

public class Transction {

	private String transctionType;
	private int amount;
	private String accountNumber;

	public Transction() {
		super();
	}

	public Transction(String transctionType, int amount, String accountNumber) {
		super();
		this.transctionType = transctionType;
		this.amount = amount;
		this.accountNumber = accountNumber;
	}

	public String getTransctionType() {
		return transctionType;
	}

	public void setTransctionType(String transctionType) {
		this.transctionType = transctionType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Transction [transctionType=" + transctionType + ", amount=" + amount + "]";
	}

	
	
	
}