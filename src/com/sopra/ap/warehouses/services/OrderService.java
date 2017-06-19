package com.sopra.ap.warehouses.services;

import java.util.List;

import com.sopra.ap.warehouses.models.OrderModel;

public interface OrderService {
	
	public List<OrderModel> getAll();
	
	public OrderModel getById(int idOrder);
	
	public boolean newOrder(OrderModel orderModel);
}
