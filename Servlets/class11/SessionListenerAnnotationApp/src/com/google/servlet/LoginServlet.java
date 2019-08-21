package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
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
			HttpSession session = request.getSession();
			session.setAttribute("username", name);
			session.setAttribute("password", pass);
			
			response.sendRedirect("./profile");
		}
			
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
