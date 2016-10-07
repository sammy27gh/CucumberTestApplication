package LoginSuit;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import login.searchFlight;

public class searchFlightTest {
	
     WebDriver driver;
	 @Test
     public void FlightTest() throws Throwable{	
      searchFlight loginObject = new searchFlight(driver);	
      loginObject.setUp("https://www.orbitz.com/Flights?semcid=orbitz-us.multilob.google.search.flight&kword=b.|%2Bflights|.103.233805.3937.198009.109735611135&epi=b294de18-cab6-4ace-abf1-014c68f7827a&gclid=CKCxodDqxM8CFQKoaQody1IHXw");
      
      // run the robot to click away the popup
      
      Robot robot = new Robot();
	   //   robot.mouseMove(x, y);
	      Thread.sleep(7000);
	      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
	      Thread.sleep(2000);
	      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
	      Thread.sleep(2000);
	      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
	      Thread.sleep(2000);
	      robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	      Thread.sleep(3000);// can also use robot.setAutoDelay(500);
	 

	 searchFlight flightObject = new searchFlight(driver);
	
	 flightObject.enterFlightInformation("IAH", "JFK", "10/06/2016", "10/07/2016", "1","1", "1");
	 
		
		
	}
	
}
