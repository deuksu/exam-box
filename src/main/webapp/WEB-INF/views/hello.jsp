<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="css/app.css" />" rel="stylesheet"
	type="text/css">
<title>Hello World!</title>
</head>
<body class="security-app">
	<div class="details">
		<h2>Spring Security - JDBC Authentication</h2>
	</div>

	<div class="lc-block">
		<h1>
			Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
		</h1>
		<h3>username : <sec:authentication property="principal" /></h3> 
		<h3>details : <sec:authentication property="details" /></h3> 
		<form action="/logout.do" method="post">
			<input type="submit" class="button red big" value="Sign Out" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>

</body>
</html>
