package com.google.servlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoServlet implements Servlet
	{
private ServletConfig config;

public DemoServlet()
{
System.out.println(" \n\n Instantiation Phase : DemoServlet Class Loaded and Object Created");
}

public void init(ServletConfig config)
{
	this.config = config;
System.out.println(" \n\n Iniatilization Phase : DemoServlet Initialization is completed from init(ServletConfig)");
}

public void service(ServletRequest request , ServletResponse response) throws ServletException , IOException
{
System.out.println(" \n\n Servicing Phase : DemoServlet service(..) method called");
response.setContentType("text/html");

PrintWriter out = response.getWriter();

out.println(" <h1> <center> Welcome to Servlets </center> </h1>");

out.close();

}

public void destroy()
{
System.out.println(" \n\n Destruction Phase : DemoServlet Object is removed !!! from destroy() method");
	
	try
	{
		Thread.sleep(5000);
	}catch(Exception exp)
		{
		}
}

public String getServletInfo()
{
	return " DemoServlet Program";
}

public ServletConfig getServletConfig()
{
	return config;
}
	}






