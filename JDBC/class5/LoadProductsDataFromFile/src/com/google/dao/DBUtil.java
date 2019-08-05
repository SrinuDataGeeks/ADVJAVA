package com.google.dao;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	
	private static final BasicDataSource DATA_SOURCE;
	
	static
	{
		Properties props = new Properties();
		try
		{
			FileInputStream fin = new  FileInputStream(".\\src\\dbinfo.properties");
			props.load(fin);
		}catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
		synchronized (DBUtil.class) {
			
			DATA_SOURCE = new BasicDataSource();
			DATA_SOURCE.setUsername(props.getProperty("username"));
			DATA_SOURCE.setPassword(props.getProperty("password"));
			DATA_SOURCE.setUrl(props.getProperty("url"));
			DATA_SOURCE.setDriverClassName(props.getProperty("classname"));
			
			
		}
	}

	public static DataSource getDataSource()
	{
		return DATA_SOURCE;
	}
}
