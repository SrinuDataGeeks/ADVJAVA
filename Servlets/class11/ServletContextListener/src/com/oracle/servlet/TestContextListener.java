package com.oracle.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestContextListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("\n\n *** From  ServletContextListener contextInitialized ");
		ServletContext context = sce.getServletContext();
		context.setAttribute("envInfo", "Test ENV URL www.iattest.com/login.jsp");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("\n\n *** From  ServletContextListener contextDestroyed ");
	}

}
