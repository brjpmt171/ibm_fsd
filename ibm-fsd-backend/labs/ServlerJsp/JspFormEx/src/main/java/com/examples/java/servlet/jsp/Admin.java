package com.examples.java.servlet.jsp;

public class Admin {
	String name;
	String designation;
	String email;
	String password;
	public Admin(String name, String designation, String email, String password) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.designation=designation;
		this.email=email;
		this.password=password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
