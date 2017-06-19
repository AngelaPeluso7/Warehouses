package com.sopra.ap.warehouses.services;

import java.util.List;

import com.sopra.ap.warehouses.models.InvoiceModel;

public interface InvoiceService {
	
	public List<InvoiceModel> getAll();
	
	public InvoiceModel getById(int idInvoice);
	
	public boolean newInvoice(InvoiceModel invoiceModel);
}
