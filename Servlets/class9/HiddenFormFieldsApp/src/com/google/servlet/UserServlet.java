package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String name = request.getParameter("username");
	
	out.println("<form action='./show' method='post' >");
	
	out.println(" <input type='hidden' name='username' value='" + name + "'> ");
	
	
	out.println("<input type='submit' value='ShowName'>");
	
	out.println("</form>");
	out.println("</center> </h1> ");
	out.close();
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
