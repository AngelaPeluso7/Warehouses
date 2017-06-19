package com.sopra.ap.warehouses.services;

import java.util.List;

import com.sopra.ap.warehouses.models.ConsignementModel;

public interface ConsignementService {
	
	public List<ConsignementModel> getAll();
	
	public ConsignementModel getById(int idConsignement);
	
	public boolean newConsignement(ConsignementModel consignementModel);
}
