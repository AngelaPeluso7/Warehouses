package com.sopra.ap.warehouses.data;

public class ConsignementData {
	private int idConsignement;
	private int warehouse;
	private String typeProduct;
	private String stateConsignement;
	
	public ConsignementData(int idConsignement, int warehouse, String typeProduct, String stateConsignement) {
		this.idConsignement = idConsignement;
		this.warehouse = warehouse;
		this.typeProduct = typeProduct;
		this.stateConsignement = stateConsignement;
	}
	
	public ConsignementData() {
	}

	public int getIdConsignement() {
		return idConsignement;
	}

	public void setIdConsignement(int idConsignement) {
		this.idConsignement = idConsignement;
	}

	public int getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(int warehouse) {
		this.warehouse = warehouse;
	}

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}

	public String getStateConsignement() {
		return stateConsignement;
	}

	public void setStateConsignement(String stateConsignement) {
		this.stateConsignement = stateConsignement;
	}
	
}
