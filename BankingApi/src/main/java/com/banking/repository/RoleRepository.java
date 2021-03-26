package com.banking.repository;
import java.sql.SQLException;
import java.util.List;

import com.model.Role;

public interface RoleRepository {
	
	
	List<Role> findAll();
	Role findById(int id);
	/*Student findByName(String name);*/
	//long insert(User user);
	//boolean delete(User user) throws SQLException ;
	//void update(User user);
	//void insert(String string, String string2, String string3, String string4, String string5, String string6);
	//void deleteById(int id);
	//User deleteById(int id);
}