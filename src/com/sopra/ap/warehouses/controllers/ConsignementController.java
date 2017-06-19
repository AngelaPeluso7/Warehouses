package com.sopra.ap.warehouses.controllers;

import java.util.ArrayList;
import java.util.List;

import com.sopra.ap.warehouses.data.ConsignementData;
import com.sopra.ap.warehouses.facades.ConsignementFacade;
import com.sopra.ap.warehouses.facades.impl.DefaultConsignementFacade;

public class ConsignementController {
	private ConsignementFacade consignementFacade;
	private ConsignementData consignementData;
	
	public ConsignementController() {
		this.consignementFacade=new DefaultConsignementFacade();
		this.consignementData=new ConsignementData();
	}

	public String showConsignements(){
		final List<ConsignementData> consignements=consignementFacade.getAll();
		ArrayList<String> consignementsToString = new ArrayList<String>();
		String print = "";
		for (ConsignementData c: consignements){
			print=print + consignementsToString.add(c.toString());
		}
		return print;
	}
	
	public List<ConsignementData> getAll(){
		return consignementFacade.getAll();
	}

	public String showConsignement(int idConsignement){
		return (consignementFacade.getById(idConsignement)).toString();
	}
	public ConsignementData getById(int idConsignement){
		return consignementFacade.getById(idConsignement);
	}
	
	public String newConsignementEsit(ConsignementData consignementData){
		if(consignementFacade.newConsignement(consignementData)){
			return "La consignement è stata inserita con successo: "+ consignementData.toString();
		}
		return "La consignement NON è stata inserita!";
	}
	
	public Boolean newConsignement(ConsignementData consignementData){
		return consignementFacade.newConsignement(consignementData);
	}

	public ConsignementFacade getConsignementFacade() {
		return consignementFacade;
	}

	public void setConsignementFacade(ConsignementFacade consignementFacade) {
		this.consignementFacade = consignementFacade;
	}

	public ConsignementData getConsignementData() {
		return consignementData;
	}

	public void setConsignementData(ConsignementData consignementData) {
		this.consignementData = consignementData;
	}
	
}
