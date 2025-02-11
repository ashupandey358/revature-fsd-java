package com.revature.banknew.model;

public class Account {
	private String accountNo;
	private String aadharNumber;
	private String mobileNumber;
	private long balance;
	private String accountType;

	public Account() {
		super();
	}

	public Account(String accountNo, String aadharNumber, String mobileNumber, long balance,
			String accountType) {
		super();
		this.accountNo = accountNo;
		this.aadharNumber = aadharNumber;
		this.mobileNumber = mobileNumber;
		this.balance = balance;
		this.accountType = accountType;
	
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	
	public Account(long balance, String accountType) {
		super();
		this.balance = balance;
		this.accountType = accountType;
	}
	

	

	public Account(long balance) {
		super();
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", aadharNumber=" + aadharNumber + ", mobileNumber=" + mobileNumber
				+ ", balance=" + balance + ", accountType=" + accountType + "]";
	}

	



	
	
}
