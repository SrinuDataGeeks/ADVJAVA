package com.google.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateProductByID {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
		String sql = "Update Product Set Price = Price - ? Where Pid  = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setFloat(1, 2500f);
		ps.setInt(2, 111);
		
		int count = ps.executeUpdate();
		if(count > 0)
		{
			System.out.println(count +" Records Updated Successfully");
		}else {
			System.out.println(" Invalid Product ID");
		}
		
	}
}
