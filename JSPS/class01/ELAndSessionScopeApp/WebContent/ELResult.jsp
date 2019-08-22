<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expression Language </title>
</head>
<body>

<h1>
<br><br> Using Expression lang with sessionScope:	<br><br>
	
Name : ${sessionScope.username} <br><br>

Gender : ${sessionScope.gender} <br><br>

Qly : ${sessionScope.qly }


<br><br>  Expression lang without using sessionScope:	<br><br>
	
Name : ${username} <br><br>

Gender : ${gender} <br><br>

Qualification :

		<%
		String[] qlyArray = (String[]) session.getAttribute("qly");

		if(qlyArray  != null && qlyArray.length > 0)
			{
		for(String qly : qlyArray)
		{
			out.println(qly);
		}
			}
		%>
</h1>

</body>
</html>