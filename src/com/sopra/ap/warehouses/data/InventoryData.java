package com.sopra.ap.warehouses.data;

public class InventoryData {
	private String typeProduct;
	private int idWarehouse;
	private int quantity;
	
	public InventoryData(String typeProduct, int idWarehouse, int quantity) {
		this.typeProduct = typeProduct;
		this.idWarehouse = idWarehouse;
		this.quantity = quantity;
	}

	public InventoryData() {
	}

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}

	public int getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(int idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
