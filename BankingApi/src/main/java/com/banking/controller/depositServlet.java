package com.banking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.service.AccountService;
import com.banking.service.UserService;
import com.model.User;


/**
 * Servlet implementation class depositServlet
 */
@WebServlet("/depositServlet")
public class depositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public depositServlet() {
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
			
			if(user.getRole().getRole().equals("Admin")) {
		
		
		final String id = request.getParameter("Accountbyid"); 
		final String amount = request.getParameter("deposit");
		int accountId = Integer.parseInt(id);
		double depositAmt =	 Double.parseDouble(amount);
		new AccountService().deposit(accountId,depositAmt);
		response.getWriter().write(depositAmt + " has been deposited to Account" + accountId);
		
		
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
