
package com.banking.repository;
import java.sql.SQLException;
import java.util.List;

import com.model.Account;

public interface AccountRepository {

	
	
	List<Account> findAll();
	Account findByUserId(int userId);
	Account findByStatus(int statusid);
	Account findById(int account_id);
	//Account deposit(int account_id, double deposit);
	//Account findByUserId(int accountbyuserid);
	//Account all();
	void insertAccount(Account account);
	//boolean delete(User user) throws SQLException ;
	//void update(User user);
	//void insert(String string, String string2, String string3, String string4, String string5, String string6);
	//void deleteById(int id);
	//User deleteById(int id);
	void updateAccount(int id, double amount);
	void deposit(int id, double amount);
	void withdrawal(int aid, double wamount);
	void transfer (int fromaccId, int toaccId, double amount);
	void DeleteAccount(Account account);
	
}