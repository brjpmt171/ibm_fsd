<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>
</head>
<body>
<hr>
	<center>
	<form action="register.go" method="post">
		<table>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Employee Designation</td>
				<td><input type="text" name="designation"></td>
			</tr>
			<!-- <tr>
				<td>Employee Department</td>
				<td><select>
					<option value="Developer">Developer</option>
					<option value="Manager">Manager</option>
					<option value="Admin">Admin</option>
				</select></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="Male">
					<input type="radio" name="gender" value="Female">
				</td>
			</tr> -->
			
			<tr>
				<td>Employee Email</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>Create Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>