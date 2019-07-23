package com.google.ex;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Driver;
import oracle.jdbc.OracleDriver;

public class ConnectionApp1
	{
public static void main(String args[]) throws Exception
{
	//Step 1 : Loads the Driver Class
	Class.forName("oracle.jdbc.OracleDriver");
	
	//Step 2 : Register Driver Class with Driver Manager
	Driver driver = new OracleDriver();
	DriverManager.registerDriver(driver);

	//Step 3 : Get the Connection Object .

	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");

	if(con != null)
	{
	System.out.println("\n\n *** Connection Establishment Successfull");
	System.out.println("\n\n Conenction class : "+con.getClass());
	}else
	{
	System.out.println(" \n\n *** Connection Establishment Failed");
	}

}
	}







