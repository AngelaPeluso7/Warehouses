package com.sopra.ap.warehouses.facades.impl;

import java.util.ArrayList;
import java.util.List;
import com.sopra.ap.warehouses.data.OrderData;
import com.sopra.ap.warehouses.facades.OrderFacade;
import com.sopra.ap.warehouses.models.OrderModel;
import com.sopra.ap.warehouses.models.TypeProduct;
import com.sopra.ap.warehouses.services.OrderService;
import com.sopra.ap.warehouses.services.impl.DefaultOrderService;

public class DefaultOrderFacade implements OrderFacade {
	private OrderService orderService;
	private OrderModel orderModel;
	
	public DefaultOrderFacade() {
		this.orderService=new DefaultOrderService();
		this.orderModel=new OrderModel();
	}

	public List<OrderData> getAll() {
		List<OrderModel> ordersModel = orderService.getAll();
		final List<OrderData> ordersData = new ArrayList<OrderData>();
		for (OrderModel order : ordersModel) {
			final OrderData orderData = new OrderData();
			orderData.setIdOrder(order.getIdOrder());
			orderData.setTypeProduct1(order.getTypeProduct1().toString());
			orderData.setConsignement1(order.getConsignement1());
			orderData.setTypeProduct2(order.getTypeProduct2().toString());
			orderData.setConsignement2(order.getConsignement2());
			ordersData.add(orderData);
		}
		return ordersData;
	}

	public OrderData getById(int idOrder) {
		OrderModel orderModel = orderService.getById(idOrder);
		OrderData orderData = new OrderData();
		orderData.setIdOrder(orderModel.getIdOrder());
		orderData.setTypeProduct1(orderModel.getTypeProduct1().toString());
		orderData.setConsignement1(orderModel.getConsignement1());
		orderData.setTypeProduct2(orderModel.getTypeProduct2().toString());
		orderData.setConsignement2(orderModel.getConsignement2());
		return orderData;
	}

	public boolean newOrder(OrderData orderData) {
		boolean result= false;
		if (orderData != null)
		{
			OrderModel orderModel=new OrderModel();
			orderModel.setIdOrder(orderData.getIdOrder());
			orderModel.setTypeProduct1(TypeProduct.valueOf(orderData.getTypeProduct1()));
			orderModel.setConsignement1(orderData.getConsignement1());
			orderModel.setTypeProduct2(TypeProduct.valueOf(orderData.getTypeProduct2()));
			orderModel.setConsignement2(orderData.getConsignement2());
			result = orderService.newOrder(orderModel);
		}
		else
		{
			throw new IllegalArgumentException("Order not found.");
		}
		return result;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderModel getOrderModel() {
		return orderModel;
	}

	public void setOrderModel(OrderModel orderModel) {
		this.orderModel = orderModel;
	}

}
