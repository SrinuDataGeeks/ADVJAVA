<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    %>
   
   <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result page</title>
</head>
<body>

<h1> Demo on JSTL<br><br>


<c:set var="count" value="10"></c:set>

<%-- <c:import  var="data" url="https://www.facebook.com"></c:import> --%>


Count : <c:out value="${count}"></c:out> <br><br><br>


<c:if test="${ count % 2 == 0 }">
<c:out value="count is Even Number"></c:out>
</c:if> <br><br><br>


<%-- Data : <c:out value="${data}"></c:out> <br> --%>

</h1> 


</body>
</html>