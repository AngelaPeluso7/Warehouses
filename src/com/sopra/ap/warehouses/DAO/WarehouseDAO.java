package com.sopra.ap.warehouses.DAO;

import java.util.List;

import com.sopra.ap.warehouses.models.WarehouseModel;

public interface WarehouseDAO {
	
	public List<WarehouseModel> findAll();
	
	public WarehouseModel findById(int idWarehouse);
	
}
