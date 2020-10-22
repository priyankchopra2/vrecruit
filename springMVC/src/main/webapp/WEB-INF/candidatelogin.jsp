 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form:form id="login"  modelAttribute="user" action="login"
		method="post">

<table align="center">
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input  path="email" name="email" id="email" /></td>
			</tr>
			
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password  path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
			
				<tr>
				<td><form:button id="login" name="login">Login</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				
			</tr>
		</table>
	</form:form>

</body>
</html>