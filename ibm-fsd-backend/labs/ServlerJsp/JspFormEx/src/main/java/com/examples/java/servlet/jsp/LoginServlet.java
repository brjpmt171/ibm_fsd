package com.examples.java.servlet.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	Admin admin=null;
	EmployeeDao dao=new EmployeeDao();
	String msg;
	
	public void init()
	{
		System.out.println("EmployeeLogin Servlet Initialized...");
	}
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("Calling GET method");
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		List<String> loginStatus=dao.adminLogin(email,password);
		System.out.println("test");
		if(loginStatus.get(0).equals(email) && loginStatus.get(1).equals(password)) {
			System.out.println("Login Successfull");
			getServletContext().setAttribute("msg","Login Successfull");
			msg="Login Successfull";
			RequestDispatcher rd = request.getRequestDispatcher("employee-dashboard.jsp");
			rd.forward(request, response);
		}else {
			System.out.println("Login failed");
			getServletContext().setAttribute("msg","Login Failed");
			msg="Login failed";
			//return;
			//response.sendRedirect("login.jsp");
		}
		
	}
}
