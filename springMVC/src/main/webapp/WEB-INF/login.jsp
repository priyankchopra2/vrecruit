<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

</head>
<body>
<a href="/app">Home</a>
<h1>Interviewer Login</h1>
 
<form action="/app/loginAction" method="post" > 
	email
	<input type="text"  name="email" />  
	Password
	<input type="password" name="password" />
	<br/>
	<br/>
	<input type="submit" value="Submit" />
	
</form>
</body>
</html>