package com.google.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import com.google.dao.exp.DataSourceException;

public class ProductDAO {
	
	
	public void saveProducts(List<ProductBean> productsList) throws DataSourceException
	{
		Connection con = null;
		Statement st = null;
		try
		{
			DataSource dataSource = DBUtil.getDataSource();
			con =  dataSource.getConnection();
			con.setAutoCommit(false);
			st = con.createStatement();
			for(ProductBean product : productsList)
			{
			
	   st.addBatch("Insert Into Product(PID,PNAME,PRICE)  Values ( "+product.getProductId()+", '" +product.getProductName()+"',"+product.getProductPrice() +")");
			}
			
			st.executeBatch();
			con.commit();
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
			
			
				if(st != null)
				{
					try
					{
						st.close();
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
