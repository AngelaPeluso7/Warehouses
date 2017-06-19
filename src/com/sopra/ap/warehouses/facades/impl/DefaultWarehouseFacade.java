package com.sopra.ap.warehouses.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.sopra.ap.warehouses.data.WarehouseData;
import com.sopra.ap.warehouses.facades.WarehouseFacade;
import com.sopra.ap.warehouses.models.WarehouseModel;
import com.sopra.ap.warehouses.services.WarehouseService;
import com.sopra.ap.warehouses.services.impl.DefaultWarehouseService;

public class DefaultWarehouseFacade implements WarehouseFacade{
	
	private WarehouseService warehouseService;
	
	public DefaultWarehouseFacade(WarehouseService warehouseService) {
		this.warehouseService=new DefaultWarehouseService();
	}

	public DefaultWarehouseFacade() {
	}

	public List<WarehouseData> getAll(){
		List<WarehouseModel> warehousesModel = warehouseService.getAll();
        List<WarehouseData> warehousesData = new ArrayList<WarehouseData>();
        for (WarehouseModel warehouse : warehousesModel) {
            WarehouseData warehouseData = new WarehouseData();
			warehouseData.setIdWarehouse(warehouse.getIdWarehouse());
            warehouseData.setMaxSize(warehouse.getMaxSize());
            warehousesData.add(warehouseData);
        }
        return warehousesData;
	}
	
	public WarehouseData getById(int idWarehouse){
		WarehouseModel warehouseModel = warehouseService.getById(idWarehouse);
        WarehouseData warehouseData = new WarehouseData();
		warehouseData.setIdWarehouse(warehouseModel.getIdWarehouse());
        warehouseData.setMaxSize(warehouseModel.getMaxSize());
        return warehouseData;
	}
}
