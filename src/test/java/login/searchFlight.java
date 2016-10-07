package login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class searchFlight {


	static String driverPath = "C:\\Users\\samuel.samuel-andoh\\Downloads\\";
	public WebDriver driver;
	
	// constructor for the class
	public searchFlight(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
	}
	
	// Flying From
	@FindBy(how= How.ID,using ="flight-origin")
	WebElement FlyingFrom;
	
	//Flying To
	@FindBy(how= How.ID,using ="flight-destination")
	WebElement FlyingTo;
	
	//Departing
	@FindBy(how= How.ID,using ="flight-departing")
	WebElement Departing;
	
	//Returning
	@FindBy(how= How.ID,using ="flight-returning")
	WebElement Returning;

	
	//Adults
    @FindBy(how= How.ID,using ="flight-adults")
	WebElement Adults;
	
	
	//Children 
	@FindBy(how= How.ID,using ="flight-children")
	WebElement Children;
	
	//Child Age
	@FindBy(how= How.ID,using ="flight-age-select-1")
	WebElement childAge;
	
	
	@Given("^i Navigate to  the flight application$")
	public void setUp(String url ) throws Throwable {		
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
	}

	@When("^I enter the the departure and returning information and Searched$")
	public void enterFlightInformation(String departingAirport, String arrivingAirport,String DepartingDate, String ReturningDate, String numberOfAdults,String numberOfchildren, String AgeofChild ) throws Throwable {
		
		
		FlyingFrom.sendKeys(departingAirport);
		Thread.sleep(5000);
		FlyingTo.sendKeys(arrivingAirport);
		Thread.sleep(2000);
		Departing.sendKeys(DepartingDate );
		Thread.sleep(5000);
		Returning.sendKeys(ReturningDate);
		Thread.sleep(5000);
		// Selects the number of adults
		Select adultsObject = new Select(Adults);	
		adultsObject.selectByVisibleText(numberOfAdults);
		// the number of children
		Thread.sleep(5000);
		Select childObjects = new Select(Children);	
		childObjects.selectByVisibleText(numberOfchildren);
	
		//Age of  children
		Thread.sleep(5000);
		Select chAgeObjects = new Select(childAge);	
		chAgeObjects.selectByVisibleText(AgeofChild	);
		
	}

	@Then("^I can be able to find American airlines which has (\\d+) stop\\. \\.$")
	public void validateAmericanAirlines( String testObject) throws Throwable {
		   Thread.sleep(7000);
			
      //String searchFind = "driver.getPageSource().contains(Becker Books)";
      boolean AmericanAirlineExists = driver.getPageSource().contains(testObject);
			
		     try{
			  Assert.assertEquals(AmericanAirlineExists, true);
		    // Assert.assertEquals(test, true);
		      driver.close();				     
		      Thread.sleep(2000);	
		      
		     } catch(Exception e){
				 
			Assert.assertEquals(AmericanAirlineExists, false);
				 
			 }
	}

	@Then("^close the browser\\.$")
	public void close_browser() throws Throwable {
	   driver.close();
	}



}
