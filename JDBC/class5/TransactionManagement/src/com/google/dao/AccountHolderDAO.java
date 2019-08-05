package com.google.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.google.dao.exp.DataSourceException;

public class AccountHolderDAO {
	
	
	public boolean transfer(Integer srcAccNo , Integer destAccNo , Float amount) throws DataSourceException
	{
		boolean flag = false;
		Connection con = null;
		PreparedStatement srcps = null;
		PreparedStatement destps = null;
		String srcSQL = "Update AccountHolder Set AccountBalance = AccountBalance + ? Where ACCNo = ?";
	   String destSQL = "Update AccountHolder Set AccountBalance = AccountBalance - ? Where ACCNo = ?";
		try
		{
			DataSource dataSource = DBUtil.getDataSource();
			con =  dataSource.getConnection();
			
			con.setAutoCommit(false); //Starting Transaction
			
			srcps = con.prepareStatement(srcSQL);
			srcps.setFloat(1, amount);
			srcps.setInt(2, srcAccNo);
			
			destps = con.prepareStatement(destSQL);
			destps.setFloat(1, amount);
			destps.setInt(2, destAccNo);
			
			int count1 = srcps.executeUpdate();
			int count2 = destps.executeUpdate();
			
			if(count1 > 0 && count2 > 0)
			{
			flag = true;
			con.commit();
			}
			else
			{
				con.rollback();
			}
			
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
			
				if(srcps != null)
				{
					try
					{
						srcps.close();
					}catch(SQLException exp)
					{
						exp.printStackTrace();
						throw new DataSourceException(exp.getMessage());
					}
				}
				
				if(destps != null)
				{
					try
					{
						destps.close();
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
		
		
		return flag;
	}
}
