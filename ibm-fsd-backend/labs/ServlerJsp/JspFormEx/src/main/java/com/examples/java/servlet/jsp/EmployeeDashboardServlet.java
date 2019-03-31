package com.examples.java.servlet.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeDashboardServlet extends HttpServlet{
	EmployeeDao dao=new EmployeeDao();
	Employee emp=null;
	String msg;
	
	public void init()
	{
		System.out.println("EmployeeDashBoard  Servlet Initialized...");
	}
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("Calling GET method");
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException{
		
			List<Employee> empList=dao.showEmployee();
			
			//getServletContext().setAttribute("emp", empList);
			request.setAttribute("empObj", empList);
	}
	public void destroy()
	{
		System.out.println("EmployeeRegistration Servlet Destroyed...");		
	}
}
