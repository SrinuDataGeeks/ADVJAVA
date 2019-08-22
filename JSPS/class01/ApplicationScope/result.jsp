
<center>

<h1> 

Data presented in ServletContext Object is : <br><br>


UserName : <%= application.getAttribute("username") %> <br><br>
Gender : <%= application.getAttribute("gender") %> <br><br>

Qualification :

		<%
		String[] qlyArray = (String[]) application.getAttribute("qly");

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


