package com.sopra.ap.warehouses.models;

public class WarehouseModel {
	private int idWarehouse;
	private int maxSize;
	
	public WarehouseModel(int idWarehouse, int maxSize) {
		this.idWarehouse = idWarehouse;
		this.maxSize = maxSize;
	}

	public WarehouseModel() {
	}

	public int getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(int idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	
}
