<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<a href="/app/">Home</a>


<form:form action="/app/jobApp/updateCandidateJobProcess" method="post" modelAttribute="candidateDetails" > 
	Name: <b>${candidateDetails.user.getUsername()}</b>
	<form:input  path="jobid" value="${candidateDetails.jobid}" /> 
	<form:input  path="user.id" value="${candidateDetails.user.id}" />  
	<form:input  path="jobApplication.jid" value="${candidateDetails.jobApplication.jid}"/>  
	
	Marks
	<form:input  path="marks" value="${candidateDetails.marks}"/>  <br/>
	category
	<br/>
	<br/>
	click to download Resume
	<a href="/app/jobApp/download/${candidateDetails.jobid}">
			${candidateDetails.resume.getOriginalFilename()}
	</a>
	<br/>
	
	
	Selected
	
	<form:checkbox path="selected" value="${candidateDetails.selected}"/>
	<br/>
	current Round of candidate
	<form:input path="currentround" value="${candidateDetails.currentround}" />
	<br/>
	interviewer
	<br/>
	<input type="submit" value="Submit" />
	
	
	
</form:form>


</body>
</html>