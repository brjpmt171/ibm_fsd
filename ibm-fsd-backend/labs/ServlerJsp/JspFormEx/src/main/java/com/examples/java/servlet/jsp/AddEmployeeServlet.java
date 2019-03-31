package com.examples.java.servlet.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddEmployeeServlet extends HttpServlet{
	EmployeeDao dao=new EmployeeDao();
	Employee emp=null;
	String msg;
	
	public void init()
	{
		System.out.println("EmployeeAdd Servlet Initialized...");
	}
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("Calling GET method");
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		
		String eid = request.getParameter("eid");
		String name = request.getParameter("name");
		int salary = Integer.parseInt(request.getParameter("salary"));
		int age =  Integer.parseInt(request.getParameter("age"));
		String dept = request.getParameter("dept");
		
		
		emp=new Employee(eid,name,salary,age,dept);
		
		
		if(emp==null) {
			msg="Please enter all credentials";
			return;
		}else {
			int addStatus=dao.addEmp(emp);
			if(addStatus>0) {
				msg="Employee successfull Saved";
				System.out.println("Adding successfull");
				getServletContext().setAttribute("msg","Employee successfull Saved");
				getServletContext().setAttribute("empObj",emp);
				
				RequestDispatcher rd = request.getRequestDispatcher("employee-dashBoard.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("Employee adding Failed");
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
