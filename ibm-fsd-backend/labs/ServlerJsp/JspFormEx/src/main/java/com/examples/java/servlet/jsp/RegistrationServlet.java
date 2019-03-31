package com.examples.java.servlet.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationServlet extends HttpServlet{
	Admin admin=null;
	EmployeeDao dao=new EmployeeDao();
	String msg;
	
	public void init()
	{
		System.out.println("EmployeeRegistration Servlet Initialized...");
	}
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("Calling GET method");
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String designation =  request.getParameter("designation");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		admin=new Admin(name,designation,email,password);
		session.setAttribute("user", email);
		session.setAttribute("pass", password);
		
		if(admin==null) {
			msg="Please enter all credentials";
			return;
		}else {
			int regStatus=dao.adminRegistration(admin);
			if(regStatus>0) {
				msg="Registration successfull";
				System.out.println("Registration successfull");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("Registration Failed");
			}
		}
		
		/*String msg="Registration successfull";
		request.getSession().setAttribute("message", msg);*/
		
	}
	public void destroy()
	{
		System.out.println("EmployeeRegistration Servlet Destroyed...");		
	}
}
