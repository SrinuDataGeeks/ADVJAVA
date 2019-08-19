package com.google.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	ServletConfig servletConfig =	getServletConfig();
	ServletContext servletContext = getServletContext();
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	out.println("<h1> <center>");
	out.println(" <br>  configPath = "+servletConfig.getInitParameter("configPath"));
	out.println(" <br>  configTest = "+servletConfig.getInitParameter("configTest"));
	
	
	out.println(" <br>  contextTest = "+servletContext.getInitParameter("contextTest"));
	out.println(" <br>  serverPath = "+servletContext.getInitParameter("serverPath"));
	
	out.println("</center> </h1> ");
	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
}
