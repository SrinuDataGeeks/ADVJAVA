<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Div Page</title>
</head>
<body>

<%
int a = Integer.parseInt(request.getParameter("a"));
int b = Integer.parseInt(request.getParameter("b"));
int c = a/b;

out.println( "<h1> <center> Web Config => Div is  C = "+c+"</center> </h1>");
%>

</body>
</html>