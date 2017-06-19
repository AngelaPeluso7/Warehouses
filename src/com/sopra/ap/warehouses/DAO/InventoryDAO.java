package com.sopra.ap.warehouses.DAO;
import java.util.List;
import com.sopra.ap.warehouses.models.InventoryModel;
import com.sopra.ap.warehouses.models.TypeProduct;

public interface InventoryDAO {
	
	public List<InventoryModel> findAll();
	
	public InventoryModel findByType(TypeProduct typeProduct);
	
	public boolean searchProduct(TypeProduct typeProduct,int idWarehouse);
	
	public boolean decrementQuantity(TypeProduct typeProduct,int idWarehouse);
}
