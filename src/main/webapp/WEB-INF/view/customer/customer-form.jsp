<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Update Customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM Update Customer</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<form:form action="save" modelAttribute="customer"
				method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>First name:</label></td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td><label>Last name:</label></td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td><label>E-mail:</label></td>
							<td><form:input path="email" /></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="Save" />
			</form:form>
			<div style=""></div>
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
			</p>
		</div>
	</div>
</body>
</html>