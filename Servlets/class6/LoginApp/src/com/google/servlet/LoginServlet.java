package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet  extends HttpServlet{
	
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			
			out.println("<h1> <center> Response From LoginServlet <br>");
				if(name.equalsIgnoreCase(password))
				{
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/welcome");
					requestDispatcher.forward(request, response);
				}else
				{
					out.println(" Invalid UserName or Password ");
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
					requestDispatcher.include(request, response);
				}
			
			out.println("</center></h1>");
			
		}

			@Override
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
					this.doGet(request, response);
			}
}
