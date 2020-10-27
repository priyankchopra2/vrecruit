<%@ include file="header.jsp"%>
<%@ include file="sidebar.jsp"%>

<div class="container-fluid  center">
	

	<div class="center">
	
 
		
<table align="center">
		<tr>
		<td> User Name:</td>
			<td> ${usersession.username}</td>
			
		</tr>
		
		
		<tr>
		<td> Email Id:</td>
			<td> ${usersession.email}</td>
			
		</tr>
		<tr>
		<td> Dob:</td>
			<td> ${usersession.dob}</td>
			
		</tr>
		<tr>
		<td> Phone:</td>
			<td> ${usersession.phone}</td>
			
		</tr>
		
		
	</table>
		
	</div>
</div>
</body>
</html>