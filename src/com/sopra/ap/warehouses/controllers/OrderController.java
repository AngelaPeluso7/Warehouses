package com.sopra.ap.warehouses.controllers;

import java.util.ArrayList;
import java.util.List;

import com.sopra.ap.warehouses.data.OrderData;
import com.sopra.ap.warehouses.facades.OrderFacade;
import com.sopra.ap.warehouses.facades.impl.DefaultOrderFacade;

public class OrderController {
	private OrderFacade orderFacade;
	private OrderData orderData;
	
	public OrderController() {
		this.orderFacade=new DefaultOrderFacade();
		this.orderData=new OrderData();
	}

	public String showOrders(){
		final List<OrderData> orders=orderFacade.getAll();
		ArrayList<String> ordersToString = new ArrayList<String>();
		String print = "";
		for (OrderData o: orders){
			print=print + ordersToString.add(o.toString());
		}
		return print;
	}
	
	public List<OrderData> getAll(){
		return orderFacade.getAll();
	}

	public String showOrder(int idOrder){
		return (orderFacade.getById(idOrder)).toString();
	}
	public OrderData getById(int idOrder){
		return orderFacade.getById(idOrder);
	}
	
	public String newOrderEsit(OrderData orderData){
		if(orderFacade.newOrder(orderData)){
			return "L'ordine è stato inserito con successo: "+ orderData.toString();
		}
		return "L'ordine NON è stato inserito!";
	}
	
	public Boolean newOrder(OrderData orderData){
		return orderFacade.newOrder(orderData);
	}
	
	public OrderFacade getWarehouseFacade() {
		return orderFacade;
	}
	public void setOrderFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}
	public OrderData getOrderData() {
		return orderData;
	}
	public void setOrderData(OrderData orderData) {
		this.orderData = orderData;
	}
}
