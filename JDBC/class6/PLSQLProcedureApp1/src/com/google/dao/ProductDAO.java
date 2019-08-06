package com.google.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.google.dao.bean.ProductBean;
import com.google.dao.exp.DataSourceException;

public class ProductDAO {

	
	
	public String getProductNameWithProcedure(Integer productId) throws DataSourceException
	{
		String name = null;
		Connection con = null;
		CallableStatement clbst = null;
		
		try
		{
			DataSource dataSource = DataSourceUtil.getDataSource();
			con = dataSource.getConnection();
			clbst = con.prepareCall("{ call getProductName(?,?) }");
			clbst.setInt(1,productId);
			clbst.registerOutParameter(2, Types.VARCHAR);
			clbst.execute();
			name = clbst.getString(2);
		}catch(SQLException exp)
		{
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}
		finally {
			
				if(clbst != null)
				{
					try
					{
						clbst.close();
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
		
		return name;
	}
	
	
	public ProductBean getProductDataWithProcedure(Integer productId) throws DataSourceException
	{
		ProductBean product = null;
		Connection con = null;
		CallableStatement clbst = null;
		
		try
		{
			DataSource dataSource = DataSourceUtil.getDataSource();
			con = dataSource.getConnection();
			clbst = con.prepareCall("{ call getProductData(?,?,?) }");
			clbst.setInt(1,productId);
			clbst.registerOutParameter(2, Types.VARCHAR);
			clbst.registerOutParameter(3, Types.FLOAT);
			clbst.execute();
			String name = clbst.getString(2);
			float price = clbst.getFloat(3);
			
			product = new ProductBean(productId, name, price);
			
		}catch(SQLException exp)
		{
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}
		finally {
			
				if(clbst != null)
				{
					try
					{
						clbst.close();
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
		
		return product;
	}
}
