package com.sopra.ap.warehouses.data;

public class OrderData {
	private int idOrder;
	private String typeProduct1;
	private int consignement1;
	private String typeProduct2;
	private int consignement2;
	
	public OrderData(int idOrder, String typeProduct1, int consignement1, String typeProduct2, int consignement2) {
		this.idOrder = idOrder;
		this.typeProduct1 = typeProduct1;
		this.consignement1 = consignement1;
		this.typeProduct2 = typeProduct2;
		this.consignement2 = consignement2;
	}

	public OrderData() {
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getTypeProduct1() {
		return typeProduct1;
	}

	public void setTypeProduct1(String typeProduct1) {
		this.typeProduct1 = typeProduct1;
	}

	public int getConsignement1() {
		return consignement1;
	}

	public void setConsignement1(int consignement1) {
		this.consignement1 = consignement1;
	}

	public String getTypeProduct2() {
		return typeProduct2;
	}

	public void setTypeProduct2(String typeProduct2) {
		this.typeProduct2 = typeProduct2;
	}

	public int getConsignement2() {
		return consignement2;
	}

	public void setConsignement2(int consignement2) {
		this.consignement2 = consignement2;
	}
	
}
