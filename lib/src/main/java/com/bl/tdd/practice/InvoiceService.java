package com.bl.tdd.practice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    private List<RideRepository> repository;
    
    public InvoiceService() {
    	repository=new ArrayList<RideRepository>();
	}

	public InvoiceService(List<RideRepository> repository) {
		this.repository = repository;
	}
    
    public InvoiceSummary getInvoice(int id) {
    	InvoiceSummary invoiceSummary=null;
        for (RideRepository userRides : repository) {
            if (userRides.id == id) {
                invoiceSummary = new InvoiceGenerator().calculateFare(userRides.rides);
            }
        }
    	
    	return invoiceSummary;
    }
}
