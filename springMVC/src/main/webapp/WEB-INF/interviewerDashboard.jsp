<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>

</head>
<body>

<h1>This is Interviewer Dashboard</h1>

your id->
 ${id} 

<h2>Welcome ${name} </h2> 

<ul>
	<li>
		Create Job Applications: <a href="jobApp/create">Create job Application</a>
	</li>
	<li>
		View/Edit Job Applications Created By You: <a href="jobApp/view">Create job Application</a>
	</li>
	<li>
		View/Edit All Job Applications: <a href="jobApp/viewAll">Create job Application</a>
	</li>
	<li>see the designation if it is HR he can have final select candidate option and can see all the job applications</li>
</ul>


</body>
</html>