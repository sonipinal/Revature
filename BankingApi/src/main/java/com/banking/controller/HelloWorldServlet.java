package com.banking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Role;
import com.model.User;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloWorldServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setStatus(200);
		// Sending Html to my Client
		// response.setContentType("text/Html");
		// response.getWriter().write("<h1>WelCome to My Bank</h1>");
		// response.getWriter().write("Hello from the server Side");

		// Sending Json to the Client

		/*
		 * ObjectMapper imTheMap = new ObjectMapper(); final String JSON =
		 * imTheMap.writeValueAsString(new Student(1, "Deku", 2342.44f, 1));
		 * response.setContentType("application/json");
		 * response.getWriter().write(JSON);
		 */

		/*
		 * ObjectMapper imTheMap = new ObjectMapper();
		 * 
		 * Role r1 = new Role(3,"Employee"); //final String JSON =
		 * imTheMap.writeValueAsString(new
		 * User("fake123","fake1234","fake","fakelast","fake@fake.com",r1)); final
		 * String JSON = imTheMap.writeValueAsString(new
		 * User({username:username,password:password,firstname:firstname,lastname:
		 * lastname,eamil:emiil,role: })); response.setContentType("application/json");
		 * response.getWriter().write(JSON);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final String firstname = request.getParameter("firstname");
		final String lastname = request.getParameter("lastname");
		final String email = request.getParameter("email");
		final String role = request.getParameter("role");
		/*
		 * response.getWriter().write(username); response.getWriter().write(password);
		 * response.getWriter().write(firstname); response.getWriter().write(lastname);
		 * response.getWriter().write(email); response.getWriter().write(role);
		 */
		response.getWriter()
				.write(username + " " + password + " " + firstname + " " + lastname + " " + email + " " + role);
		// doGet(request, response);
	}

}
