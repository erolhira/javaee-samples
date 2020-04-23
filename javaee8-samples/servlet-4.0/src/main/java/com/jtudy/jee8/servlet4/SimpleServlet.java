package com.jtudy.jee8.servlet4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="SimpleServlet", 
		urlPatterns={"/simpleServlet", "/testServlet"},
		initParams={@WebInitParam(name="p1", value="v1"), @WebInitParam(name="p2", value="v2")})
public class SimpleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public SimpleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE HTML>");
		pw.println("<html>");
		pw.println("<body>");
		pw.println("Served at: " + request.getRequestURI());
		pw.println("<br>");
		pw.println("Init Param1: " + getServletConfig().getInitParameter("p1"));
		pw.println("</body>");
		pw.println("</html>");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
