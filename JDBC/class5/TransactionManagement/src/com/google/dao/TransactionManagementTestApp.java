package com.google.dao;

import com.google.dao.exp.DataSourceException;

public class TransactionManagementTestApp {

	public static void main(String[] args) {
		
		AccountHolderDAO dao = new AccountHolderDAO();
		
		try
		{
			boolean flag = dao.transfer(1242, 1250, 500f);
			if(flag )
			{
				System.out.println( " Transaction Successfull");
			}else
			{
				System.out.println( " Transaction Failed");
			}
		}catch(DataSourceException exp)
		{
			System.out.println(exp);
		}
	}
}
