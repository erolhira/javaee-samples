package com.jtudy.jee8.servlet4;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @WebListener can be used to declare ServletListener for the interfaces:
 * javax.servlet.ServletContextAttributeListener 
 * javax.servlet.ServletContextListener
 * javax.servlet.ServletRequestAttributeListener
 * javax.servlet.ServletRequestListener
 * javax.servlet.http.HttpSessionIdListener 
 *
 */
@WebListener
public class SimpleServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	System.out.println("contextInitialized is called.");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	System.out.println("contextDestroyed is called.");
    }
	
}
