<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee DashBoard</title>
</head>
<body>
	<center>
		<h2>Employee DashBoard</h2>
		<%= getServletContext().getAttribute("msg") %>
	</center>
	<hr>
	<br/>
	<h1>Employees List</h1>  
	<form action="employee-dashboard.go" method="post">
	<table border="2" width="70%" cellpadding="2">  
	<tr><th>Id</th><th>Name</th><th>Salary</th><th>Age</th><th>Department</th><th>Edit</th><th>Delete</th></tr>  
	 
	   <c:forEach var="emp" items="${empObj}">   
	   <tr>  
	   <td>${emp.eid}</td>  
	   <td>${emp.name}</td>  
	   <td>${emp.salary}</td>  
	   <td>${emp.age}</td>  
	   <td>${emp.dept}</td>  
	   <%-- <td><a href="editemp/${emp.id}">Edit</a></td>  
	   <td><a href="deleteemp/${emp.id}">Delete</a></td>   --%>
	   </tr>  
	   </c:forEach>  
	 </table>  
	</form>
	<a href="addEmployee.jsp">Add New Employee</a>
</body>
</html>