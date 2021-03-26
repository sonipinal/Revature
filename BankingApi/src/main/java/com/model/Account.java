package com.model;
//import com.model.User;


public class Account {
	private int accountId; // primary key
	  private double balance;  // not null
	  private AccountStatus status;
	  private AccountType type;
	  
	  //private Role role;
	  
	 /* public Account(User userId,int accountId,double balance,AccountStatus status,AccountType type,User username,User password,User firstName,User email,User Role) {
		  super();
		  this.userId = userId;
		  this.accountId = accountId;
			this.balance = balance;
			this.status = status;
			this.type = type;
		  
	  }*/
	public Account(int accountId, double balance, AccountStatus status, AccountType type)  {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
		this.type = type;
	}
	public Account( double balance, AccountStatus status, AccountType type)  {
		super();
		//this.accountId = accountId;
		this.balance = balance;
		this.status = status;
		this.type = type;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}


}
