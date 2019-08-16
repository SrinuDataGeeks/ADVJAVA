package com.google.servlet;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.service.ProductService;
import com.google.service.exp.ServicesException;
import com.google.dao.bean.ProductBean;

public class SaveProductServlet extends GenericServlet
	{
public void service(ServletRequest request , ServletResponse response) throws IOException,ServletException
{
	response.setContentType("text/html");
	PrintWriter out  = response.getWriter();

	
	Integer pid = Integer.valueOf(request.getParameter("productId"));
	String  pname = request.getParameter("productName");
	Float price = Float.valueOf(request.getParameter("productPrice"));

	ProductBean product = new ProductBean(pid,pname,price);

	out.println(" <h1> <center>");
	ProductService service = new ProductService();
	try
	{
	ProductBean product2 = service.getProductById(pid);
	if(product2 != null)
		{
	out.println(" Product ID is already exist ");
		}
	else
		{
	boolean saveFlag =  service.save(product);
	if(saveFlag)
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.html");
		requestDispatcher.forward(request, response);
	}else
	{
	out.println(" Product Registration Failed ");
	}
		}
	}catch(ServicesException exp)
		{
	exp.printStackTrace();
	out.println("  Internal error Please check the logs "+exp);
		}
	
	out.println("</center>  </h1> ");
	out.close();	
}
	}