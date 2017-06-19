package com.sopra.ap.warehouses.data;

public class InvoiceData {
	private int idInvoice;
	private int order;
	private String stateOrder;
	
	public InvoiceData(int idInvoice, int order, String stateOrder) {
		this.idInvoice = idInvoice;
		this.order = order;
		this.stateOrder = stateOrder;
	}
	
	public InvoiceData() {
	}
	
	public int getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(int idInvoice) {
		this.idInvoice = idInvoice;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getStateOrder() {
		return stateOrder;
	}

	public void setStateOrder(String stateOrder) {
		this.stateOrder = stateOrder;
	}
	
}
