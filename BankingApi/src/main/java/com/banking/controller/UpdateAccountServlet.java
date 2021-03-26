package com.banking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.service.AccountService;
import com.banking.service.UserService;
import com.model.Role;
import com.model.User;

/**
 * Servlet implementation class UpdateAccountServlet
 */
@WebServlet("/UpdateAccountServlet")
public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccountServlet() {
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
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				if(request.getSession(false) != null) {
					User user = null;
					UserService userservice = new UserService();
					user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
					
					//int uid = Integer.parseInt(request.getParameter("userId"));
					
					if(user.getRole().getRole().equals("Admin")) {
				final String id = request.getParameter("AccountId"); 
				final String amount = request.getParameter("balance");
				int userId1 = Integer.parseInt(id);
				double bal = Double.parseDouble(amount);
				new AccountService().updateAccoun(userId1, bal);
				response.getWriter().write("Balance is upadated of Account Id"+"   " +userId1);
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
