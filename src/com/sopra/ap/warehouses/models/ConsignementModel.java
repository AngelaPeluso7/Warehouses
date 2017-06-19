package com.sopra.ap.warehouses.models;

public class ConsignementModel {
	private int idConsignement;
	private int warehouse;
	private TypeProduct typeProduct;
	private StateConsignement stateConsignement;
	
	public ConsignementModel(int idConsignement, int warehouse, TypeProduct typeProduct,
			StateConsignement stateConsignement) {
		this.idConsignement = idConsignement;
		this.warehouse = warehouse;
		this.typeProduct = typeProduct;
		this.stateConsignement = stateConsignement;
	}

	public ConsignementModel() {
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

	public TypeProduct getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(TypeProduct typeProduct) {
		this.typeProduct = typeProduct;
	}

	public StateConsignement getStateConsignement() {
		return stateConsignement;
	}

	public void setStateConsignement(StateConsignement stateConsignement) {
		this.stateConsignement = stateConsignement;
	}
	
	
}
