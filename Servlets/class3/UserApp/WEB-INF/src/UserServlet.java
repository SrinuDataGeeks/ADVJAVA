package com.google.servlet;
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends GenericServlet
	{
public void service(ServletRequest request , ServletResponse response) throws IOException,ServletException
{
	response.setContentType("text/html");
	PrintWriter out  = response.getWriter();

	String name  = request.getParameter("username");

	out.println(" <h1> <center> Welcome to " +name+ " </center> </h1>");

	out.close();	
}
	}