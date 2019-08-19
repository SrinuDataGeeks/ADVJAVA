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
	out.println("<h1> <center> ");
	
	out.println(" <a href='./show?username="+name+"'>GetName</a>");
	
	
	
	
	out.println("</center> </h1> ");
	out.close();
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
