package com.sopra.ap.warehouses.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.sopra.ap.warehouses.data.ConsignementData;
import com.sopra.ap.warehouses.facades.ConsignementFacade;
import com.sopra.ap.warehouses.models.ConsignementModel;
import com.sopra.ap.warehouses.models.StateConsignement;
import com.sopra.ap.warehouses.models.TypeProduct;
import com.sopra.ap.warehouses.services.ConsignementService;
import com.sopra.ap.warehouses.services.impl.DefaultConsignementService;

public class DefaultConsignementFacade implements ConsignementFacade {
	
	private ConsignementService consignementService;
	private ConsignementModel consignementModel;
	
	public DefaultConsignementFacade() {
		this.consignementService=new DefaultConsignementService();
		this.consignementModel=new ConsignementModel();
	}
	
	public List<ConsignementData> getAll() {
		List<ConsignementModel> consignementsModel = consignementService.getAll();
		final List<ConsignementData> consignementsData = new ArrayList<ConsignementData>();
		for (ConsignementModel consignement : consignementsModel) {
			final ConsignementData consignementData = new ConsignementData();
			consignementData.setIdConsignement(consignement.getIdConsignement());
			consignementData.setWarehouse(consignement.getIdConsignement());
			consignementData.setStateConsignement(consignement.getStateConsignement().toString());
			consignementsData.add(consignementData);
		}
		return consignementsData;
	}

	public ConsignementData getById(int idConsignement) {
		ConsignementModel consignementModel = consignementService.getById(idConsignement);
		ConsignementData consignementData = new ConsignementData();
		consignementData.setIdConsignement(consignementModel.getIdConsignement());
		consignementData.setWarehouse(consignementModel.getIdConsignement());
		consignementData.setStateConsignement(consignementModel.getStateConsignement().toString());
		return consignementData;
	}

	public boolean newConsignement(ConsignementData consignementData) {
		boolean result= false;
		if (consignementData != null)
		{
			ConsignementModel consignementModel=new ConsignementModel();
			consignementModel.setIdConsignement(consignementData.getIdConsignement());
			consignementModel.setWarehouse(consignementData.getWarehouse());
			consignementModel.setTypeProduct(TypeProduct.valueOf(consignementData.getTypeProduct()));
			consignementModel.setStateConsignement(StateConsignement.valueOf(consignementData.getStateConsignement()));
			result = consignementService.newConsignement(consignementModel);
		}
		else
		{
			throw new IllegalArgumentException("Consignement not found.");
		}
		return result;
	}

	public ConsignementService getConsignementService() {
		return consignementService;
	}

	public void setConsignementService(ConsignementService consignementService) {
		this.consignementService = consignementService;
	}

	public ConsignementModel getConsignementModel() {
		return consignementModel;
	}

	public void setConsignementModel(ConsignementModel consignementModel) {
		this.consignementModel = consignementModel;
	}

}
