package com.sopra.ap.warehouses.facades;

import java.util.List;

import com.sopra.ap.warehouses.data.OrderData;

public interface OrderFacade {
	
	public List<OrderData> getAll();
	
	public OrderData getById(int idOrder);
	
	public boolean newOrder(OrderData orderData);
}
