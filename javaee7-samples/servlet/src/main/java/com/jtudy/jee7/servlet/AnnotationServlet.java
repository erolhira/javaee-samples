package com.jtudy.jee7.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Annotations are validated by the compiler.
 * @Deprecated, @Override, @WebServlet, @PreDestroy, @PostConstruct
 */
//@WebServlet("/testAnnotation")
@WebServlet(urlPatterns={"/testAnnotation", "/annotation"})
public class AnnotationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	/*
	 * -Djava.util.logging.config.file=D:/dev/ws/jee7_workshop/TestWeb/src/test/logging.properties
	 */
	private static final Logger logger = Logger.getLogger("AnnotationServlet");
	
    public AnnotationServlet() {
        super(); 
    }
    
    @PostConstruct
    public void afterConstruct(){
    	logger.log(Level.WARNING, "@PostConstruct runs.");
    }
    
    @PreDestroy
    public void beforeDestroy(){
    	//component container'dan destroy edilmeden once calisir. 
    	logger.log(Level.INFO, "@PreDestroy runs.");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.log(Level.INFO, "Served at: " + request.getContextPath());
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}
}
