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


<form:form action="/app/jobApp/update" method="post" modelAttribute="jobApp" > 
	<form:input  path="jid" value="${jobApp.jid}"/> 
	title
	<form:input  path="title" value="${jobApp.title}"/>  <br/>
	category
	<form:select path="category" value="${jobApp.category}">
		<c:forEach items="${categories}" var="c">
			<option><c:out value="${c}" /></option>
		</c:forEach>
	</form:select>
	<br/>
	<br/>
	position_type
	<form:input path="position_type"  value="${jobApp.position_type}" />
	<br/>
	job_description
	<form:input path="job_description" value="${jobApp.job_description}" />
	<br/>
	rounds
	<form:input path="rounds" value="${jobApp.rounds}" />
	<br/>
	interviewer
	<form:input path="interviewer.id"  value="${jobApp.interviewer.id}" readonly=""/>
	<br/>
	<input type="submit" value="Submit" />
	
	
	
</form:form>


</body>
</html>