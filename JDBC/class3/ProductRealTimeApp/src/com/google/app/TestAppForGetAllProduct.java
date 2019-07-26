package com.google.app;

import java.util.List;
import java.util.Scanner;

import com.google.dao.ProductDAO;
import com.google.dao.bean.ProductBean;
import com.google.dao.exp.DataSourceException;

public class TestAppForGetAllProduct {

	public static void main(String[] args) {
		
		
		
		ProductDAO productDAO = new ProductDAO();
		
			try {
			List<ProductBean> productList =	productDAO.getAll();
			
				if(productList.size() > 0)
					{
				for(ProductBean product : productList)
				{
					System.out.println(product.getProductId() + " : "+product.getProductName()+" : "+product.getProductPrice());
				}
					}else
					{
						System.out.println(" No Records found ");
					}
			} catch (DataSourceException e) {
				
				System.out.println(e.getMessage()+ " "+e);
			}
		
		
	}
}
