package com.revature;

import java.util.Scanner;

import com.revature.dao.DeptDao;
import com.revature.dao.DeptDaoKryo;
import com.revature.dao.TeacherDao;
import com.revature.dao.TeacherDaokryo;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.dao.UserDaoKryo;
import com.revature.service.DeptService;
import com.revature.service.DeptServiceImpl;
import com.revature.service.TeacherService;
import com.revature.service.TeacherServiceImp;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;
import com.revature.ui.AddDeptMenu;
import com.revature.ui.LoginMenu;
import com.revature.ui.MainMenu;
import com.revature.ui.RegistrationMenu;
import com.revature.ui.TeacherRegiMenu;
import com.revature.ui.WelcomeMenu;

public class RefactoredDriver {
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		UserDao userDao = new UserDaoKryo();
		
		UserService userService = new UserServiceImpl(userDao);
		
		//for Department
		DeptDao deptDao = new DeptDaoKryo();
		
		DeptService deptService = new DeptServiceImpl(deptDao);
		
		//for teacher
		TeacherDao teacherDao = new TeacherDaokryo();
		
		TeacherService teacherService = new TeacherServiceImp(teacherDao);
		
		MainMenu register = new RegistrationMenu();

		//for add department
		AddDeptMenu addDept =new AddDeptMenu();
		
		MainMenu regiTeacher =new TeacherRegiMenu();
		
		
		
		MainMenu login = new LoginMenu(userService, addDept);
		
		MainMenu welcomeMenu = new WelcomeMenu(login, register,addDept,regiTeacher);
		
		
		
		((RegistrationMenu)register).setWelcomeMenu(welcomeMenu);
		
		((RegistrationMenu)register).setAuthService(userService);
		((AddDeptMenu)addDept).setDeptService(deptService);
		addDept.setScanner(scan);
		((TeacherRegiMenu)regiTeacher).setTeacherService(teacherService);
		
		
		
		login.setScanner(scan);
		
		register.setScanner(scan);
		addDept.setScanner(scan);
		
		welcomeMenu.setScanner(scan);
		
		MainMenu nextMenu = welcomeMenu;
		
		do {
			nextMenu.displayOptions();
			
			nextMenu = nextMenu.advance();
			
		} while (nextMenu != null);
		

		
	}

}
