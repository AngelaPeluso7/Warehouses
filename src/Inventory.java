import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Inventory {
	//private Warehouse warehouse;
	private TypeProduct typeProduct;
	private int idWarehouse;
	private int quantity;
	
	public Inventory(TypeProduct typeProduct, int warehouse, int quantity) {
		this.typeProduct = typeProduct;
		this.idWarehouse = warehouse;
		this.quantity = quantity;
	}
	public Inventory() {
	}
	
	public Inventory getFromType(TypeProduct typeProduct) {
		Connection conn = null;
		try {
			conn=connection();
			Inventory inventory=new Inventory();
			String query = "SELECT idWarehouse, quantity FROM Inventory WHERE Inventory.typeProduct=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, typeProduct.toString());
			ResultSet result = stmt.executeQuery();
			List<Inventory> inventories = new ArrayList<Inventory>();
			while (result.next()) {
				//inventory.setWarehouse(warehouse.getFromId(result.getInt("idWarehouse")));
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
	
	public List<Inventory> getAll() {
		Connection conn=null;
		try {
			conn=connection();
			String query = "SELECT typeProduct,idWarehouse,quantity FROM Inventory ";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			final List<Inventory> inventories = new ArrayList<Inventory>();
			while (result.next()) {
				Inventory inventory=new Inventory();
				inventory.setTypeProduct(TypeProduct.valueOf(result.getString("typeProduct")));
				//inventory.setWarehouse(warehouse.getFromId(result.getInt("idWarehouse")));
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
//	public Warehouse getWarehouse() {
//		return warehouse;
//	}
//	public void setWarehouse(Warehouse warehouse) {
//		this.warehouse = warehouse;
//	}
	public int getIdWarehouse() {
		return idWarehouse;
	}
	public void setIdWarehouse(int idWarehouse) {
		this.idWarehouse = idWarehouse;
	}
	public TypeProduct getTypeProduct() {
		return typeProduct;
	}
	public void setTypeProduct(TypeProduct typeProduct) {
		this.typeProduct = typeProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	@Override
	public String toString() {
		return "Inventory [typeProduct=" + typeProduct + ", idWarehouse=" + idWarehouse + ", quantity=" + quantity
				+ "]";
	}

}
