package com.sopra.ap.warehouses.models;

public class OrderModel {
	private int idOrder;
	private TypeProduct typeProduct1;
	private int consignement1;
	private TypeProduct typeProduct2;
	private int consignement2;
	
	public OrderModel(int idOrder, TypeProduct typeProduct1, int consignement1, TypeProduct typeProduct2,
			int consignement2) {
		this.idOrder = idOrder;
		this.typeProduct1 = typeProduct1;
		this.consignement1 = consignement1;
		this.typeProduct2 = typeProduct2;
		this.consignement2 = consignement2;
	}

	public OrderModel() {
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public TypeProduct getTypeProduct1() {
		return typeProduct1;
	}

	public void setTypeProduct1(TypeProduct typeProduct1) {
		this.typeProduct1 = typeProduct1;
	}

	public int getConsignement1() {
		return consignement1;
	}

	public void setConsignement1(int consignement1) {
		this.consignement1 = consignement1;
	}

	public TypeProduct getTypeProduct2() {
		return typeProduct2;
	}

	public void setTypeProduct2(TypeProduct typeProduct2) {
		this.typeProduct2 = typeProduct2;
	}

	public int getConsignement2() {
		return consignement2;
	}

	public void setConsignement2(int consignement2) {
		this.consignement2 = consignement2;
	}
	
}
