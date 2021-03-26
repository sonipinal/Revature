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
 * Servlet implementation class withdrawServlet
 */
@WebServlet("/withdrawServlet")
public class withdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public withdrawServlet() {
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
		//doGet(request, response);
		if(request.getSession(false) != null) {
			User user = null;
			UserService userservice = new UserService();
			user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
			
			if(user.getRole().getRole().equals("Admin")) {


		
		final String accid = request.getParameter("Accountbyid"); 
		final String wiamount = request.getParameter("withdrawal");
		int acctId = Integer.parseInt(accid);
		double withdrawalAmt = Double.parseDouble(wiamount);
		new AccountService().withdrawal(acctId,withdrawalAmt);
		response.getWriter().write(withdrawalAmt +" has been withdrawn from Account" +acctId);
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
