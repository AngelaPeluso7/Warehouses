package com.sopra.ap.warehouses.DAO;

import java.util.List;

import com.sopra.ap.warehouses.models.OrderModel;

public interface OrderDAO {
	
	public List<OrderModel> findAll();
	
	public OrderModel findById(int idOrder);
	
	public boolean newOrder(OrderModel orderModel);
}
