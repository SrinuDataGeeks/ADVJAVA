<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome page</title>
</head>
<body>



	<c:set var="username" value="${param.username}"></c:set>

	<c:choose>

		<c:when test="${ username != null && username.length() > 0 }">
			<jsp:forward page="result.jsp" />
		</c:when>
		<c:otherwise>
			<h1>user name should not be empty !!!</h1>

			<jsp:include page="user.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>





</body>
</html>