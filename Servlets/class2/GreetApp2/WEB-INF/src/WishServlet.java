package com.google.servlet;
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class WishServlet extends GenericServlet
{

public void service(ServletRequest request, ServletResponse response) throws IOException,ServletException
{

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	out.println(" <h1> <center> Good Mornig to all  -- : From wish </center></h1>");
		

	out.close();
}

}