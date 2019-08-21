package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		String envInfo = (String) context.getAttribute("envInfo");
		
		out.println("<html> <body> <center> <h1>");			
		out.println(" Demo on ServletContextListener <br><br>");
		out.println(" Environment Info : "+envInfo);
		out.println("</h1> </center> </body> </html>");
		
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		
		doGet(request,response);
	};

}
