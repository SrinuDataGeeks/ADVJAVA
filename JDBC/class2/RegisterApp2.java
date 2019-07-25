package com.google.ex;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RegisterApp2
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

	String sql = "Insert Into Product(PID,PNAME,PRICE) Values(?,?,?)";


	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1,id);
	ps.setString(2,name);
	ps.setFloat(3,price);	
	int count = ps.executeUpdate();

	System.out.println(count+ "  -- Records Inserted Successfully");

	ps.close();
	con.close();
}
	}












