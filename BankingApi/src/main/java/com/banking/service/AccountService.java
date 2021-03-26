package com.banking.service;

import java.util.List;

import com.model.Account;
import com.banking.repository.AccountRepository;
import com.banking.repository.AccountRepositoryImp;

/*
 * This layer of the application is dedicated to business logic!
 */
public class AccountService {

	private AccountRepository accountRepository;
	
	public AccountService() {
		this.accountRepository = new AccountRepositoryImp();
	}
	
	public List<Account> findAll(){
		return this.accountRepository.findAll();
	}
	public Account findByStatus(int statusid) {
		return this.accountRepository.findByStatus(statusid);
	}
	public Account findById(int id) {
		return this.accountRepository.findById(id);
	}
	
	public void deposit(int id, double amount) {
		 this.accountRepository.deposit(id, amount);
	}
	
	public void updateAccoun(int id, double amount) {
		 this.accountRepository.updateAccount(id, amount);
	}
	public void withdrawal(int aid, double wamount) {
		 this.accountRepository.withdrawal(aid, wamount);
	}
	public void insertAccount(Account account)
	{
		this.accountRepository.insertAccount(account);
	}
	public void transfer (int fromaccId, int toaccId, double amount)
	{
		this.accountRepository.transfer(fromaccId,toaccId,amount);
	}
	public void DeleteAccount(Account account)
	{
		this.accountRepository.DeleteAccount(account);
	}
}
	
