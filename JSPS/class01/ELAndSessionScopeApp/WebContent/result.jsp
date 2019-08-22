<%@ page isELIgnored="false" %>
<center>

<h1> 

Data presented in Session Object is : <br><br>


UserName : <%= session.getAttribute("username") %>

Gender : <%= session.getAttribute("gender") %> <br><br>

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




<a href="./ELResult.jsp"> Expression Laguage Data</a>

</h1>


</center>


