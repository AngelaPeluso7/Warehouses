package com.sopra.ap.warehouses.services.impl;

import java.util.List;

import com.sopra.ap.warehouses.DAO.InvoiceDAO;
import com.sopra.ap.warehouses.DAO.impl.DefaultInvoiceDAO;
import com.sopra.ap.warehouses.models.InvoiceModel;
import com.sopra.ap.warehouses.services.InvoiceService;

public class DefaultInvoiceService implements InvoiceService {
	
	private InvoiceDAO invoiceDAO;
	
	public DefaultInvoiceService(InvoiceDAO invoiceDAO) {
		this.invoiceDAO=new DefaultInvoiceDAO();
	}
	
	public DefaultInvoiceService() {
	}
	
	public List<InvoiceModel> getAll() {
		return invoiceDAO.findAll();
	}

	public InvoiceModel getById(int idInvoice) {
		return invoiceDAO.findById(idInvoice);
	}

	public boolean newInvoice(InvoiceModel invoiceModel) {
		return invoiceDAO.newInvoice(invoiceModel);
	}

}
