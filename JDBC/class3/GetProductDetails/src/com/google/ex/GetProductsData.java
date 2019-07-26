package com.google.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetProductsData {

	public static void main(String[] args) throws Exception{
		
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			String sql = "Select PID ,PNAME ,PRICE From Product";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
		ResultSet rs	= ps.executeQuery();
		
			while(rs.next())
			{
				System.out.println(rs.getInt("PID")+" : "+rs.getString("PNAME")+" : "+rs.getFloat("PRICE"));
			}
		rs.close();
		ps.close();
		con.close();
	}
	
}
