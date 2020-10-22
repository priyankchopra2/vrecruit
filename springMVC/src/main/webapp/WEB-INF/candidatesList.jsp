<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Job Applications</title>
</head>
<body>
	<a href="/app">Home</a>
	<a href="/app/dashboard">Dasboard</a>
	<h1>All Candidates who have applied to ${jobAppName}</h1>
	<br />
	<br />

	<table border="1">
		<c:forEach items="${lst}" var="i">
			<br />

			<tr>
				<th><b> username: <c:out value="${i.user.username}" /></b></th>
				<td>marks: <c:out value="${i.marks}" /></td>
				<td>resume: <c:out value ="${i.resume.getOriginalFilename()}" /></td>


				<td>selected: <c:out value="${i.selected}" /></td>
				<td>currentround: <c:out value="${i.currentround}" /></td>

				<td>
					<form action="viewCandidateJobProfile" method="get">
						<input type="hidden" name="id" value="${i.jobid}"> <input
							type="submit" value="viewCandidateJobProfile">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>