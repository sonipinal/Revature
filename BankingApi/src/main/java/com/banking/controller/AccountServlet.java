package com.banking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.service.AccountService;
import com.banking.service.UserService;
import com.model.Account;
import com.model.AccountStatus;
import com.model.AccountType;
import com.model.User;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getSession(false) != null) {
			User user = null;
			UserService userservice = new UserService();
			user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
			
			if((user.getRole().getRole().equals("Admin")) ||(user.getRole().getRole().equals("Employee"))) {
		
		
		
		final String balance = request.getParameter("balance");
		 Double pbal = Double.parseDouble(balance);
		 
		  final String astatus = request.getParameter("status");
			int status1 = Integer.parseInt(astatus);
			AccountService aservice = new AccountService();				
				AccountStatus as = new AccountStatus(status1,"");
				
			final String atype = request.getParameter("type");
				int type1 = Integer.parseInt(atype);
				//AccountTypeService att = new AccountTypeService();				
					AccountType att1 = new AccountType(type1,"");
				
				Account acc = new Account(pbal,as,att1);
				aservice.insertAccount(acc);
			
			//response.getWriter()
					//.write("your balance is:"+ balance + " " + astatus + " " + type1 );
			
			response.getWriter().write("Account Submitted sucessfully...");
			}
			else {
				response.getWriter().write("You are not Allowed");
			}
			}
			else 
			{
			 response.getWriter().write("You are not Authenticated....");
			
			}
		doGet(request, response);
	}

}
