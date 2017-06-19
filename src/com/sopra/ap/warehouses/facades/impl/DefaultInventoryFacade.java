package com.sopra.ap.warehouses.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.sopra.ap.warehouses.data.InventoryData;
import com.sopra.ap.warehouses.facades.InventoryFacade;
import com.sopra.ap.warehouses.models.InventoryModel;
import com.sopra.ap.warehouses.models.TypeProduct;
import com.sopra.ap.warehouses.services.InventoryService;
import com.sopra.ap.warehouses.services.impl.DefaultInventoryService;

public class DefaultInventoryFacade implements InventoryFacade{

	private InventoryService inventoryService;

	public DefaultInventoryFacade(InventoryService inventoryService) {
		this.inventoryService=new DefaultInventoryService();
	}

	public DefaultInventoryFacade() {
	}
	
	public List<InventoryData> getAll() {
		List<InventoryModel> inventoriesModel = inventoryService.getAll();
		final List<InventoryData> inventoriesData = new ArrayList<InventoryData>();
		for (InventoryModel inventory : inventoriesModel) {
			final InventoryData inventoryData = new InventoryData();
			inventoryData.setTypeProduct(inventory.getTypeProduct().toString());
			inventoryData.setIdWarehouse(inventory.getIdWarehouse());
			inventoryData.setQuantity(inventory.getQuantity());
			inventoriesData.add(inventoryData);
		}
		return inventoriesData;
	}

	public InventoryData getByType(String typeProduct) {
		InventoryModel inventoryModel = inventoryService.getByType(TypeProduct.valueOf(typeProduct));
		InventoryData inventoryData = new InventoryData();
		inventoryData.setTypeProduct(inventoryModel.getTypeProduct().toString());
		inventoryData.setIdWarehouse(inventoryModel.getIdWarehouse());
		inventoryData.setQuantity(inventoryModel.getQuantity());
		return inventoryData;
	}
	
	public boolean searchProduct(String typeProduct,int idWarehouse){
		try {
			if(inventoryService.searchProduct(TypeProduct.valueOf(typeProduct), idWarehouse)){
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean decrementQuantity(String typeProduct,int idWarehouse){
		try {
			if(inventoryService.decrementQuantity(TypeProduct.valueOf(typeProduct), idWarehouse)){
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
