package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResultServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
		HttpSession session = request.getSession();
		
		out.println("<h1> <center>");
		out.println("<br> UserName : "+session.getAttribute("username"));
		out.println("<br> Gender : "+session.getAttribute("gender"));
		String[] qlyArr = (String[]) session.getAttribute("qly");
		if( qlyArr != null)
		{
			out.println("<br> Qualification : ");
			for(String qly : qlyArr)
			{
				out.println("<br> "+qly);
			}
			
		}
		
		out.println("<br> Country : "+session.getAttribute("country"));
		
		out.println("<br> Experience : "+session.getAttribute("exp"));
		
		out.println("</center> </h1> ");
		
				
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			this.doGet(request, response);
	}
}
