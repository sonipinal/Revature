package com.banking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.service.UserService;
import com.model.Role;
import com.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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

		final String username = request.getParameter("username");
		 final String password = request.getParameter("password");
		 final String firstname = request.getParameter("firstname");
		 final String lastname =  request.getParameter("lastname");
		 final String email = request.getParameter("email");
		  final String role = request.getParameter("role");
			int role1 = Integer.parseInt(role);
			UserService userservice1 = new UserService();
			
				Role urole = new Role(role1,"");
				User user1 = new User(username,password,firstname,lastname,email,urole);
				/*if(userservice.CheckUserAndPassword("username", "password"))
				{*/
				 userservice1.insert(user1);
					response.getWriter()
					.write(username + " " + password + " " + firstname + " " + lastname + " " + email + " " + role);
			
		response.getWriter().write("user register successfully");
				/* }
				else
				 {
					 response.getWriter().write("InValid Fields ......");
					 response.setStatus(400);
				 }*/
			
		
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
