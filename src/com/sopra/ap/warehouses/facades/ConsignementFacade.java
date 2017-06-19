package com.sopra.ap.warehouses.facades;

import java.util.List;

import com.sopra.ap.warehouses.data.ConsignementData;

public interface ConsignementFacade {
	
	public List<ConsignementData> getAll();
	
	public ConsignementData getById(int idConsignement);
	
	public boolean newConsignement(ConsignementData consignementData);
}
