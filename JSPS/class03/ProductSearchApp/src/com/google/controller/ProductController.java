package com.google.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.dao.ProductBean;
import com.google.service.ProductService;
import com.google.service.ServicesException;

@WebServlet(value = "/search")
public class ProductController extends HttpServlet {
	ProductService productService = new ProductService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String productName = request.getParameter("productName");

		if (productName == null || productName.trim().length() == 0) {
			request.setAttribute("productNameReq", " please specify product name");
			request.getRequestDispatcher("/search.jsp").forward(request, response);

		} else {
			try {
				List<ProductBean> productList = productService.search(productName.trim());
				if (productList == null || productList.size() == 0) {
					request.setAttribute("invalidName", " Product Details not found with the given name");
					request.getRequestDispatcher("/search.jsp").forward(request, response);
				} else {
					request.setAttribute("productList", productList);
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}
			} catch (ServicesException e) {
				response.sendRedirect("./error.jsp");
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}