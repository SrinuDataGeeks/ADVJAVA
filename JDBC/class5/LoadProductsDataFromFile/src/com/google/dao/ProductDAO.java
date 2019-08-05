package com.google.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.google.dao.exp.DataSourceException;

public class ProductDAO {
	
	
	public void saveProduct(ProductBean product) throws DataSourceException
	{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "Insert Into Product(PID,PNAME,PRICE) Values ( ? , ? , ?)";
		try
		{
			DataSource dataSource = DBUtil.getDataSource();
			con =  dataSource.getConnection();
			
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, product.getProductId());
			ps.setString(2,product.getProductName());
			ps.setFloat(3, product.getProductPrice());
			
			
			ps.executeUpdate();
		}catch(SQLException exp)
		{
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		//	exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}
		
		finally {
			
			
				if(ps != null)
				{
					try
					{
						ps.close();
					}catch(SQLException exp)
					{
						exp.printStackTrace();
						throw new DataSourceException(exp.getMessage());
					}
				}
				
				if(con != null)
				{
					try
					{
						con.close();
					}catch(SQLException exp)
					{
						exp.printStackTrace();
						throw new DataSourceException(exp.getMessage());
					}
				}
		}
		
		
	}
}
