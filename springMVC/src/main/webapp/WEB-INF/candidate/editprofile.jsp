<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<form:form id="regForm"  modelAttribute="usersession" action="updateuser"
		method="post">

		<table >
		<th>
		Edit Profile
		</th>
		 <form:hidden path="id"  value="${usersession.id}"/>
		
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input  path="username" name="username" id="username" /></td>
				<td><form:errors  path="username" name="username" id="username" /></td>
		
			</tr>
			
			 <form:hidden path="password"  value="${usersession.password}"/>
		<form:errors  path="password" name="password" id="password" /></td>
		
				<tr>
				<td>
				Date(dd/mm/yyyy)<fmt:formatDate value='${usersession.dob}' pattern="dd/MM/yyyy" var="dob"/></td>
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
				<td><form:button id="update" name="update">Update</form:button></td>
			</tr>
			<tr></tr>
			<tr>
				
					
		
			</tr>
		</table>
	</form:form>
	<form action="userpage">
			<input type="submit" value="Home">
			</form>


</body>
</html>