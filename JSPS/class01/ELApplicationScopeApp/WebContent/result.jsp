
<center>

<h1> 

Data presented in Session Object is : <br><br>


UserName : ${applicationScope.username} <br><br>
Gender :   ${applicationScope.gender}    <br><br>

Wihout using 'applicationScope' <br>

UserName : ${username} <br>
Gender :   ${gender}    <br><br>

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


