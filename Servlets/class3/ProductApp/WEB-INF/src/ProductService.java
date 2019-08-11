package com.google.service;
import com.google.dao.exp.DataSourceException;
import com.google.dao.ProductDAO;
import com.google.dao.bean.ProductBean;
import com.google.service.exp.ServicesException;


public class ProductService{

	public ProductBean getProductById(Integer productId) throws ServicesException
	{
		ProductBean product = null;
		
	ProductDAO  dao = new ProductDAO();
	try
	{
	product  = dao.getProductById(productId);
	}catch(DataSourceException exp)
	{
	exp.printStackTrace();
	throw new  ServicesException(exp.getMessage());
	}
		return product;
	}
	
	
}
