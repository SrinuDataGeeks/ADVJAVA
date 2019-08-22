<%

String gender = request.getParameter("gen");

session.setAttribute("gender",gender);


%>


<center>

<h1>

<form action="./register.jsp" >

Qualification <br><br>

<input type="checkbox" name="qly"  value="B.tech" > B.Tech  </input>   

<input type="checkbox" name="qly"  value="M.tech" > M.Tech  </input>  

<input type="checkbox" name="qly"  value="B.sc" > B.sc  </input>  

<input type="submit" value="Register" />

</form>

</h1>

</center>