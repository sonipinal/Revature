package com.revature.ui;

import java.util.Scanner;

public class WelcomeMenu implements MainMenu {

	private Scanner scan;
	
	private MainMenu loginMenu;
	
	private MainMenu registractionMenu;
	
	private MainMenu nextMenu;
	
	private MainMenu addDeptMenu;
	
	private MainMenu TeacherRegiMenu;
	
	@Override
	public MainMenu advance() {
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		System.out.println("Welcome to our Learning Management System");
		System.out.println("*****************************************");
		System.out.println("Would you like to login or register ?");
		String answer = scan.nextLine();

		if ("login".equals(answer)) {
			nextMenu = loginMenu;
		
		}
		
		else if ("register".equals(answer)) {
			nextMenu = registractionMenu;
		} else {
			System.out.println("Sorry!invalid input");
			// redirect user to same welcome menu
			nextMenu = this;
		}
		
		

		
	}

	@Override
	public MainMenu previousMenu() {
		// TODO Auto-generated method stub
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

	public WelcomeMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WelcomeMenu(MainMenu loginMenu, MainMenu registractionMenu, MainMenu addDeptMenu, MainMenu regiTeacherMenu) {
		super();
		this.loginMenu = loginMenu;
		this.registractionMenu = registractionMenu;
		this.addDeptMenu = addDeptMenu;
		this.TeacherRegiMenu = regiTeacherMenu;
	}

}
