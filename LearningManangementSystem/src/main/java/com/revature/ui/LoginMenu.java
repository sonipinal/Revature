package com.revature.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.revature.exception.InvalidPassword;
import com.revature.exception.UserNotFound;
import com.revature.pojo.User;
import com.revature.service.UserService;

public class LoginMenu implements MainMenu {

	private UserService userservice;
	private  AddDeptMenu deptmenu;
	
	private MainMenu nextMenu;
	
	public LoginMenu(UserService authService, AddDeptMenu deptmenu) {
		super();
		this.deptmenu = deptmenu;
		this.userservice = authService;
	}

	private Scanner scan;

	public Scanner getScanner() {
		return scan;
	}

	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	public UserService getUserService() {
		return userservice;
	}

	public void setUserService(UserService userService) {
		this.userservice = userService;
	}

	@Override
	public MainMenu advance() {
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		System.out.println("Please Enter Username:");
		String username = scan.nextLine();
		System.out.println("Please Enter Password:");
		String password = scan.nextLine();
		
		User user = new User(username, password);
		
		try {
			userservice.authenticateUser(user);
			System.out.println("Login successful...");
			
			System.out.println("Would you like to add Department yes or no?");
			String answer1 = scan.nextLine();
			
			if ("yes".equals(answer1)) {
				nextMenu = deptmenu;
			}
			//throw new Error();
		} catch (UserNotFound e) {
			System.out.println("Username does not exist.  Please register an account.");
		} catch (InvalidPassword e) {
			System.out.println("Authentication error, check username/password");
		} catch (Exception e) {
			System.out.println("Sorry..., something went wrong. Please try again later.");
			e.printStackTrace();
		} finally {
			System.out.println("Login Process Ended....");
		}
		
		//throw new NullPointerException();
		
	}

	@Override
	public MainMenu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public LoginMenu() {
		super();
	}



}
