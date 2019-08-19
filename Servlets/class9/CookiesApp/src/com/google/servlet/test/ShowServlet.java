package com.google.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	Cookie[] cookies  = request.getCookies();
	
	for(Cookie ck : cookies)
	{
		out.println("<h1>"+ck.getName()+" : "+ck.getValue()+"</h1>");
	}
	
	out.close();
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
