<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom jsp</title>

<style>
    .error {
        color: red; font-weight: bold;
    }
</style>

</head>
<body>
<a href="/app">Home</a>
<h1>Create Interviewer</h1>
 
<form:form action="/app/jobApp/add" method="post" modelAttribute="jobApp" > 
	title
	<form:input  path="title" />  <br/>
	category
	<form:input path="category" />
	<br/>
	<br/>
	position_type
	<form:input path="position_type" />
	<br/>
	job_description
	<form:input path="job_description" />
	<br/>
	rounds
	<form:input path="rounds" />
	<br/>
	<input type="submit" value="Submit" />
	
	
	
</form:form>
</body>
</html>