package com.sopra.ap.warehouses.models;

public class InventoryModel {
	private TypeProduct typeProduct;
	private int idWarehouse;
	private int quantity;
	
	public InventoryModel(TypeProduct typeProduct, int idWarehouse, int quantity) {
		this.typeProduct = typeProduct;
		this.idWarehouse = idWarehouse;
		this.quantity = quantity;
	}

	public InventoryModel() {
	}

	public TypeProduct getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(TypeProduct typeProduct) {
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
