package com.sopra.ap.warehouses.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sopra.ap.warehouses.DAO.OrderDAO;
import com.sopra.ap.warehouses.models.OrderModel;
import com.sopra.ap.warehouses.models.TypeProduct;

public class DefaultOrderDAO implements OrderDAO{
	public List<OrderModel> findAll(){
		Connection conn=null;
		try {
			conn=connection();
			String query = "SELECT idOrder,typeProduct1,idConsignement1,typeProduct2,idConsignement2 FROM Orders ";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			final List<OrderModel> orders = new ArrayList<OrderModel>();
			while (result.next()) {
				OrderModel order=new OrderModel();
				order.setIdOrder(result.getInt("idOrder"));
				order.setTypeProduct1(TypeProduct.valueOf(result.getString("typeProduct1")));
				order.setConsignement1(result.getInt("idConsignement1"));
				order.setTypeProduct2(TypeProduct.valueOf(result.getString("typeProduct2")));
				order.setConsignement2(result.getInt("idConsignement2"));
				orders.add(order);
			};
			return orders;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	

	
	public OrderModel findById(int idOrder){
		Connection conn = null;
		try {
			conn=connection();
			String query = "SELECT typeProduct1,idConsignement1,typeProduct2,idConsignement2 FROM Orders WHERE idOrder=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, idOrder);
			ResultSet result = stmt.executeQuery();
			final List<OrderModel> orders = new ArrayList<OrderModel>();
			while (result.next()) {
				OrderModel order=new OrderModel();
				order.setIdOrder(idOrder);
				order.setTypeProduct1(TypeProduct.valueOf(result.getString("typeProduct1")));
				order.setConsignement1(result.getInt("idConsignement1"));
				order.setTypeProduct2(TypeProduct.valueOf(result.getString("typeProduct2")));
				order.setConsignement2(result.getInt("idConsignement2"));
				orders.add(order);
			};
			return orders.get(0);

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	
	public boolean newOrder(OrderModel orderModel){
		Connection conn=null;
		try {
			conn=connection();
			String insert = "INSERT INTO Orders(idOrder,typeProduct1,idConsignement1,"
					+ "typeProduct2,idConsignement2) VALUES (?,?,?,?,?) ; ";
			PreparedStatement stmt = conn.prepareStatement(insert);
			stmt.setInt(1, orderModel.getIdOrder());
			stmt.setString(2,orderModel.getTypeProduct1().toString());
			stmt.setInt(3, orderModel.getConsignement1());
			stmt.setString(4, orderModel.getTypeProduct2().toString());
			stmt.setInt(5,orderModel.getConsignement2());
			if (stmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return false;
		
	}

	public static Connection connection(){
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/Warehouses");
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
