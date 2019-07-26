package com.google.app;

import java.util.Scanner;

import com.google.dao.ProductDAO;
import com.google.dao.bean.ProductBean;
import com.google.dao.exp.DataSourceException;

public class TestAppForSaveProduct {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);		
		System.out.println(" Enter Product ID ");		
		int productId = scanner.nextInt();
		
		System.out.println(" Enter Product Name ");		
		String productName = scanner.next();
		
		System.out.println(" Enter Product Price ");		
		Float productPrice = scanner.nextFloat();
		
		ProductBean productBean = new ProductBean(productId, productName, productPrice);
		
		ProductDAO productDAO = new ProductDAO();
		
			try {
			boolean flag =	productDAO.saveProduct(productBean);
				if(flag)
				{
					System.out.println("Product Saved Successfully ");
				}else
				{
					System.out.println(" Please check the logs !!! Insertion Failed");
				}
			} catch (DataSourceException e) {
				e.printStackTrace();
				System.out.println(e.getMessage()+ " "+e);
			}
		
		
	}
}
