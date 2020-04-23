package com.jtudy.jee8.servlet4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/push")
public class ServletPush extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletPush() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.newPushBuilder().path("image/javalopment.png").addHeader("content-type", "image/png").push();		
		response.getWriter().write("<html><body>" + "<img src='image/javalopment.png'>" + "</body></html>");
	}

}
