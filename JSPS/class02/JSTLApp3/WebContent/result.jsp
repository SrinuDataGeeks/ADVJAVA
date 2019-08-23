<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.*"
    %>
   
   <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result page</title>
</head>
<body>

<h1> Qualification JSTL<br>

<%

	request.setAttribute("qlyArr",request.getParameterValues("qly"));
List<String> list = new ArrayList<String>();
list.add("Srinu");
list.add("Naresh");
list.add("Mahesh");
list.add("Ganesh");
session.setAttribute("namesList" , list);

%>



<c:forEach items="${qlyArr}"  var="q">
<c:out value="${q}"></c:out> <br>
</c:forEach>

<br> Iteration ArrayList
<c:forEach items="${namesList}"  var="name">
<br><c:out value="${name}"></c:out> 
</c:forEach>

<br> Print Numbers for 1 to 10

	<c:forEach begin="1" end="10" var="i">
	<br> <c:out value="${i}"></c:out>
	</c:forEach>
	
<c:set var="name" value="Srinu-Srikath-Naresh-Venkat-Sateesh-Ligaiah-Sai"></c:set>

<c:forTokens items="${name}" delims="-" var="n">
<br> <c:out value="${n}"></c:out>
</c:forTokens>


<br><br> url , param tags demo 

<c:url var="urlInfo" value="/registerServlet">
<c:param name="username" value="Srinu"></c:param>
<c:param name="password" value="Srinu123"></c:param>
</c:url>

 <br> Constructed URL is : 
 
 <br><c:out value="${urlInfo}"></c:out>

</h1> 


</body>
</html>