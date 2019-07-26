package com.google.app;

import java.util.Scanner;

import com.google.dao.ProductDAO;
import com.google.dao.bean.ProductBean;
import com.google.dao.exp.DataSourceException;

public class TestAppForSelectByProductID {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);		
		System.out.println(" Enter Product ID ");		
		int productId = scanner.nextInt();
		
		ProductDAO productDAO = new ProductDAO();
		
			try {
			ProductBean product =	productDAO.getProductByID(productId);
				if(product != null)
				{
					System.out.println(product.getProductId() + " : "+product.getProductName()+" : "+product.getProductPrice());
				}else
				{
					System.out.println(" Invalid Product ID");
				}
			} catch (DataSourceException e) {
				
				System.out.println(e.getMessage()+ " "+e);
			}
		
		
	}
}
