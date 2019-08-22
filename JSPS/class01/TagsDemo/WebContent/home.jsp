<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tags Demo</title>
</head>
<body>

<%!
	int a = 10;
	int b = 15;
	
	public int add(int a , int b)
	{
		return a+b;
	}
%>

<br><br>Using Expression Tag <%=  add(a,b) %>

<br><br>Using Scriplet Tag <%
					   int c = add(a,b);
					   out.println( " C = "+c);
					%>

</body>
</html>