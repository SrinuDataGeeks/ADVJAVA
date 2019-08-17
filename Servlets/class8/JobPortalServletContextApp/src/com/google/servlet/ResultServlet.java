package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
			
			ServletContext context = request.getServletContext();
		
		out.println("<h1> <center>");
		out.println("<br> UserName : "+context.getAttribute("username"));
		out.println("<br> Gender : "+context.getAttribute("gender"));
		String[] qlyArr = (String[]) context.getAttribute("qly");
		if( qlyArr != null)
		{
			out.println("<br> Qualification : ");
			for(String qly : qlyArr)
			{
				out.println("<br> "+qly);
			}
			
		}
		
		out.println("<br> Country : "+context.getAttribute("country"));
		
		out.println("<br> Experience : "+context.getAttribute("exp"));
		
		out.println("</center> </h1> ");
		
				
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			this.doGet(request, response);
	}
}
