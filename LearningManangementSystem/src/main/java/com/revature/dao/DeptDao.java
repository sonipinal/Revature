package com.revature.dao;

import java.util.List;

//import com.revature.exception.UserNameTaken;
//import com.revature.exception.UserNotFound;
import com.revature.pojo.Dept;



public interface DeptDao {
public void createDept(Dept dept);
	
	//public User getDeptById(int id) throws UserNotFound;
	
	public List<Dept> getAlldepts();
	
	public void updateDept(Dept dept);
	


}
