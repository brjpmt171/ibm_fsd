package com.examples.java.servlet.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examples.java.servlet.jsp.Employee;

public class EmployeeDao {
	static String JDBC_DRIVER="com.mysql.jdbc.Driver";
	 static String DB_URL="jdbc:mysql://localhost/EmployeeManagement_db";
	 static String USER="root";
	 static String PASS="";

	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 
	 public EmployeeDao() {
			
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("connecting to db ....");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	 }

	public int adminRegistration(Admin admin) {
		// TODO Auto-generated method stub
		int status = 0;
		String registerSql = "insert into admin (name,designation,email,password) values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(registerSql);
			pstmt.setString(1, admin.getName());
			pstmt.setString(2, admin.getDesignation());
			pstmt.setString(3, admin.getEmail());
			pstmt.setString(4, admin.getPassword());
			
	
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error into Database in registration");
			e.printStackTrace();
		}
		return status;
		
	}

	public List<String> adminLogin(String email, String password) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		
		String loginSql = "select email,password from admin where email=? and password=?";
		
		try {
			pstmt = conn.prepareStatement(loginSql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String email1 = rs.getString("email");
				String password1 = rs.getString("password");
				System.out.println(email1+" "+password1);
				list.add(email1);
				list.add(password1);
			}
			System.out.println(list);
			System.out.println("login dao");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error into Database in registration");
			e.printStackTrace();
		}
		return list;
	}

	public int addEmp(Employee emp) {
		// TODO Auto-generated method stub
		int status = 0;
		String insertSql = "insert into employee (eid,name,salary,age,dept) values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, emp.getEid());
			pstmt.setString(2, emp.getName());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setInt(4, emp.getAge());
			pstmt.setString(5, emp.getDept());
	
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error into addIntoDB");
			e.printStackTrace();
		}
		return status;
	
	}

	public List<Employee> showEmployee() {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<Employee>();
		try {
			String selectRetrive = "select eid,name,age,dept,salary from employee";
			pstmt = conn.prepareStatement(selectRetrive);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String eid = rs.getString("eid");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String dept = rs.getString("dept");
				int salary = rs.getInt("salary");
				Employee emp = new Employee(eid,name,salary,age,dept);
				

				empList.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
		
	}
	 
	 
}
