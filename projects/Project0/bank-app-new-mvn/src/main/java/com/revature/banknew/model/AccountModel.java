package com.revature.banknew.model;

public class AccountModel {
	private String accountNo;
	private String aadharNumber;
	private String mobileNumber;
	private long balance;
	private String accountType;
	private String accountStatus;
	private int customerId;

	public AccountModel() {
		super();
	}

	public AccountModel(String accountNo, String aadharNumber, String mobileNumber, long balance,
			String accountType, String accountStatus, int customerId) {
		super();
		this.accountNo = accountNo;
		this.aadharNumber = aadharNumber;
		this.mobileNumber = mobileNumber;
		this.balance = balance;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.customerId = customerId;
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

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public AccountModel(long balance, String accountType) {
		super();
		this.balance = balance;
		this.accountType = accountType;
	}
	

	

	public AccountModel(long balance) {
		super();
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountModel [accountNo=" + accountNo + ", balance=" + balance + ", accountType=" + accountType + "]";
	}



	
	
}
