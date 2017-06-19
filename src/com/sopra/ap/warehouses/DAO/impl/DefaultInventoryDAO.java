package com.sopra.ap.warehouses.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sopra.ap.warehouses.DAO.InventoryDAO;
import com.sopra.ap.warehouses.models.InventoryModel;
import com.sopra.ap.warehouses.models.TypeProduct;

public class DefaultInventoryDAO implements InventoryDAO {

	public List<InventoryModel> findAll(){
		Connection conn=null;
		try {
			conn=connection();
			String query = "SELECT typeProduct,idWarehouse,quantity FROM Inventory ";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			final List<InventoryModel> inventories = new ArrayList<InventoryModel>();
			while (result.next()) {
				InventoryModel inventory=new InventoryModel();
				inventory.setTypeProduct(TypeProduct.valueOf(result.getString("typeProduct")));
				inventory.setIdWarehouse(result.getInt("idWarehouse"));
				inventory.setQuantity(result.getInt("quantity"));
				inventories.add(inventory);
			};
			return inventories;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	public InventoryModel findByType(TypeProduct typeProduct) {
		Connection conn = null;
		try {
			conn = connection();
			InventoryModel inventory = new InventoryModel();
			String query = "SELECT idWarehouse, quantity FROM Inventory WHERE Inventory.typeProduct=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, typeProduct.toString());
			ResultSet result = stmt.executeQuery();
			List<InventoryModel> inventories = new ArrayList<InventoryModel>();
			while (result.next()) {
				inventory.setIdWarehouse(result.getInt("idWarehouse"));
				inventory.setQuantity(result.getInt("quantity"));
				inventory.setTypeProduct(typeProduct);
				inventories.add(inventory);
			}
			return inventories.get(0);

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	public boolean searchProduct(TypeProduct typeProduct,int idWarehouse) {
		Connection conn = null;
		try {
			conn = connection();
			String query = "SELECT quantity FROM Inventory WHERE (Inventory.typeProduct=? AND Inventory.idWarehouse=?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, typeProduct.toString());
			stmt.setInt(2, idWarehouse);
			stmt.executeQuery();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return false;
	}
	
	public boolean decrementQuantity(TypeProduct typeProduct,int idWarehouse){
		Connection conn=null;
		try {
			conn=connection();
			String insert = "UPDATE Inventory SET Inventory.quantity=Inventory.quantity-1 "
					+ "WHERE Inventory.idWarehouse=? AND Inventory.typeProduct=?; ";
			PreparedStatement stmt = conn.prepareStatement(insert);
			stmt.setString(1, typeProduct.toString());
			stmt.setString(2, Integer.toString(idWarehouse));
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
