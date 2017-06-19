package com.sopra.ap.warehouses.controllers;

import java.util.ArrayList;
import java.util.List;

import com.sopra.ap.warehouses.data.InventoryData;
import com.sopra.ap.warehouses.facades.InventoryFacade;
import com.sopra.ap.warehouses.facades.impl.DefaultInventoryFacade;

public class InventoryController {
	private InventoryFacade inventoryFacade;
	private InventoryData inventoryData;
	
	public InventoryController() {
		this.inventoryFacade=new DefaultInventoryFacade();
		this.inventoryData=new InventoryData();
	}

	public String showInventories(){
		final List<InventoryData> inventories=inventoryFacade.getAll();
		ArrayList<String> inventoriesToString = new ArrayList<String>();
		String print = "";
		for (InventoryData i: inventories){
			print=print + inventoriesToString.add(i.toString());
		}
		return print;
	}
	
	public List<InventoryData> getAll(){
		return inventoryFacade.getAll();
	}
	
	public String showInventory(String typeProduct){
		final InventoryData inventory=inventoryFacade.getByType(typeProduct);
		return inventory.toString();
	}
	public InventoryData getByType(String typeProduct){
		return inventoryFacade.getByType(typeProduct);
	}
	
	public boolean searchProduct(String typeProduct,int idWarehouse){
		return inventoryFacade.searchProduct(typeProduct, idWarehouse);
	}
	
	public String searchProductShow(String typeProduct,int idWarehouse){
		if(inventoryFacade.searchProduct(typeProduct, idWarehouse)){
			return "Il prodotto "+typeProduct+" è presente nella Warehouse "+idWarehouse;
		}
		return "Il prodotto "+typeProduct+" NON è presente nella Warehouse "+idWarehouse;
	}
	
	public boolean decrementQuantity(String typeProduct,int idWarehouse){
		return inventoryFacade.decrementQuantity(typeProduct, idWarehouse);
	}
	public String decrementQuantityShow(String typeProduct,int idWarehouse){
		if(inventoryFacade.decrementQuantity(typeProduct, idWarehouse)){
			return "Il prodotto "+typeProduct+" è stato decrementato nell'inventario del warehouse "+idWarehouse;
		}
		return "Il prodotto "+typeProduct+" NON è stato decrementato nell'inventario del warehouse "+idWarehouse;
	}

	public InventoryFacade getInventoryFacade() {
		return inventoryFacade;
	}

	public void setInventoryFacade(InventoryFacade inventoryFacade) {
		this.inventoryFacade = inventoryFacade;
	}

	public InventoryData getInventoryData() {
		return inventoryData;
	}

	public void setInventoryData(InventoryData inventoryData) {
		this.inventoryData = inventoryData;
	}
	
}
