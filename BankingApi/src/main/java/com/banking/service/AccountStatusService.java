package com.banking.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.model.User;
import com.banking.repository.AccountStatusRepository;
import com.banking.repository.AccountStatusRepositoryImp;
import com.model.AccountStatus;

//import com.banking.repository.AccountStatusRepositoryImpl;
//import com.banking.repository.AccountRepositoryImp;

/*
 * This layer of the application is dedicated to business logic!
 */
public class AccountStatusService {

	private AccountStatusRepository accountstatusRepository;
	
	public AccountStatusService() {
		this.accountstatusRepository = new AccountStatusRepositoryImp();
	}
	
	public List<AccountStatus> findAll(){
		return this.accountstatusRepository.findAll();
	}
	
	public AccountStatus findById(int id) {
		return this.accountstatusRepository.findById(id);
	}
	
	
	
	

	

	
	
}

