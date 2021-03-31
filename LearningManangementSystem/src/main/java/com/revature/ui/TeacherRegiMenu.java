package com.revature.ui;

import java.util.Scanner;

import com.revature.exception.UserNameTaken;
import com.revature.pojo.Teacher;
import com.revature.pojo.User;
import com.revature.service.TeacherService;
import com.revature.service.UserService;

public class TeacherRegiMenu implements MainMenu {
	private MainMenu welcomeMenu;

	private MainMenu nextMenu;

	private Scanner scan;

	private TeacherService teacherService;

	@Override
	public MainMenu advance() {
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		
		Teacher teacher = new Teacher();
		System.out.println("Please enter a Teacher Id:");
		teacher.setTeacherID(scan.nextInt());
		System.out.println("Please enter a Teacher Name:");
		teacher.setTeacherName(scan.nextLine());
		System.out.println("Please enter a Email:");
		teacher.setTeacherName(scan.nextLine());
		System.out.println("Please enter a Address:");
		teacher.setAddress(scan.nextLine());
		System.out.println("Please enter a Department:");
		teacher.setDeptName(scan.nextLine());
		System.out.println("Please enter a course:");
		teacher.setCname(scan.nextLine());
		
				teacherService.registerTeacher(teacher);
				nextMenu = null;
		
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

	public TeacherRegiMenu() {
		super();
		}

	public TeacherRegiMenu(TeacherService teacherService, MainMenu welcomeMenu) {
		super();
		this.teacherService = teacherService;
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

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}


}
