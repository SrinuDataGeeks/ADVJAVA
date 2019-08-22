<%

String[] qly = request.getParameterValues("qly");

session.setAttribute("qly",qly);


%>


<center>

<h1>

Registration is Successfull !!! <br><br>

<a href="./result.jsp"> Show Data </a>

</h1>

</center>