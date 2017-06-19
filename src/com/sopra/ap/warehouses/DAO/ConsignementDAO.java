package com.sopra.ap.warehouses.DAO;

import java.util.List;

import com.sopra.ap.warehouses.models.ConsignementModel;

public interface ConsignementDAO {
	
	public List<ConsignementModel> findAll();
	
	public ConsignementModel findById(int idConsignement);
	
	public boolean newConsignement(ConsignementModel consignementModel);
}
