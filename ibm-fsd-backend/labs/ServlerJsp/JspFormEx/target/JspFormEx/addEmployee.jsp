<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Enter Employee Details</h2>
		<hr>
		<form action="addEmployee.go" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td><input type="text" name="eid" /></td>
				</tr>
				
				<tr>
					<td>Employee Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				
				<tr>
					<td>Employee Salary</td>
					<td><input type="number" name="salary" /></td>
				</tr>
				
				<tr>
					<td>Employee Age</td>
					<td><input type="number" name="age" /></td>
				</tr>
				
				<tr>
					<td>Employee Department</td>
					<td><select name="dept">
							<option value="">--Select Department--</option>
							<option value="Developer">DEVELOPER</option>
							<option value="Manager">MANAGER</option>
							<option value="Tester">TESTER</option>
						</select></td>
				</tr>
				<tr>
				<td></td>
				<td><input type="submit" value="Add Details"></td>
			</tr>
			</table>
		</form>
	</center>
</body>
</html>