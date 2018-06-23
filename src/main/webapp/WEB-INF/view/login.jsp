<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login form</title>
<style type="text/css">
	.failed {
		color: red;
		font-weight: bold;
	}
</style>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/authenticateUser"
		method="POST">
		<c:if test="${param.error != null}">
			<i class="failed"> Login failed</i> 
		</c:if>
		<p>
			User: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>

		<input type="submit" value="Login" />
	</form:form>
</body>
</html>