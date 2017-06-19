package com.sopra.ap.warehouses.services.impl;

import java.util.List;

import com.sopra.ap.warehouses.DAO.InventoryDAO;
import com.sopra.ap.warehouses.DAO.impl.DefaultInventoryDAO;
import com.sopra.ap.warehouses.models.InventoryModel;
import com.sopra.ap.warehouses.models.TypeProduct;
import com.sopra.ap.warehouses.services.InventoryService;

public class DefaultInventoryService implements InventoryService{
	
	private InventoryDAO inventoryDAO;
	
	public DefaultInventoryService(InventoryDAO inventoryDAO) {
		this.inventoryDAO=new DefaultInventoryDAO();
	}
	
	public DefaultInventoryService() {
	}
	
	public List<InventoryModel> getAll(){
		return inventoryDAO.findAll();
	}
	
	public InventoryModel  getByType(TypeProduct typeProduct){
		return inventoryDAO.findByType(typeProduct);
	}
	
	public boolean searchProduct(TypeProduct typeProduct,int idWarehouse){
		return inventoryDAO.searchProduct(typeProduct, idWarehouse);
	}
	
	public boolean decrementQuantity(TypeProduct typeProduct,int idWarehouse){
		return inventoryDAO.searchProduct(typeProduct, idWarehouse);
	}
}
