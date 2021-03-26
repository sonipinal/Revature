package com.banking.repository;
import java.sql.SQLException;
import java.util.List;

import com.model.User;

public interface UserRepository {
	
	
	List<User> findAll();
	User findById(int id);
	/*Student findByName(String name);*/
	
	boolean delete(User user) throws SQLException ;
	void update(int id, String email);
	void insert(User user);
	//void deleteById(int id);
	//User deleteById(int id);
	 boolean  CheckUserAndPassword(String username,String password);
	User findByUserName(String name);
	User findByPassword(String password);
}
