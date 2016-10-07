package priceLineFLight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class pricelineFlightReservation {

	 WebDriver driver;
	 
		public pricelineFlightReservation(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
			}
	 
	public void setUp(String url ) {		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\samuel.samuel-andoh\\Downloads\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
	}
	//click on FLight 
	
    @FindBy(how= How.XPATH,using ="//*[* = 'Flights']")
	WebElement Flights;
		
 // Enter the FLight From 
	@FindBy(how= How.XPATH,using ="//*[* = 'From']")
	WebElement FROM;
	
	//Enter the FLight To 
	@FindBy(how= How.XPATH,using ="//*[* = 'To']")
	WebElement TO;
	
	//Departing Date
	@FindBy(how= How.XPATH,using ="//*[* = 'Departing']")
	WebElement DEPARTING;
	
	//Enter Arrival Date
	
	@FindBy(how= How.XPATH,using ="//*[* = 'Returning']")
	WebElement RETURNING;
	
   
	
	// Enter the Adults Age 
	@FindBy(how= How.XPATH,using ="//*[@data-reactid='.222fwjarsow.0.0.0.0.0.0.0.1.$2__view.$flight.1.3.0.0.1.2']")
	WebElement ADULTS_AGE;
	
	// Enter the childrens age 
	
	@FindBy(how= How.XPATH,using ="select-container__select Input Input--pristine Input--valid")
	WebElement CHILDREN_AGE;
	
	// select the cabin class 
	
	@FindBy(how= How.XPATH,using = "//*[@data-reactid='.222fwjarsow.0.0.0.0.0.0.0.1.$2__view.$flight.1.4.0.0.1.2']")
	WebElement Cabin_Class;
	

	// Click on the search Value
	@FindBy(how= How.LINK_TEXT,using ="Search All Flights")
	WebElement Search_Flights;
	
	@Given("^I am on the fligh application page$")
	public void navigateToFlight() throws Throwable {
		Flights.click();
	}

	@Given("^Navigated to the flight section of the page$")
	public void navigateToFlight(String backNavigate) throws Throwable {
	    System.out.println("system has been clicked ");
	    
	}

	@When("^I enter the Booking details and search for october (\\d+)  and return on Nov (\\d+)$")
	public void BookingInformation(String StartingAirportName, String EndingAirportName, String DepartingDate, String ReturningDate, String AdultAge,String childAge, String Class_Cabin ) throws Throwable {
	   //Enter the STARTING  POINT
		FROM.sendKeys( StartingAirportName);
		Thread.sleep(3000);
		TO.sendKeys(EndingAirportName);
		Thread.sleep(3000);
		DEPARTING.sendKeys(DepartingDate);
		Thread.sleep(3000);
		RETURNING.sendKeys(ReturningDate);
	    // Adults age
		Thread.sleep(5000);		
		Select adultsObjects = new Select( ADULTS_AGE);	
		adultsObjects.selectByVisibleText(AdultAge);
		
		
		//Age of  children
		Thread.sleep(5000);
		Select childObjects = new Select(CHILDREN_AGE);	
		childObjects.selectByVisibleText(childAge);
		
		// Select the cabin class of the object 
		
		Thread.sleep(5000);
		Select cabinsObjects = new Select( Cabin_Class);	
		cabinsObjects.selectByVisibleText(Class_Cabin);
		
		//  Search the flight 
		Search_Flights.click();
		Thread.sleep(3000);
	}

	@Then("^I should see airlines and their corresponding flight price$")
	public void VerifyFlightPrice(String AirlinesToValidate ) throws Throwable {
    
		  boolean AmericanAirlineExists = driver.getPageSource().contains(AirlinesToValidate);
			
		     try{
			  Assert.assertEquals(AmericanAirlineExists, true);
		    // Assert.assertEquals(test, true);
		      driver.close();				     
		      Thread.sleep(2000);	
		      
		     } catch(Exception e){
				 
			Assert.assertEquals(AmericanAirlineExists, false);
				 
			 }
	}
  
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	  
	}





}
