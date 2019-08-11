package com.google.servlet;
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends GenericServlet
	{
public void service(ServletRequest request , ServletResponse response) throws IOException,ServletException
{
	response.setContentType("text/html");
	PrintWriter out  = response.getWriter();

	String name  = request.getParameter("username");
	String[] qlyArr = request.getParameterValues("qly");
	String  gender = request.getParameter("gender");
	String country  = request.getParameter("country");
	

	out.println(" <h1> <center>");
	out.println( "<br> Name : "+name);
		if(qlyArr != null)
		{
	out.println( "<br> Qualification : ");
	for(String qly : qlyArr)
	{
	out.println( "<br>"+qly);
	}
		}
	out.println( "<br>  Gender : "+gender);
	out.println( "<br> Country : "+country);
	out.println(" </center> </h1>");

	out.close();	
}
	}