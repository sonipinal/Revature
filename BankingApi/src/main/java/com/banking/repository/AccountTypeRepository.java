package com.banking.repository;
import java.sql.SQLException;
import java.util.List;

import com.model.AccountType;

public interface AccountTypeRepository {
	
	
	List<AccountType> findAll();
	AccountType findById(int id);
	}
