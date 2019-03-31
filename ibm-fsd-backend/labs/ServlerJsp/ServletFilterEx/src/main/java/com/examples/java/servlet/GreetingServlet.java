package com.examples.java.servlet;

import java.io.PrintWriter;

public class GreetingServlet extends HttpServlet{
	public void init()
	{
		System.out.println("Servlet Initialized...");
	}
	
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException
	{
		
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
	       //resp.setIntHeader("refresh", 5);
	       System.out.println("Service method invoked");
	       PrintWriter outs=response.getWriter();
	       
	    String htmlRespone = "<html>";
	    htmlRespone += "<h3>Your username is<h3/>";      
	   </html>";
	    outs.println(htmlRespone);
	}
	
	public void destroy()
	{
		System.out.println("EmployeeRegistration Servlet Destroyed...");		
	}

}
