package com.google.dao;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestCaseForSaveProduct {

	public static void main(String[] args) throws Exception {
		
		ProductDAO dao = new ProductDAO();
		
		FileReader fin = new  FileReader(".\\src\\productsInfo.txt");
		BufferedReader buffIn = new BufferedReader(fin);
		
		List<ProductBean> productList = new ArrayList<ProductBean>();
			
			while(  buffIn.read() != -1)
			{
				String line = buffIn.readLine();
				
				String[] strArr = line.split(",");
				
				int productId =  Integer.valueOf(strArr[0]);
				String productName = strArr[1];
				Float productPrice = Float.valueOf(strArr[2]);
				
				ProductBean product = new ProductBean(productId, productName, productPrice);
				productList.add(product);
				
			}
			
			for(ProductBean product : productList)
			{
				dao.saveProduct(product);
			}
			System.out.println(" save Sucessfull");

	}
}
