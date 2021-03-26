package com.bankingDriver;

import com.banking.service.UserService;
import com.model.Role;
import com.model.User;
import com.banking.service.AccountService;
//import com.model.Role;

public class Driver {

	public static void main(String[] args) {
		Role r1 = new Role(3,"Employee");
		UserService userService = new UserService();
		
		System.out.println(userService.findAll());
		User user = new User("Radhika12" ,"shree","radhika","soni","radhi@yhahoo.com",r1);
		System.out.println(userService.insert(user));
		//System.out.println(userService.insert(user));
		System.out.println(userService.findById(1));
		//System.out.println(userService.update("pinalsoni","soni123","Pinal","Soni","sonipinal14@gmail.com",1));
		//System.out.println(userService.delete(3));
		//System.out.println(AccountService.deposit(2,1000));
		//void withdrawal(int id, double amount);
	}
}
