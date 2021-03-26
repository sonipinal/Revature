package com.banking.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.model.User;
import com.banking.repository.AccountTypeRepository;
import com.banking.repository.AccountTypeRepositoryImp;
//import com.banking.repository.AccountRepositoryImp;
import com.model.AccountType;

//import com.banking.repository.AccountStatusRepositoryImpl;
//import com.banking.repository.AccountRepositoryImp;

/*
 * This layer of the application is dedicated to business logic!
 */
public class AccountTypeService {

	private AccountTypeRepository accounttypeRepository;
	
	public AccountTypeService() {
		this.accounttypeRepository = new AccountTypeRepositoryImp();
	}
	
	public List<AccountType> findAll(){
		return this.accounttypeRepository.findAll();
	}
	
	public AccountType findById(int id) {
		return this.accounttypeRepository.findById(id);
	}
	
	
	
	

	

	
	
}

