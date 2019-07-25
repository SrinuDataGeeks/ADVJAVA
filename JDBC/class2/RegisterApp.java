package com.google.ex;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class RegisterApp
	{
public static void main(String args[]) throws Exception
{

	Scanner scan = new Scanner(System.in);
		System.out.println(" Please Enter ProductID ");
		int id = scan.nextInt();
		System.out.println(" Please Enter ProductName ");
		String name = scan.next();
		System.out.println(" Please Enter ProductPrice ");
		float price = scan.nextFloat();

	String sql = "Insert Into Product(PID,PNAME,PRICE) Values("+id+",'"+name+"',"+price+")";

	System.out.println( " sql : "+sql);

	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
	Statement st = con.createStatement();	
	int count = st.executeUpdate(sql);

	System.out.println(count+ "  -- Records Inserted Successfully");

	st.close();
	con.close();
}
	}












