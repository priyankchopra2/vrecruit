<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Job Application</title>

<style>
.error {
	color: red;
	font-weight: bold;
}
</style>

</head>
<body>
	<a href="/app">Home</a>
	<h1>Create Interviewer</h1>

	<form:form action="/app/jobApp/add" method="post"
		modelAttribute="jobApp"> 
	title
	<form:input path="title" />
	<form:errors path="title" cssClass="error" />
		<br />
	category
	<form:select path="category">
			<option selected="selected">select</option>
			<c:forEach items="${categories}" var="c">

				<option><c:out value="${c}" /></option>
			</c:forEach>
		</form:select>
		<br />
		<br />
	position_type
	<form:input path="position_type" />
		<br />
	job_description
	<form:input path="job_description" />
		<br />
	rounds
	<form:input path="rounds" />
		<br />
		<input type="submit" value="Submit" />



	</form:form>
</body>
</html>