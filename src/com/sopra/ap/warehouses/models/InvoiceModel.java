package com.sopra.ap.warehouses.models;

public class InvoiceModel {
	private int idInvoice;
	private int order;
	private StateOrder stateOrder;
	
	public InvoiceModel(int idInvoice, int order, StateOrder stateOrder) {
		this.idInvoice = idInvoice;
		this.order = order;
		this.stateOrder = stateOrder;
	}
	public InvoiceModel() {
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
	public StateOrder getStateOrder() {
		return stateOrder;
	}
	public void setStateOrder(StateOrder stateOrder) {
		this.stateOrder = stateOrder;
	}
	
}
