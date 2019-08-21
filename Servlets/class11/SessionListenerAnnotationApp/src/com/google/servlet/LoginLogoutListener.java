package com.google.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoginLogoutListener implements HttpSessionListener {

		private Integer activeUsersCount = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		activeUsersCount++;
		ServletContext context = se.getSession().getServletContext();
		context.setAttribute("userCount", activeUsersCount);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		activeUsersCount--;
		ServletContext context = se.getSession().getServletContext();
		context.setAttribute("userCount", activeUsersCount);
	}
}


