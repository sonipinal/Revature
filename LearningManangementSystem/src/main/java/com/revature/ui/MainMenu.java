package com.revature.ui;

import java.util.Scanner;

public interface MainMenu {
	
	public MainMenu advance();
	
	public void displayOptions();
	
	//public void displayDept();
	
	public MainMenu previousMenu();
	
	public Scanner getScanner();
	
	public void setScanner(Scanner scan);

}
