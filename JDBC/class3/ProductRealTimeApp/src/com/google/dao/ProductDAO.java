package com.google.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.dao.bean.ProductBean;
import com.google.dao.exp.DataSourceException;

public class ProductDAO {

	public ProductBean getProductByID(Integer productId) throws DataSourceException {
		ProductBean product = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			String sql = "Select PID ,PNAME ,PRICE From Product Where PID = ?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, productId);

			rs = ps.executeQuery();

			if (rs.next()) {
				product = new ProductBean();
				product.setProductId(rs.getInt("PID"));
				product.setProductName(rs.getString("PNAME"));
				product.setProductPrice(rs.getFloat("PRICE"));
			}

		} catch (SQLException exp) {
			// exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} catch (Exception exp) {
			throw new DataSourceException(exp.getMessage());
		}

		finally {

			try {
					if(rs != null)				
						rs.close();
					
					if(ps != null)
						ps.close();
					
					if(con != null)
						con.close();
			} catch (SQLException exp) {
				// exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
			}
		}
		return product;

	}
	
	
	public boolean deleteProductByID(Integer productId) throws DataSourceException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			String sql = "Delete from  Product Where PID = ?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, productId);

			int count = ps.executeUpdate();

			if (count > 0) {
				flag = true;
			}

		} catch (SQLException exp) {
			// exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} catch (Exception exp) {
			throw new DataSourceException(exp.getMessage());
		}

		finally {

			try {
					
					if(ps != null)
						ps.close();
					
					if(con != null)
						con.close();
			} catch (SQLException exp) {
				// exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
			}
		}
		
		return flag;
	}
	
	
	public boolean saveProduct(ProductBean product) throws DataSourceException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			String sql = "Insert Into Product(PID ,PNAME,PRICE) Values ( ? , ? , ?)";

			ps = con.prepareStatement(sql);
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setFloat(3, product.getProductPrice());

			int count = ps.executeUpdate();

			if (count > 0) {
				flag = true;
			}

		} catch (SQLException exp) {
			 exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} catch (Exception exp) {
			throw new DataSourceException(exp.getMessage());
		}

		finally {

			try {
					
					if(ps != null)
						ps.close();
					
					if(con != null)
						con.close();
			} catch (SQLException exp) {
				// exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
			}
		}
		
		return flag;
	}
	
	
	public List<ProductBean> getAll() throws DataSourceException {
		 List<ProductBean> productList = new ArrayList<ProductBean>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			String sql = "Select PID ,PNAME ,PRICE From Product ";

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				ProductBean product = new ProductBean();
				product.setProductId(rs.getInt("PID"));
				product.setProductName(rs.getString("PNAME"));
				product.setProductPrice(rs.getFloat("PRICE"));
				productList.add(product);
			}

		} catch (SQLException exp) {
			// exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} catch (Exception exp) {
			throw new DataSourceException(exp.getMessage());
		}

		finally {

			try {
					if(rs != null)				
						rs.close();
					
					if(ps != null)
						ps.close();
					
					if(con != null)
						con.close();
			} catch (SQLException exp) {
				// exp.printStackTrace();
				throw new DataSourceException(exp.getMessage());
			}
		}
		return productList;

	}
	
}
