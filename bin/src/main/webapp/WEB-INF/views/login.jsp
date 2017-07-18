<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign in to continue to Fire-TimeSheet</h1>
            <div class="account-wall">
                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                     alt="">
                <form id="login-form" action="<c:url value="/login" />" method="post" class="form-signin">
                    <c:if test="${not empty error}">
                        <div class="error" style="color: #ff0000;">${error}</div>
                    </c:if>

                    <input name= "username" type="text" class="form-control" placeholder="Email" required autofocus
                           value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'>
                    <input name="password" type="password" class="form-control" placeholder="Password" required>
                    <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
                    <input class="btn btn-primary" type="submit" name="yt0" value="Login">
                    <input class="btn btn-danger btnClear" name="yt1" type="button" value="Clear" onclick="$('#login-form').trigger('reset');">

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <p></p>
                    <p></p>
                    <p></p>
                    <label class="checkbox pull-left">
                        <input type="checkbox" value="remember-me">
                        Remember me
                    </label>
                    <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="#" class="text-center new-account">Contact system admin to get an account </a>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
