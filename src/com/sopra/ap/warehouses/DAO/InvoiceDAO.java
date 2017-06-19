package com.sopra.ap.warehouses.DAO;

import java.util.List;

import com.sopra.ap.warehouses.models.InvoiceModel;

public interface InvoiceDAO {
	
	public List<InvoiceModel> findAll();
	
	public InvoiceModel findById(int idInvoice);
	
	public boolean newInvoice(InvoiceModel invoiceModel);
}
