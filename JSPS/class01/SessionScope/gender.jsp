<%

String username = request.getParameter("username");

session.setAttribute("username",username);


%>


<center>

<h1>

<form action="./qly.jsp" >

Gender <br><br>
<input type="radio" name="gen"  value="Male" > Male </input> <br><br> 

<input type="radio" name="gen"  value="Female" > Female </input> <br><br>

<input type="submit" value="Next" />

</form>

</h1>

</center>