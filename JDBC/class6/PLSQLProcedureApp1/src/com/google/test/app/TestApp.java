package com.google.test.app;

import com.google.dao.ProductDAO;
import com.google.dao.bean.ProductBean;
import com.google.dao.exp.DataSourceException;

public class TestApp {
	
	public static void main(String[] args) {
		
		ProductDAO productDAO = new ProductDAO();
		
		try {
		
			System.out.println(" \n\n CASE 1 : getProductNameWithProcedure");
		String name =	productDAO.getProductNameWithProcedure(55);
		System.out.println(" NAME "+name);
		
		System.out.println(" \n\n CASE 2 : getProductDataWithProcedure");
		
		ProductBean product = productDAO.getProductDataWithProcedure(555);
		
		System.out.println(product);
		
		} catch (DataSourceException e) {
			e.printStackTrace();
		}
	}

}
