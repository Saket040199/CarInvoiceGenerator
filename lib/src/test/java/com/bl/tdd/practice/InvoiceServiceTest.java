package com.bl.tdd.practice;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	InvoiceGenerator invoicegenerator=null;
	
	@Before
	public void setup() {
	invoicegenerator=new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTheTotalFare() {
		double distance=2.0;
		int time=5;
		double fare=invoicegenerator.calculateFare(distance,time);
		System.out.println("Fare is : " +fare +"rs");
		Assert.assertEquals(25, fare,0.0); //0.0 is delta for double function
	}
	
	@Test
	public void givenLessDistanceAndTime_ShouldReturnTheMinimumFare() {
		double distance=0.1;
		int time=1;
		double fare=invoicegenerator.calculateFare(distance,time);
		System.out.println("Fare is : " +fare +"rs");
		Assert.assertEquals(5, fare,0.0); //0.0 is delta for double function
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides= { new Ride(2.0,5),
		                new Ride(0.1,1)
		};
		
		double fare=invoicegenerator.calculateFare(rides);
		System.out.println("fare summary : "+fare);
		Assert.assertEquals(30, fare,0.0);
	}
	
	@Test
	public void givenUserId_ShouldReturnTheTotalRidesOfUser() {
		RideRepository[] rideRepository = {new RideRepository(101,new Ride[] {new Ride(3.0,5), new Ride(2.0,5), new Ride(0.1,1)}),
			                               new RideRepository(102,new Ride[] {new Ride(3.0,5), new Ride(2.0,5), new Ride(0.1,1)})};
		
        InvoiceService invoiceService = new InvoiceService(Arrays.asList(rideRepository));
        InvoiceSummary invoiceSummary = invoiceService.getInvoice(101);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 65.0);
        
        System.out.println("Total Fare for ID 101 is : ");
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);

		}
	
		
	
	
}
