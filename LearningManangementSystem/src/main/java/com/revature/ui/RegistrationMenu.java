package com.revature.ui;

import java.util.Scanner;

import com.revature.exception.UserNameTaken;
import com.revature.pojo.User;
import com.revature.service.UserService;

public class RegistrationMenu implements MainMenu {
	
	private MainMenu welcomeMenu;

	private MainMenu nextMenu;
	
	private Scanner scan;

	private UserService userService;

	@Override
	public MainMenu advance() {
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		User user = new User();
		System.out.println("Please enter a new username:");
		user.setUsername(scan.nextLine());
		System.out.println("Please enter a new password:");
		user.setPassword(scan.nextLine());
		if (!userService.existingUser(user)) {
			try {
				userService.registerUser(user);
				nextMenu = null;
			} catch (UserNameTaken e) {
				System.out.println("Username taken, please try again");
				nextMenu = welcomeMenu;
			}
		} else {
			System.out.println("Username taken, please try again");
			nextMenu = welcomeMenu;
		}
	}

	@Override
	public MainMenu previousMenu() {
		return null;
	}

	@Override
	public Scanner getScanner() {
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	public RegistrationMenu() {
		super();
	}

	public RegistrationMenu(UserService userService, MainMenu welcomeMenu) {
		super();
		this.userService = userService;
		this.welcomeMenu = welcomeMenu;
	}

	public MainMenu getWelcomeMenu() {
		return welcomeMenu;
	}

	public void setWelcomeMenu(MainMenu welcomeMenu) {
		this.welcomeMenu = welcomeMenu;
	}

	public MainMenu getNextMenu() {
		return nextMenu;
	}

	public UserService getAuthService() {
		return userService;
	}

	public void setAuthService(UserService userService) {
		this.userService = userService;
	}

}