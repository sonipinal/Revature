package com.banking.service;
import com.model.Role;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.model.User;
import com.banking.repository.RoleRepository;
import com.banking.repository.RoleRepositoryImpl;

/*
 * This layer of the application is dedicated to business logic!
 */
public class RoleService {

	private RoleRepository roleRepository;
	
	public RoleService() {
		this.roleRepository = new RoleRepositoryImpl();
	}
	
	public List<Role> findAll(){
		return this.roleRepository.findAll();
	}
	
	public Role findById(int id) {
		return this.roleRepository.findById(id);
	}

	
	
	
	

	

	
	
}

