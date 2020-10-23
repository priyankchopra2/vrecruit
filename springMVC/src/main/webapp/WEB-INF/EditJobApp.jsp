
<%@ include file="header.jsp"%>

<div class="container-fluid center">
	<div class="wrapper" style="margin: 50px;">
		<h1>Edit Job Application</h1>

		<form:form action="/app/jobApp/update" method="post"
			modelAttribute="jobApp">
			<form:hidden path="jid" value="${jobApp.jid}" readonly="true" />
			<br />
			<br />
	Title
	<form:input path="title" value="${jobApp.title}" />
			<br />
			<br />
	Category  
	<form:select path="category" value="${jobApp.category}">
				<c:forEach items="${categories}" var="c">
					<option><c:out value="${c}" /></option>
				</c:forEach>
			</form:select>
			<br />
			<br />
	Position Type
	<form:input path="position_type" value="${jobApp.position_type}" />
			<br />
			<br />
	Job Description
	<form:input path="job_description" value="${jobApp.job_description}" />
			<br />
			<br />
	Rounds
	<form:input path="rounds" value="${jobApp.rounds}" />
			<br />
			<br />
	Interviewer
	<form:input path="interviewer.id" value="${jobApp.interviewer.id}"
				readonly="true" />
			<br />
			<br />
			<input class="btn btn-primary" type="submit" value="Submit" />



		</form:form>
	</div>
</div>

</body>
</html>