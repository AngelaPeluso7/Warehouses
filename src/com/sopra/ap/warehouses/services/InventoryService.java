package com.sopra.ap.warehouses.services;

import java.util.List;

import com.sopra.ap.warehouses.models.InventoryModel;
import com.sopra.ap.warehouses.models.TypeProduct;

public interface InventoryService {

	public List<InventoryModel> getAll();
	
	public InventoryModel getByType(TypeProduct typeProduct);
	
	public boolean searchProduct(TypeProduct typeProduct,int idWarehouse);
	
	public boolean decrementQuantity(TypeProduct typeProduct,int idWarehouse);
}
