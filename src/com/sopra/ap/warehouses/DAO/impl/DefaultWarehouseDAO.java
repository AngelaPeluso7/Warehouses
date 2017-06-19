package com.sopra.ap.warehouses.DAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sopra.ap.warehouses.DAO.WarehouseDAO;
import com.sopra.ap.warehouses.models.WarehouseModel;

public class DefaultWarehouseDAO implements WarehouseDAO{
	
	public DefaultWarehouseDAO() {
	}

	public List<WarehouseModel> findAll(){
		Connection conn=null;
		try {
			conn=connection();
			String query = "SELECT idWarehouse, maxSize FROM Warehouse ";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			List<WarehouseModel> warehouses = new ArrayList<WarehouseModel>();
			while (result.next()) {
				WarehouseModel warehouse=new WarehouseModel();
				warehouse.setIdWarehouse(result.getInt("idWarehouse"));
				warehouse.setMaxSize(result.getInt("maxSize"));
				warehouses.add(warehouse);
			};
			return warehouses;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	
	public WarehouseModel findById(int idWarehouse){
		Connection conn = null;
		try {
			conn=connection();
			String query = "SELECT idWarehouse, maxSize FROM Warehouse WHERE Warehouse.idWarehouse=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, idWarehouse);
			ResultSet result = stmt.executeQuery();
			final List<WarehouseModel> warehouses = new ArrayList<WarehouseModel>();
			while (result.next()) {
				WarehouseModel warehouse=new WarehouseModel();
				warehouse.setIdWarehouse(idWarehouse);
				warehouse.setMaxSize(result.getInt("maxSize"));
				warehouses.add(warehouse);
			};
			return warehouses.get(0);

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
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
