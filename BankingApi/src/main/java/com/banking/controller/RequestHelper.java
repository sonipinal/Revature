package com.banking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.banking.service.AccountStatusService;
import com.banking.service.AccountTypeService;
import com.banking.service.AccountService;
import com.banking.service.RoleService;
import com.banking.service.UserService;
import com.model.Account;
import com.model.AccountStatus;
import com.model.AccountType;
import com.model.Role;
import com.model.User;

/*
 * This class is a helper class for our Front Controller. Our Front Controller will
 * delegate to this request helper. I've chosen to use this request helper because
 * I would like to move some of the logic needed for processing requests here as it
 * is not needed within our Front Controller.
 */
public class RequestHelper {

	// So we define helper methods here such as...

	// A helper method which helps me process GET requests. When I say
	// "process" GET requests, I mean that I would like to find out which resource
	// is being requested as our Front Controller uses a wildcard symbol; this
	// requires
	// that we parse the request URL to find out which resource was requested.

	// private static User user;

	public static Object processGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		/*
		 * Remember: We need to parse the request URL. Fortunately, we can use the
		 * request object to access the URL.
		 */
		
		System.out.println(request.getRequestURI());

		/*
		 * We are isolating the final piece of the URI to determine the exact resource
		 * which has been requested by the client.
		 */
		
		final String URI = request.getRequestURI();
		String resource = URI.replace("/BankingApi/myapi", "");
		System.out.println("URL" + resource);

		switch (resource) {
		
			
		
		case "/users":
			if(request.getSession(false) != null) {
			User user = null;
			UserService userservice = new UserService();
			user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
			
			if((user.getRole().getRole().equals("Admin")) ||(user.getRole().getRole().equals("Employee")))  {
			return new UserService().findAll();
			
			}
			else {
				response.getWriter().write("You are not Allowed");
			}
			}
			else 
			{
			 response.getWriter().write("You are not Authenticated....");
			
			}
			/*extra*/
		case "/role/findById":
			final String rolebyid = request.getParameter("rolebyid");
			int roleid = Integer.parseInt(rolebyid);
			return new RoleService().findById(roleid);
			
			

		case "/user/findById":
			if(request.getSession(false) != null) {
				User user = null;
				UserService userservice = new UserService();
				user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
				int uid = Integer.parseInt(request.getParameter("userbyid"));
				if((user.getRole().getRole().equals("Admin")) ||(user.getRole().getRole().equals("Employee"))||(user.getUserId() == uid)) {
			final String userbyid = request.getParameter("userbyid");
			int userid = Integer.parseInt(userbyid);
			return new UserService().findById(userid);
				}
				else {
					response.getWriter().write("You are not Allowed");
				}
				}
				else 
				{
				 response.getWriter().write("You are not Authenticated....");
				
				}
			
			
		case "/user/findByUserName":
			if(request.getSession(false) != null) {
				User user = null;
				UserService userservice = new UserService();
				user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
				
				if((user.getRole().getRole().equals("Admin")))  {
				final String name = request.getParameter("username");
				return new UserService().findByUserName(name);
				}
				else {
					response.getWriter().write("You are not Allowed");
				}
				}
				else 
				{
				 response.getWriter().write("You are not Authenticated....");
				
				}
			
		case "/AccountStatus/findById":
			final String statusbyid = request.getParameter("statusbyid");
			int statusid = Integer.parseInt(statusbyid);
			return new AccountStatusService().findById(statusid);
			
		case "/AccountStatus/all":
			return new AccountStatusService().findAll();
		 
		case "/accounts":
			if(request.getSession(false) != null) {
				User user = null;
				UserService userservice = new UserService();
				user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
				
				if((user.getRole().getRole().equals("Admin")) ||(user.getRole().getRole().equals("Employee")))  {
					return new AccountService().findAll();
				}
				else {
					response.getWriter().write("You are not Allowed");
				}
				}
				else 
				{
				 response.getWriter().write("You are not Authenticated....");
				
				}
		
		case "/role/all":
			if(request.getSession(false) != null) {
				User user = null;
				UserService userservice = new UserService();
				user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
				
				if((user.getRole().getRole().equals("Admin")))  {
			return new RoleService().findAll();
				}
				else {
					response.getWriter().write("You are not Allowed");
				}
				}
				else 
				{
				 response.getWriter().write("You are not Authenticated....");
				
				}

		case "/account/findById":
			if(request.getSession(false) != null) {
				User user = null;
				UserService userservice = new UserService();
				user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
				
				if((user.getRole().getRole().equals("Admin")) ||(user.getRole().getRole().equals("Employee")))  {
			final String accountbyid = request.getParameter("accountbyid");
			int accountid = Integer.parseInt(accountbyid);
			return new AccountService().findById(accountid);
				}
				else {
					response.getWriter().write("You are not Allowed");
				}
				}
				else 
				{
				 response.getWriter().write("You are not Authenticated....");
				
				}
		

		case "/account/findByUserId":
			if(request.getSession(false) != null) {
				User user;
				UserService userservice = new UserService();
				user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
				
				if((user.getRole().getRole().equals("Admin")) ||(user.getRole().getRole().equals("Employee")))  {
			
			final String accountbyuserid = request.getParameter("accountbyuserid");
			int userId = Integer.parseInt(accountbyuserid);
			return new AccountService().findById(userId);
				}
				else {
					response.getWriter().write("You are not Allowed");
				}
				}
				else 
				{
				 response.getWriter().write("You are not Authenticated....");
				
				}
			
			
		case "/account/findByStatus":
			if(request.getSession(false) != null) {
				User user;
				UserService userservice = new UserService();
				user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
				
				if((user.getRole().getRole().equals("Admin")) ||(user.getRole().getRole().equals("Employee")))  {
			
			final String status = request.getParameter("status");
			int stId = Integer.parseInt(status);
			return new AccountService().findByStatus(stId);
				}
				else {
					response.getWriter().write("You are not Allowed");
				}
				}
				else 
				{
				 response.getWriter().write("You are not Authenticated....");
				
				}
		

	
			
		case "/user/FindByUserName":
			if(request.getSession(false) != null) {
				User user;
				UserService userservice = new UserService();
				user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
				
				if((user.getRole().getRole().equals("Admin")) ||(user.getRole().getRole().equals("Employee")))  {
			final String name1 = request.getParameter("username");
			return new UserService().findByUserName(name1);
				}
				else {
					response.getWriter().write("You are not Allowed");
				}
				}
				else 
				{
				 response.getWriter().write("You are not Authenticated....");
				
				}
		
		
		
		 
		
			/*case "/account/DeleteAccount":
				//Account account;
				final String aid = request.getParameter("accountId");
			 Integer aaid = Integer.parseInt(aid);
			 Account account = new Account();
			 
			 new AccountService().DeleteAccount(account);
				 
				 return "Account Deleted";*/
				
			
		default:
			return "No such resource exists on this api";
		}
		
	}
	}
