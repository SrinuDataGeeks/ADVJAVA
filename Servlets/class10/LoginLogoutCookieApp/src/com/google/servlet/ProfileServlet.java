package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie[] ckArr = request.getCookies();
		
		out.println("<center> <h1>");
		if(ckArr != null && ckArr.length > 0)
		{
		for(Cookie ck : ckArr)
			{
				String ckName = ck.getName();
				if(ckName.equalsIgnoreCase("nameCk"))
				{
			    out.println(" Welcome :: "+ck.getValue());
			    out.println("<a href='./logout'> LogOut </a>");
				}
			
			}
		}else
		{
			out.println("Please login First </h1> </center>");
			request.getRequestDispatcher("/login.html").include(request, response);
		}
		
			
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
