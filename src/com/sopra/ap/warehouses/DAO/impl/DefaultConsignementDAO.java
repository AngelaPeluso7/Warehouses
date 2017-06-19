package com.sopra.ap.warehouses.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sopra.ap.warehouses.DAO.ConsignementDAO;
import com.sopra.ap.warehouses.models.ConsignementModel;
import com.sopra.ap.warehouses.models.StateConsignement;
import com.sopra.ap.warehouses.models.TypeProduct;

public class DefaultConsignementDAO implements ConsignementDAO {
	
	public List<ConsignementModel> findAll(){
		Connection conn=null;
		try {
			conn=connection();
			String query = "SELECT idConsignement,idWarehouse,typeProduct,state FROM Consignement ";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			final List<ConsignementModel> consignements = new ArrayList<ConsignementModel>();
			while (result.next()) {
				ConsignementModel consignement=new ConsignementModel();
				consignement.setIdConsignement(result.getInt("idConsignement"));
				consignement.setWarehouse(result.getInt("idWarehouse"));
				consignement.setTypeProduct(TypeProduct.valueOf(result.getString("typeProduct")));
				consignement.setStateConsignement(StateConsignement.valueOf(result.getString("state")));
				consignements.add(consignement);
			};
			return consignements;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	
	public ConsignementModel findById(int idConsignement){
		Connection conn = null;
		try {
			conn=connection();
			String query = "SELECT idWarehouse,typeProduct,state FROM Consignement WHERE idConsignement=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, idConsignement);
			ResultSet result = stmt.executeQuery();
			final List<ConsignementModel> consignements = new ArrayList<ConsignementModel>();
			while (result.next()) {
				ConsignementModel consignement=new ConsignementModel();
				consignement.setIdConsignement(idConsignement);
				consignement.setWarehouse(result.getInt("idWarehouse"));
				consignement.setTypeProduct(TypeProduct.valueOf(result.getString("typeProduct")));
				consignement.setStateConsignement(StateConsignement.valueOf(result.getString("state")));
				consignements.add(consignement);
			};
			return consignements.get(0);

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}
	
	public boolean newConsignement(ConsignementModel consignementModel){
		Connection conn=null;
		try {
			conn=connection();
			String insert = "INSERT INTO Consignement(idConsignement,idWarehouse,typeProduct,state) VALUES (?,?,?,?) ; ";
			PreparedStatement stmt = conn.prepareStatement(insert);
			stmt.setInt(1, consignementModel.getIdConsignement());
			stmt.setInt(2,consignementModel.getWarehouse());
			stmt.setString(3, consignementModel.getTypeProduct().toString());
			stmt.setString(4, consignementModel.getStateConsignement().toString());
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
