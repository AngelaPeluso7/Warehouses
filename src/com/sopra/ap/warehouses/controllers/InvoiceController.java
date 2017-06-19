package com.sopra.ap.warehouses.controllers;

import java.util.ArrayList;
import java.util.List;

import com.sopra.ap.warehouses.data.InvoiceData;
import com.sopra.ap.warehouses.facades.InvoiceFacade;
import com.sopra.ap.warehouses.facades.impl.DefaultInvoiceFacade;

public class InvoiceController {
	private InvoiceFacade invoiceFacade;
	private InvoiceData invoiceData;
	
	public InvoiceController() {
		this.invoiceFacade=new DefaultInvoiceFacade();
		this.invoiceData=new InvoiceData();
	}

	public String showInvoices(){
		final List<InvoiceData> invoices=invoiceFacade.getAll();
		ArrayList<String> invoicesToString = new ArrayList<String>();
		String print = "";
		for (InvoiceData i: invoices){
			print=print + invoicesToString.add(i.toString());
		}
		return print;
	}
	
	public List<InvoiceData> getAll(){
		return invoiceFacade.getAll();
	}

	public String showInvoice(int idInvoice){
		return (invoiceFacade.getById(idInvoice)).toString();
	}
	public InvoiceData getById(int idInvoice){
		return invoiceFacade.getById(idInvoice);
	}
	
	public String newInvoiceEsit(InvoiceData invoiceData){
		if(invoiceFacade.newInvoice(invoiceData)){
			return "L'invoice è stato inserito con successo!";
		}
		return "L'invoice NON è stato inserito!";
	}
	
	public Boolean newInvoice(InvoiceData invoiceData){
		return invoiceFacade.newInvoice(invoiceData);
	}

	public InvoiceFacade getInvoiceFacade() {
		return invoiceFacade;
	}

	public void setInvoiceFacade(InvoiceFacade invoiceFacade) {
		this.invoiceFacade = invoiceFacade;
	}

	public InvoiceData getInvoiceData() {
		return invoiceData;
	}

	public void setInvoiceData(InvoiceData invoiceData) {
		this.invoiceData = invoiceData;
	}
	
}
