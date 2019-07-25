package com.google.ex;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;

public class SearchProductsByName
	{
public static void main(String args[]) throws Exception
{

		Scanner scan = new Scanner(System.in);
		System.out.println(" Please Enter ProductName ");
		String name = scan.next();
		

String sql = "Select PID ,PNAME,PRICE From Product where upper(PNAME) like ?";


	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1,"%"+name.trim().toUpperCase()+"%");
	
	ResultSet rs = ps.executeQuery();
	boolean flag = false;

		while(rs.next())
		{
		flag = true;
		  System.out.println(rs.getInt("PID")+" : "+rs.getString("PNAME")+" : "+rs.getFloat("PRICE"));	
		}
		
		if(flag == false)
		{
	System.out.println(" *** No ResultsFound with ProductName");
		}
	
	rs.close();
	ps.close();
	con.close();
}
	}












