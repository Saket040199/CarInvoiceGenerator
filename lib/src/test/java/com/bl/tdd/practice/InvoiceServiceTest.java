package com.bl.tdd.practice;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTheTotalFare() {
		InvoiceGenerator invoicegenerator=new InvoiceGenerator();
		double distance=2.0;
		int time=5;
		double fare=invoicegenerator.calculateFare(distance,time);
		System.out.println("Fare is : " +fare +"rs");
		Assert.assertEquals(25, fare,0.0); //0.0 is delta for double function
	}
	
	@Test
	public void givenLessDistanceAndTime_ShouldReturnTheMinimumFare() {
		InvoiceGenerator invoicegenerator=new InvoiceGenerator();
		double distance=0.1;
		int time=1;
		double fare=invoicegenerator.calculateFare(distance,time);
		System.out.println("Fare is : " +fare +"rs");
		Assert.assertEquals(5, fare,0.0); //0.0 is delta for double function
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		InvoiceGenerator invoicegenerator=new InvoiceGenerator();
		Ride[] rides= { new Ride(2.0,5),
		                new Ride(0.1,1)
		};
		
		double fare=invoicegenerator.calculateFare(rides);
		System.out.println("Total Fare of rides is : "+fare);
		Assert.assertEquals(30, fare,0.0);
	}
	
}
