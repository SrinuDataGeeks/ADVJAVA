
<center>

<h1> 

Data presented in Session Object is : <br><br>


UserName : <%= session.getAttribute("username") %> <br><br>
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




</h1>


</center>


