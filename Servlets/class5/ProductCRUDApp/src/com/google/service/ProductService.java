package com.google.service;

import com.google.dao.exp.DataSourceException;
import com.google.dao.ProductDAO;
import com.google.dao.bean.ProductBean;
import com.google.service.exp.ServicesException;

public class ProductService {

	ProductDAO dao = new ProductDAO();

	public ProductBean getProductById(Integer productId) throws ServicesException {
		ProductBean product = null;

		try {
			product = dao.getProductById(productId);
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
		}
		return product;
	}

	public boolean save(ProductBean product) throws ServicesException {
		boolean flag = false;

		try {
			flag = dao.save(product);
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
		}
		return flag;
	}

	public boolean deleteProductById(Integer productId) throws ServicesException {
		boolean flag = false;

		try {
			flag = dao.deleteProductById(productId);
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
		}
		return flag;
	}

}
