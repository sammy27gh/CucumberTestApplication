package priceLineLightReservationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import priceLineFLight.pricelineFlightReservation;



	public class PricelineFlightReservationTest {
		WebDriver driver;
	
      
	public void reservationTest1() throws Throwable{
		
		pricelineFlightReservation reservationObject = new pricelineFlightReservation(driver);
		reservationObject.setUp("https://www.priceline.com/");
		Thread.sleep(5000);
		pricelineFlightReservation reservationObject1 = new pricelineFlightReservation(driver);
		reservationObject1.navigateToFlight();
		Thread.sleep(5000);
		pricelineFlightReservation reservationObject2 = new pricelineFlightReservation(driver);
		reservationObject2.BookingInformation("IAH", "JFK ","10/16/2016","10/17/2016","1 Adult","1 child", "First");
		pricelineFlightReservation reservationObject3 = new pricelineFlightReservation(driver);
		 reservationObject3.VerifyFlightPrice("American Airlines / Delta Air Lines");
   }
	
	} 
	
	
	
