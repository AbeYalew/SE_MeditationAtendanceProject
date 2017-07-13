<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/template/secureheader.jsp"%>
<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">Student List</div>
		<div class="panel-body">

			<div class="col-sm-12">
				<form action="../user/get" method="GET">
					<input type="search" class="form-control" id="id" name="userName" placeholder="enter studentId to search...">
					<button type="submit" class="btn btn-success">Search
						User By UserName</button>
				</form>
				<form action="../student/list" method="GET">
					<input type="search" class="form-control" id="id" name="entryDate" placeholder="enter entry date to search all the students in the entry ...">
					<button type="submit" class="btn btn-success">Search All
						Students By Entry</button>
				</form>

				<table class="table table-hover">
					<thead>
						<tr>
							<th>Student ID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Student Email</th>
							<th>Action</th>
						</tr>

					</thead>

					<tr>
						<td>${student.studentId}</td>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td>${student.emailaddress}</td>
						<td>
							<form action="../student/edit/${student.studentId}" method="GET">
								<button type="submit" class="btn btn-primary">Edit</button>
								<button type="button" class="btn btn-danger">Delete</button>
							</form>



						</td>

					</tr>



				</table>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>