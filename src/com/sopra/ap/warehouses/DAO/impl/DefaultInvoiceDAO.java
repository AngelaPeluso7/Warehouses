package com.sopra.ap.warehouses.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sopra.ap.warehouses.DAO.InvoiceDAO;
import com.sopra.ap.warehouses.models.InvoiceModel;
import com.sopra.ap.warehouses.models.StateOrder;

public class DefaultInvoiceDAO implements InvoiceDAO {

	public List<InvoiceModel> findAll() {
		Connection conn=null;
		try {
			conn=connection();
			String query = "SELECT idInvoice,idOrder,state FROM Invoice ";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			final List<InvoiceModel> invoices = new ArrayList<InvoiceModel>();
			while (result.next()) {
				InvoiceModel invoice=new InvoiceModel();
				invoice.setIdInvoice(result.getInt("idInvoice"));
				invoice.setOrder(result.getInt("idOrder"));
				invoice.setStateOrder(StateOrder.valueOf(result.getString("state")));
				invoices.add(invoice);
			};
			return invoices;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	public InvoiceModel findById(int idInvoice) {
		Connection conn = null;
		try {
			conn=connection();
			String query = "SELECT idInvoice,idOrder,state FROM Invoice WHERE idInvoice=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, idInvoice);
			ResultSet result = stmt.executeQuery();
			final List<InvoiceModel> invoices = new ArrayList<InvoiceModel>();
			while (result.next()) {
				InvoiceModel invoice=new InvoiceModel();
				invoice.setIdInvoice(idInvoice);
				invoice.setOrder(result.getInt("idOrder"));
				invoice.setStateOrder(StateOrder.valueOf(result.getString("state")));
				invoices.add(invoice);
			};
			return invoices.get(0);

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return null;
	}

	public boolean newInvoice(InvoiceModel invoiceModel) {
		Connection conn=null;
		try {
			conn=connection();
			String insert = "INSERT INTO Invoice(idInvoice,idOrder,state) VALUES (?,?,?) ; ";
			PreparedStatement stmt = conn.prepareStatement(insert);
			stmt.setInt(1, invoiceModel.getIdInvoice());
			stmt.setInt(2,invoiceModel.getOrder());
			stmt.setString(3, invoiceModel.getStateOrder().toString());
			
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
