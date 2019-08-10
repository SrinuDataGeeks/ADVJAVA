package com.google.servlet;
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class GreetsServlet extends GenericServlet
{

public void service(ServletRequest request, ServletResponse response) throws IOException,ServletException
{

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	String  value  = request.getParameter("method");


	if(value.equalsIgnoreCase("wish"))
	{
	out.println(" <h1> <center> Good Mornig to all  : From wish </center></h1>");
	}else if(value.equalsIgnoreCase("greet"))
	{
	out.println(" <h1> <center> Congrats  : From  Greet </center></h1>");
	}else
	{
	out.println(" <h1> <center> Hi Everyone : From Message</center></h1>");
	}	

	out.close();
}

}