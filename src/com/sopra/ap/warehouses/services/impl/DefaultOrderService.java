package com.sopra.ap.warehouses.services.impl;

import java.util.List;

import com.sopra.ap.warehouses.DAO.OrderDAO;
import com.sopra.ap.warehouses.DAO.impl.DefaultOrderDAO;
import com.sopra.ap.warehouses.models.OrderModel;
import com.sopra.ap.warehouses.services.OrderService;

public class DefaultOrderService implements OrderService {
	private OrderDAO orderDAO;
	
	public DefaultOrderService() {
		this.orderDAO=new DefaultOrderDAO();
	}

	public List<OrderModel> getAll() {
		return orderDAO.findAll();
	}

	public OrderModel getById(int idOrder) {
		return orderDAO.findById(idOrder);
	}

	public boolean newOrder(OrderModel orderModel) {
		return orderDAO.newOrder(orderModel);
	}

}
