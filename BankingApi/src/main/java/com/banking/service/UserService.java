package com.banking.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.banking.repository.UserRepository;
import com.banking.repository.UserRepositoryImpl;

/*
 * This layer of the application is dedicated to business logic!
 */
public class UserService {

	private UserRepository userRepository;
	
	public UserService() {
		this.userRepository = new UserRepositoryImpl();
	}
	
	public List<User> findAll(){
		return this.userRepository.findAll();
	}
	
	public User findById(int id) {
		return this.userRepository.findById(id);
	}
	
	public void update(int id, String email)
	{
	 this.userRepository.update(id, email);
	}
	
	public void insert(User user) {
		this.userRepository.insert(user);
	
	}
	
	/*public boolean delete(int i) {
		//User id;
		//return this.userRepository.delete();
		
		return true;
	}*/

	public User findByUserName(String name) {
		return this.userRepository.findByUserName(name);
	}
	public User findByPassword(String password) {
		return this.userRepository.findByPassword(password);
	}
	public boolean  CheckUserAndPassword(String username,String password) {
		return this.userRepository.CheckUserAndPassword(username, password);
	}
	
	
	
	

	
	
}

