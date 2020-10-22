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
 		
Welcome ${usersession.username}
			<form action="viewprofile">
			<input type="submit" value="view profile">
			</form>
			<form action="candidateJobAppList">
				<input type="hidden" name="id" value="${usersession.id}">
		
			<input type="submit" value="Job list">
			</form>
			<form action="logout">
			<input type="submit" value="logout">
			</form>


</body>
</html>