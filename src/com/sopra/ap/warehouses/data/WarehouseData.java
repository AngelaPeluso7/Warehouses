package com.sopra.ap.warehouses.data;

public class WarehouseData {
	private int idWarehouse;
	private int maxSize;
	
	public WarehouseData(int idWarehouse, int maxSize) {
		this.idWarehouse = idWarehouse;
		this.maxSize = maxSize;
	}

	public WarehouseData() {
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
