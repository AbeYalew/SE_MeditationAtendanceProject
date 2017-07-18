<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/secureheader.jsp"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">


	<fieldset class="col-md-4">
		<legend>
			<span class="text-info">${user.roles.role}</span> <span
				class="text-primary">User </span>
		</legend>
		<div class="panel panel-default">
			<div class="panel-body">
				<table class="table table-striped table table-condensed">
					
					<tr>
						<td>UserId: ${user.id}</td>
					</tr>
					<tr>
						<td>User Name: ${user.name}</td>
					</tr>

					<tr>
						<td>Role: ${user.roles.role}</td>
					</tr>
					<c:if test="${user.roles.role == 'STUDENT'}">
					<tr>
						<td>Details: <a href="../user/getStudent/${user.studentId}/${user.name}">Details:</a>
						</td>
						<td><a href="editStudent/${user.studentId}/${user.name}"> edit</a> </td>
					</tr>
					</c:if>
					<c:if test="${user.roles.role == 'FACULTY'}">
					<tr>
						<td>Details: <a href="../../user/getFaculty/${user.facultyId}/${user.name}/">Details:</a>
						</td>
						<td><a href="editFaculty/${user.facultyId}/${user.name}"> edit</a> </td>
					</tr>
					</c:if>

				</table>
			</div>
		</div>
	</fieldset>
	<div class="clearfix"></div>	
	<a href="/student/find"> Home</a>
	</div>


</body>

<%@include file="/WEB-INF/views/template/footer.jsp"%>