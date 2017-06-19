package com.sopra.ap.warehouses.facades;

import java.util.List;

import com.sopra.ap.warehouses.data.InvoiceData;

public interface InvoiceFacade {
	
	public List<InvoiceData> getAll();
	
	public InvoiceData getById(int idInvoice);
	
	public boolean newInvoice(InvoiceData invoiceData);
}
