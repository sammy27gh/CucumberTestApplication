package LoginSuit;


import org.testng.annotations.Test;

import login.pricelineFlightReservation;



	public class PricelineFlightReservationTest {
		
		 
	
	
        @Test   
	     public void reservationTest1() throws Throwable{
		
		pricelineFlightReservation reservationObject = new pricelineFlightReservation(null);
		reservationObject.setUp("http://www.newtours.demoaut.com/mercuryregister.php?osCsid=758e69d355727763bf2573552963bea4");
		Thread.sleep(2000);
		reservationObject.remoteControl();
		Thread.sleep(3000);	
		reservationObject.BookingInformation("Kofi" ,"Samuel", "2153808037", "andoh.samuel@yahoo.com","2601 WoodlandPark", "Huston","TX", "77082", "UNITED STATE", "sandoh1111", "Sk$852417", "Sk$852417");
		Thread.sleep(5000);		
		reservationObject.VerifyFlightPrice("American Airlines / Delta Air Lines");
		Thread.sleep(5000);
		reservationObject.close_the_browser();
		
   }
	
	} 
	
	
	
