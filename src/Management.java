
import java.util.ArrayList;
import java.util.List;

public class Management {

	public static void main(String[] args) {
		
		
		// Loading Warehouse DB
		Warehouse warehouse = new Warehouse();
		List<Warehouse> warehouses = new ArrayList<Warehouse>();
		warehouses = warehouse.getAll();

		// Loading Inventory DB
		Inventory inventory = new Inventory();
		List<Inventory> inventories = new ArrayList<Inventory>();
		inventories = inventory.getAll();
		System.out.println(warehouses);
		
		System.out.println(inventories);
		
		
	}

}
