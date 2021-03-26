package com.banking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.service.UserService;
import com.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		//final String nm= request.getParameter("fname");
		
		UserService userServ = new UserService();
		User userName = userServ.findByUserName(username);		
		if (userName != null) {
			if (userName.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("usr", userName.getUsername());
				//session.setAttribute("roleId", userName.getRole().getRoleId());
				session.setAttribute("userId", userName.getUserId());
				session.setAttribute("uname",userName.getFirstName());
				//userName.getUsername();
				//userName.getPassword();
				response.getWriter().write("Welcome back, " + userName.getFirstName() + "!");
			} else {
				response.sendError(400, "Invalid Credentials");
			}
		} else {
			response.sendError(400, "Invalid Credentials");
		}
	}

}
