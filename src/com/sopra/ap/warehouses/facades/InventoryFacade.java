package com.sopra.ap.warehouses.facades;

import java.util.List;

import com.sopra.ap.warehouses.data.InventoryData;

public interface InventoryFacade {
	
	public List<InventoryData> getAll();
	
	public InventoryData getByType(String typeProduct);
	
	public boolean searchProduct(String typeProduct,int idWarehouse);
	
	public boolean decrementQuantity(String typeProduct,int idWarehouse);
}
