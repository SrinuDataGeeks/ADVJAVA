package com.google.ex;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Driver;
import oracle.jdbc.OracleDriver;
import java.sql.Statement;
import java.sql.ResultSet;

public class GetProductsApp
	{
public static void main(String args[]) throws Exception
{
	//Step 1 : Loads the Driver Class
	Class.forName("oracle.jdbc.OracleDriver");
	
	//Step 2 : Register Driver Class with Driver Manager Here the OracleDriver static block has this logic so after loading OracleDriver static block will be executed so we no need to write it explicitly.
	

	//Step 3 : Get the Connection Object .
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");

	//Step4 Create a Statement Object

	Statement st = con.createStatement();
String sql = "Select PID,PNAME,PRICE From Product";

	//Step5 Submit the  Select Query using executeQuery(String) method
	ResultSet rs = st.executeQuery(sql);

	while(rs.next())
	{
	System.out.println(rs.getInt("PID")+ "  :  "+rs.getString("PNAME")+ " : "+rs.getFloat("PRICE"));
	}

st.close();
con.close();

}
	}







