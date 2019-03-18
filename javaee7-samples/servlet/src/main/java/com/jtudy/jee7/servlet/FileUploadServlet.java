package com.jtudy.jee7.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload")
@MultipartConfig(location="d:/tmp")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FileUploadServlet() {
        super(); 
    } 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		request.getParts();
	}

}
