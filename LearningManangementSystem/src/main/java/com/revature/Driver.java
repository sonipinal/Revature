package com.revature;

import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Driver {
	private static String uname;
	private static String password;
	
	public static void main(String[] args)
	{	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the Username:");
		
		uname =(scan.nextLine());
		
		System.out.println("Enter the Password:");
		password =(scan.nextLine());
		
		//validate user
		
	
		Hashtable<String,String> userList = new Hashtable<>();
		
		userList.put("pinal", "soni123");
		
		
		String checkPassword = userList.get(uname);
		//checking the password
		
		/*if we have no key value in map then it throws the error of 
		 * Null point Exception(enetr the password that are not Exists) so for now we check the condition if Checkpassword 
		 * is not null
		 */
		

		if (checkPassword != null) {

			if (checkPassword.equals(password) == true) {
				System.out.println("Welcome to the Learning Management system " + uname);
				
			} else {
				System.out.println("user is not authenticated");
			}
		} else {
			System.out.println("user not found");
		}
		
	}
	
	

}
