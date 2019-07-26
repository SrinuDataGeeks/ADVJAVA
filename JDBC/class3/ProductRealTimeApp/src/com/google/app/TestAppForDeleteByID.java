package com.google.app;

import java.util.Scanner;

import com.google.dao.ProductDAO;
import com.google.dao.bean.ProductBean;
import com.google.dao.exp.DataSourceException;

public class TestAppForDeleteByID {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);		
		System.out.println(" Enter Product ID ");		
		int productId = scanner.nextInt();
		
		ProductDAO productDAO = new ProductDAO();
		
			try {
			boolean flag =	productDAO.deleteProductByID(productId);
				if(flag)
				{
					System.out.println("Product Deleted Successfully ");
				}else
				{
					System.out.println(" Invalid Product ID");
				}
			} catch (DataSourceException e) {
				
				System.out.println(e.getMessage()+ " "+e);
			}
		
		
	}
}
