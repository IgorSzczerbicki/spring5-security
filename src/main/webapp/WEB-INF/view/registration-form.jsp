<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration form</title>
</head>
<body>
	<!-- Registration Form -->
	<form:form
		action="${pageContext.request.contextPath}/register/processRegistrationForm"
		modelAttribute="crmUser" class="form-horizontal">
		<!-- Check for registration error -->
		<c:if test="${registrationError != null}">
			<div class="alert alert-danger col-xs-offset-1 col-xs-10">
				${registrationError}</div>
		</c:if>  …   <!-- User name -->
		<form:input path="userName" placeholder="username"
			class="form-control" />
		<!-- Password -->
		<form:password path="password" placeholder="password"
			class="form-control" />
		<button type="submit" class="btn btn-primary">Register</button>
	</form:form>
</body>
</html>