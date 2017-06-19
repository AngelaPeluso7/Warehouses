package com.sopra.ap.warehouses.facades.impl;

import java.util.ArrayList;
import java.util.List;

import com.sopra.ap.warehouses.data.InvoiceData;
import com.sopra.ap.warehouses.facades.InvoiceFacade;
import com.sopra.ap.warehouses.models.InvoiceModel;
import com.sopra.ap.warehouses.models.StateOrder;
import com.sopra.ap.warehouses.services.InvoiceService;
import com.sopra.ap.warehouses.services.impl.DefaultInvoiceService;

public class DefaultInvoiceFacade implements InvoiceFacade{
	
	private InvoiceService invoiceService;
	
	public DefaultInvoiceFacade(InvoiceService invoiceService) {
		this.invoiceService=new DefaultInvoiceService();
	}

	public DefaultInvoiceFacade() {
	}
	
	public List<InvoiceData> getAll(){
		List<InvoiceModel> invoicesModel = invoiceService.getAll();
		final List<InvoiceData> invoicesData = new ArrayList<InvoiceData>();
		for (InvoiceModel invoice : invoicesModel) {
			final InvoiceData invoiceData = new InvoiceData();
			invoiceData.setIdInvoice(invoice.getIdInvoice());
			invoiceData.setOrder(invoice.getOrder());
			invoiceData.setStateOrder((invoice.getStateOrder().toString()));
			invoicesData.add(invoiceData);
		}
		return invoicesData;
	}
	
	public InvoiceData getById(int idInvoice){
		InvoiceModel invoiceModel = invoiceService.getById(idInvoice);
		InvoiceData invoiceData = new InvoiceData();
		invoiceData.setIdInvoice(invoiceModel.getIdInvoice());
		invoiceData.setOrder(invoiceModel.getOrder());
		invoiceData.setStateOrder((invoiceModel.getStateOrder().toString()));
		return invoiceData;
	}
	
	public boolean newInvoice(InvoiceData invoiceData){
		boolean result= false;
		if (invoiceData != null)
		{
			InvoiceModel invoiceModel=new InvoiceModel();
			invoiceModel.setIdInvoice(invoiceData.getIdInvoice());
			invoiceModel.setOrder(invoiceData.getOrder());
			invoiceModel.setStateOrder(StateOrder.valueOf(invoiceData.getStateOrder()));			
			result = invoiceService.newInvoice(invoiceModel);
		}
		else
		{
			throw new IllegalArgumentException("Invoice not found.");
		}
		return result;
	}
}
