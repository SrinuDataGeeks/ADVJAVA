package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		
		out.println("<center><h1>  ");
		
				if(session.getAttribute("username") != null)
				{
			    out.println(" Welcome :: "+session.getAttribute("username"));
			    ServletContext context = getServletContext();
			    out.println(" Active Users Count :: "+context.getAttribute("userCount"));
			     
			    out.println("<a href='./logout'> LogOut </a>");
				}
			
				else
				{
			out.println("Please login First </h1> </center>");
			request.getRequestDispatcher("/login.html").include(request, response);
				}
		
			
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
