package com.oracle.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns  = "/demo" , 
initParams = @WebInitParam(name="config",value="/demo/annoconfig.properties") )

public class DemoFilter implements Filter{

	private FilterConfig filterConfig = null;
	private Integer viewPageCount  = 0;
	
	public DemoFilter()
	{
		System.out.println("\n\n*** DemoFilter object is created : ");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		System.out.println("\n\n*** DemoFilter init method is invoked : ");
		this.filterConfig = filterConfig;
		System.out.println(" config Param Value : "+filterConfig.getInitParameter("config"));
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("\n\n*** DemoFilter  doFilter(..) method  Pre processing logic is invoked : ");
		viewPageCount++;
		ServletContext context = filterConfig.getServletContext();		
		context.setAttribute("viewPageCount", viewPageCount);
		
		long beforemisec = System.currentTimeMillis();
		
		chain.doFilter(request, response); // DemoServlet will be invoked.
		
		System.out.println("\n\n*** DemoFilter doFilter(..) method  Post processing logic is invoked : ");
		
		long aftermisec = System.currentTimeMillis();
		System.out.println(" Request proessing time in misec "+(aftermisec - beforemisec) );
	}
	
	@Override
	public void destroy() {
		
	}

}
