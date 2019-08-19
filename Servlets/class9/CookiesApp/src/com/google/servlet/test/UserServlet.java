package com.google.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String name = request.getParameter("username");
	
	Cookie ck = new Cookie("nameCk", name);
	
	response.addCookie(ck);
	
	response.sendRedirect("./info.html");
	
	out.close();
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
