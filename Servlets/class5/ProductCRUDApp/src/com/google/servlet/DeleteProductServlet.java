package com.google.servlet;
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.service.ProductService;
import com.google.service.exp.ServicesException;
import com.google.dao.bean.ProductBean;

public class DeleteProductServlet extends GenericServlet
	{
public void service(ServletRequest request , ServletResponse response) throws IOException,ServletException
{
	response.setContentType("text/html");
	PrintWriter out  = response.getWriter();

	String  id = request.getParameter("productId");
	Integer pid = Integer.valueOf(id);

	out.println(" <h1> <center>");
	ProductService service = new ProductService();
	try
	{
	boolean flag = service.deleteProductById(pid);
	if(flag)
		{
	out.println(" Product deleted Successfully ");
		}
	else
		{
		out.println(" Invalid Product ID ");
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