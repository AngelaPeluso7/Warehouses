package com.sopra.ap.warehouses.services.impl;

import java.util.List;

import com.sopra.ap.warehouses.DAO.ConsignementDAO;
import com.sopra.ap.warehouses.DAO.impl.DefaultConsignementDAO;
import com.sopra.ap.warehouses.models.ConsignementModel;
import com.sopra.ap.warehouses.services.ConsignementService;

public class DefaultConsignementService implements ConsignementService {

	private ConsignementDAO consignementDAO;
	
	public DefaultConsignementService(ConsignementDAO consignementDAO) {
		this.consignementDAO=new DefaultConsignementDAO();
	}
	
	public DefaultConsignementService() {
	}
	
	public List<ConsignementModel> getAll() {
		return consignementDAO.findAll();
	}

	public ConsignementModel getById(int idConsignement) {
		return consignementDAO.findById(idConsignement);
	}

	public boolean newConsignement(ConsignementModel consignementModel) {
		return consignementDAO.newConsignement(consignementModel);
	}

}
