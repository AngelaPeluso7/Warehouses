package com.sopra.ap.warehouses.controllers;

import java.util.ArrayList;
import java.util.List;

import com.sopra.ap.warehouses.data.WarehouseData;
import com.sopra.ap.warehouses.facades.WarehouseFacade;
import com.sopra.ap.warehouses.facades.impl.DefaultWarehouseFacade;

public class WarehouseController {
	private WarehouseFacade warehouseFacade;
	private WarehouseData warehouseData;
	
	public WarehouseController() {
		this.warehouseFacade=new DefaultWarehouseFacade();
		this.warehouseData=new WarehouseData();
	}

	public String showWarehouses(){
		final List<WarehouseData> warehouses=warehouseFacade.getAll();
		ArrayList<String> warehousesToString = new ArrayList<String>();
		String print = "";
		for (WarehouseData w: warehouses){
			print=print + warehousesToString.add(w.toString());
		}
		return print;
	}
	
	public List<WarehouseData> getAll(){
		return warehouseFacade.getAll();
	}
	
	public String showWarehouse(int idWarehouse){
		final WarehouseData warehouse=warehouseFacade.getById(idWarehouse);
		return warehouse.toString();
	}
	public WarehouseData getById(int idWarehouse){
		return warehouseFacade.getById(idWarehouse);
	}
	
	public WarehouseFacade getWarehouseFacade() {
		return warehouseFacade;
	}
	public void setWarehouseFacade(WarehouseFacade warehouseFacade) {
		this.warehouseFacade = warehouseFacade;
	}
	public WarehouseData getWarehouseData() {
		return warehouseData;
	}
	public void setWarehouseData(WarehouseData warehouseData) {
		this.warehouseData = warehouseData;
	}
	
}
