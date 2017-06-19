package com.sopra.ap.warehouses.facades;

import java.util.List;

import com.sopra.ap.warehouses.data.WarehouseData;

public interface WarehouseFacade {
	
	public List<WarehouseData> getAll();
	
	public WarehouseData getById(int idWarehouse);
}
