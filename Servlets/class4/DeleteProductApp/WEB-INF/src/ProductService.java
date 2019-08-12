package com.google.service;
import com.google.dao.exp.DataSourceException;
import com.google.dao.ProductDAO;
import com.google.dao.bean.ProductBean;
import com.google.service.exp.ServicesException;


public class ProductService{

	public boolean deleteProductById(Integer productId) throws ServicesException
	{
		boolean flag = false;
		
	ProductDAO  dao = new ProductDAO();
	try
	{
	flag  = dao.deleteProductById(productId);
	}catch(DataSourceException exp)
	{
	exp.printStackTrace();
	throw new  ServicesException(exp.getMessage());
	}
		return flag;
	}
	
	
}
