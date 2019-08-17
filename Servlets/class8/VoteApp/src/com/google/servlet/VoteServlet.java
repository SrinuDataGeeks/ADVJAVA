package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String name = (String)request.getAttribute("name");
			String result = (String) request.getAttribute("result");
			
			
				out.println("<h1> <center> Welcome "+name);
				
				out.println("<br><br>"+result);
				
				out.println(" </center></h1>");
				
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			this.doGet(request, response);
	}
}
