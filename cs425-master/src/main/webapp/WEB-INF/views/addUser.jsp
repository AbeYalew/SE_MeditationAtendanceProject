<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/secureheader.jsp"%>
<div class="container">
    <!-- Example row of columns -->
    <div class="panel panel-primary">
        <div class="panel-heading">Add Student</div>
        <div class="panel-body">
    <div class="row">
        <div class="col-sm-6">
            <form:form commandName="student" action="${pageContext.request.contextPath}/student/add" method="POST">
                <div class="form-group">
                    <label for="id">Student Id:</label><form:errors path="studentID" cssClass="errorLable"/>
                    <form:input path="studentID" type="text" class="form-control" id="id" name="studentID" />

                </div>
                <div class="form-group">
                    <label for="fname">First Name:</label><form:errors path="firstName" cssClass="errorLable"/>
                    <form:input path="firstName" type="text" class="form-control" id="fname" name="firstName" />
                </div>
                <div class="form-group">
                    <label for="lname">Last Name:</label><form:errors path="lastName" cssClass="errorLable"/>
                    <form:input  path ="lastName" type="text" class="form-control" id="lname" name="lastName" />
                </div>
                <div class="form-group">
                    <label for="bcode">Student Barcode:</label><form:errors path="barCode" cssClass="errorLable"/>
                    <form:input path="barCode" type="text" class="form-control" id="bcode" name="barCode" />
                </div>

                <button type="submit" class="btn btn-default">Add Student</button>
            </form:form>
        </div>
    </div>


</div>
    </div></div></div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>