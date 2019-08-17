package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidationServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String value = request.getParameter("age");
			Integer age = null;
			
			if(value != null && value.trim().length() > 0 )
			         age = Integer.valueOf(value);
			
			String name = request.getParameter("name");
			
			if( age == null || name == null || name.trim().length() == 0)
			{
				out.println("<h1> <center> Age Or Name is Required </center></h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/home.html");
				rd.include(request, response);

			}else
			{
				request.setAttribute("name", name);
				if(age >= 18)
				{
					request.setAttribute("result", "Eligible For Vote");
				}else
				{
					request.setAttribute("result", "Not Eligible For Vote");
				}
				RequestDispatcher rd = request.getRequestDispatcher("/vote");
				rd.forward(request, response);
			}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			this.doGet(request, response);
	}
}
