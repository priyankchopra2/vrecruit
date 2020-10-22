<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
		
<table>
		<tr>
		<td> User Name:</td>
			<td> ${usersession.username}</td>
			
		</tr>
		
		
		<tr>
		<td> Email Id:</td>
			<td> ${usersession.email}</td>
			
		</tr>
		<tr>
		<td> Dob:</td>
			<td> ${usersession.dob}</td>
			
		</tr>
		<tr>
		<td> Phone:</td>
			<td> ${usersession.phone}</td>
			
		</tr>
		
		<tr>
			<td><form action="editprofile">
			<input type="submit" value="edit profile">
			</form></td>
		</tr>
		
					<form action="userpage">
			<input type="submit" value="Home">
			</form>
	</table>
</body>
</html>