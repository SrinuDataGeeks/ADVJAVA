package com.google.service;

import java.util.List;

import com.google.dao.DataSourceException;
import com.google.dao.ProductBean;
import com.google.dao.ProductDAO;

public class ProductService {

	ProductDAO dao = new ProductDAO();

	public List<ProductBean> search(String productName) throws ServicesException {
		List<ProductBean> productList = null;

		try {
			productList = dao.search(productName);
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
		}
		return productList;
	}
	
	

}
