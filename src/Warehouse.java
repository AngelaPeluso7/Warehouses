import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Warehouse {
		private int idWarehouse;
		private int maxSize;
		
		public Warehouse(int idWarehouse, int maxSize) {
			this.idWarehouse = idWarehouse;
			this.maxSize = maxSize;
		}

		public Warehouse() {
		}
		
		public Warehouse getFromId(int idWarehouse) {
			Connection conn = null;
			try {
				conn=connection();
				String query = "SELECT idWarehouse, maxSize FROM Warehouse WHERE Warehouse.idWarehouse=?";
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1, idWarehouse);
				ResultSet result = stmt.executeQuery();
				final List<Warehouse> warehouses = new ArrayList<Warehouse>();
				while (result.next()) {
					Warehouse warehouse=new Warehouse();
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
		
		public List<Warehouse> getAll() {
			Connection conn=null;
			try {
				conn=connection();
				String query = "SELECT idWarehouse, maxSize FROM Warehouse ";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet result = stmt.executeQuery();
				final List<Warehouse> warehouses = new ArrayList<Warehouse>();
				while (result.next()) {
					Warehouse warehouse=new Warehouse();
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
		
		public int getIdWarehouse() {
			return idWarehouse;
		}
		public void setIdWarehouse(int idWarehouse) {
			this.idWarehouse = idWarehouse;
		}

		public int getMaxSize() {
			return maxSize;
		}

		public void setMaxSize(int maxSize) {
			this.maxSize = maxSize;
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
			return "Warehouse [idWarehouse=" + idWarehouse + ", maxSize=" + maxSize + "]";
		}
		
		
}
