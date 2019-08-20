package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		
		if( name == null || name.trim().length() == 0 ||  
				pass == null || pass.trim().length() == 0 )
		{
			out.println("<center> <h1> Invalid user id or password </h1> </center>");
			request.getRequestDispatcher("/login.html").include(request, response);
		}else
		{
			Cookie nameCk = new Cookie("nameCk", name);
			nameCk.setMaxAge(1*60*60);
			
			Cookie passCk = new Cookie("passCk", pass);
			passCk.setMaxAge(1*60*60);
			
			response.addCookie(nameCk);
			response.addCookie(passCk);
			
			response.sendRedirect("./profile");
		}
			
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
