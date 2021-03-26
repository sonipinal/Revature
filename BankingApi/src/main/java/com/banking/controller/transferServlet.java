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
 * Servlet implementation class transferServlet
 */
@WebServlet("/transferServlet")
public class transferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transferServlet() {
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
		
	/*	if(request.getSession(false) != null) {
			User user = null;
			UserService userservice = new UserService();
			user= userservice.findByUserName((String) request.getSession().getAttribute("usr"));
			
			if(user.getRole().getRole().equals("Admin")) {*/

		
		final String toid = request.getParameter("to"); 
		final String foid = request.getParameter("from"); 
		final String amount1 = request.getParameter("transferAmount");
		int accounttoId = Integer.parseInt(toid);
		int accountfoId = Integer.parseInt(foid);
		double tAmt =	 Double.parseDouble(amount1);
		new AccountService().transfer(accounttoId,accountfoId,tAmt);
		response.getWriter().write(tAmt + "has been transferred from Account " +accountfoId + " to Account"+ accounttoId);
			/*}
			else {
				response.getWriter().write("You are not Allowed");
			}
			}
			else 
			{
			 response.getWriter().write("You are not Authenticated....");
			
			}*/
		//doGet(request, response);
	}

}
