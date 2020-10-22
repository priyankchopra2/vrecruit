  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<form:form id="regForm"  modelAttribute="user" action="saveuser"
		method="post">

		<table >
		  <form:hidden path="id" />
		
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input  path="username" name="username" id="username" /></td>
				<td><form:errors  path="username" name="username" id="username" /></td>
		
			</tr>
			
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password  path="password" name="password"
						id="password" /></td>
						<td><form:errors  path="password" name="password" id="password" /></td>
		
			</tr>
				<tr>
				<td>
				Date(dd/mm/yyyy)<fmt:formatDate value="${user.dob}" pattern="dd/MM/yyyy" var="dob"/></td>
				<td><form:input path="dob" value="${dob}"/></td>
				<td><form:errors  path="dob" name="dob" id="dob" /></td>
		
		
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
				<td><form:errors  path="email" name="email" id="email" /></td>
		
			</tr>
			
			
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input path="phone" name="phone" id="phone" /></td>
					<td><form:errors  path="phone" name="phone" id="phone" /></td>
		
			</tr>
						<tr>
				<td></td>
				<td><form:button id="register" name="register">Register</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				
			</tr>
		</table>
	</form:form>
<td><a href="/recruitmentoperation/home">Home</a></td>



</body>
</html>