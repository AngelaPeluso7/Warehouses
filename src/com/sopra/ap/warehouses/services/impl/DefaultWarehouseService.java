package com.sopra.ap.warehouses.services.impl;
import java.util.List;
import com.sopra.ap.warehouses.DAO.WarehouseDAO;
import com.sopra.ap.warehouses.DAO.impl.DefaultWarehouseDAO;
import com.sopra.ap.warehouses.models.WarehouseModel;
import com.sopra.ap.warehouses.services.WarehouseService;

public class DefaultWarehouseService implements WarehouseService{
	private WarehouseDAO warehouseDAO;

	public DefaultWarehouseService() {
		this.warehouseDAO=new DefaultWarehouseDAO();
	}

	public List<WarehouseModel> getAll(){
		return warehouseDAO.findAll();
	}
	
	public WarehouseModel getById(int idWarehouse){
		return warehouseDAO.findById(idWarehouse);
	}
}
