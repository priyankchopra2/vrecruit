<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	</br>


	<table>
		<tr>
			<td>Job Title</td>
			<td>${jobApplication.title }</td>
		</tr>
		<tr>
			<td>Job description</td>
			<td>${jobApplication.job_description }</td>
		</tr>
		<tr>
			<td>Current Round</td>
			<td>${job.currentround }</td>
		</tr>
		<tr>
			<td>Status</td>
			<td>${status}</td>
		</tr>
	</table>



	<form action="userpage">
		<input type="submit" value="Home">
	</form>

</body>
</html>