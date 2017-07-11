<%@include file="/WEB-INF/views/template/secureheader.jsp"%>
<div class="container">
    <!-- Example row of columns -->
    <div class="panel panel-primary">
        <div class="panel-heading">Edit Student</div>
            <div class="panel-body">

    <div class="row">
        <div class="col-sm-6">
            <form action="../../student/edit/${student.id}" method="POST" >
                <div class="form-group">
                    <label for="id">Student Id:</label>
                    <input type="text" class="form-control" id="id" name="studentID" value="${student.studentID}">
                </div>
                <div class="form-group">
                    <label for="fname">First Name:</label>
                    <input type="text" class="form-control" id="fname" name="firstName" value="${student.firstName}">
                </div>
                <div class="form-group">
                    <label for="lname">Last Name:</label>
                    <input type="text" class="form-control" id="lname" name="lastName" value="${student.lastName}">
                </div>
                <div class="form-group">
                    <label for="bcode">Student Barcode:</label>
                    <input type="text" class="form-control" id="bcode" name="barCode" value="${student.barCode}">
                </div>

                <button type="submit" class="btn btn-default">Update Student</button>
            </form>
        </div>
    </div>


</div>
</div>
</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>
