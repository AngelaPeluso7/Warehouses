package com.sopra.ap.warehouses.services;

import java.util.List;

import com.sopra.ap.warehouses.models.WarehouseModel;

public interface WarehouseService {
	
	public List<WarehouseModel> getAll();
	
	public WarehouseModel getById(int idWarehouse);
}
