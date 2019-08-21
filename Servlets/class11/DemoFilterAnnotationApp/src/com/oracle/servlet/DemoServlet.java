package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.Contended;


@WebServlet("/demo")
public class DemoServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("\n\n **DemoServlet doGet Started ");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html> <body> <center> <h1> Response From DemoServlet <br><br>");
		
				out.println(" Welcome Filter Concept !!!!");
				out.println("<br><br> No Of Page views  : s  "+getServletContext().getAttribute("viewPageCount"));
			
			out.println("</h1> </center> </body> </html> ");
			out.close();
			
		System.out.println("\n\n **DemoServlet doGet Ended ");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
