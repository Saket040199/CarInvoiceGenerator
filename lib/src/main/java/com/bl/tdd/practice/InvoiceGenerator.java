package com.bl.tdd.practice;

public class InvoiceGenerator {

	private static final double MINIMUM_COST_PER_KM = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5.0;
	private static final double MINIMUM_COST_PER_KM_PREMIUM_RIDE = 15.0;
	private static final int COST_PER_TIME_PREMIUM_RIDE = 2;
	private static final double MINIMUM_FARE_PREMIUM_RIDE = 20.0;

	public double calculateFare(double distance, int time, String rideType) {
		if(rideType.equalsIgnoreCase("Normal")) {
		double totalFare= distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(MINIMUM_FARE, totalFare);
        }

       if(rideType.equalsIgnoreCase("Premium")) {
	   double totalFare= distance * MINIMUM_COST_PER_KM_PREMIUM_RIDE + time * COST_PER_TIME_PREMIUM_RIDE;
       return Math.max(MINIMUM_FARE_PREMIUM_RIDE, totalFare);
        }
       else {
	    	return 0.0;
       }
	}
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare=0.0;
		for(Ride ride:rides) {
			totalFare += this.calculateFare(ride.distance,ride.time, ride.rideType);
		}
		
		return new InvoiceSummary(rides.length, totalFare);
	}

	//public InvoiceSummary getInvoiceSummary(Ride[] rides) {
      //  double totalFare = calculateFare(rides);
        //return new InvoiceSummary(rides.length, totalFare);
        
	//}

//	Double asDouble(InvoiceSummary o) {
//		Double val=null;
//		if(o instanceof Number) {
//			val=((Number) o).doubleValue();
//		}
//		return val;
//	}
}
