package com.bankapp.Details;

public class NewAccount {
	private String addharNumber;
	private String MobileNumber;
	private String accountType;
	private String balance;
	private int cid;
	public NewAccount() {
		super();
	}
	public NewAccount(String addharNumber, String mobileNumber, String accountType, String balance,int cid) {
		super();
		this.addharNumber = addharNumber;
		MobileNumber = mobileNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.cid=cid;
	}
	public String getAddharNumber() {
		return addharNumber;
	}
	public void setAddharNumber(String addharNumber) {
		this.addharNumber = addharNumber;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "NewAccount [accountType=" + accountType + ", balance=" + balance + "]";
	}
	
	
		
}
