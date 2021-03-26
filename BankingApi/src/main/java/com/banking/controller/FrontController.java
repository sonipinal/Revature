package com.banking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


/*
 * This class follows a front controller design pattern. Our front controller
 * is responsible for intercepting all HTTP requests. This means that all requests
 * come through our Front Controller, which allows us to define a single point
 * of validation. Note that the alternative to using a front controller is
 * creating various servlets to handle requests for different resources; this
 * alternative does not scale as well as the front controller.
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * I first check the HTTP verb.
		 */
		if(request.getMethod().equals("GET")|| request.getMethod().equals("POST")) {
			/*
			 * Remember that we want to write our values as JSON...meaning we want
			 * an ObjectMapper.
			 */
			
			String json = new ObjectMapper()
					.writeValueAsString(RequestHelper.processGet(request, response));
			
			response.getWriter().write(json);
		}
		else {
			response.getWriter().write("You're not authenticated.");
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		
	}

}