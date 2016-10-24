package login;
import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class pricelineFlight {
			WebDriver driver;	 
		    public pricelineFlight(WebDriver driver){
			driver = this.driver ;
			PageFactory.initElements(driver, this);			
			}	 
				public void setUp(String url ) {		
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\samuel.samuel-andoh\\Downloads\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				//FirefoxDriver driver = new FirefoxDriver();
				driver.manage().window().maximize();		
				driver.get(url);		
	        }       
	
	   //Enter First Name
	   @FindBy(how= How.NAME,using ="firstname")
	   WebElement First_Name;
	
	      //Enter Last Name 
	   @FindBy(how= How.NAME,using ="lastname")
	   WebElement Last_Name;
	
	  //Enter Phone 
	
	   @FindBy(how= How.NAME,using ="reg_email__")
	   WebElement Phone;
	
	   // Enter Email
	     @FindBy(how= How.NAME,using ="reg_email_confirmation__")
	    WebElement Email;
	
	   // Enter Address
	
	     @FindBy(how= How.NAME,using ="reg_passwd__")
	     WebElement Address;
	
	   // Enter City 
	
	    @FindBy(how= How.NAME,using = "birthday_month")
	     WebElement City;
	
	    // Enter State	
	    @FindBy(how= How.NAME,using ="state")
	     WebElement State_Province;		
		
	     // Enter Postal code 		
     	@FindBy(how= How.NAME,using ="postalCode")
	     WebElement Postal_Code;
			
	    // Enter Country							
	     @FindBy(how= How.NAME,using ="country")
	      WebElement Country;
	
	
	   // Enter UserName
	
		@FindBy(how=  How.NAME,using ="email")
		WebElement User_Name;
			
	    // Enter Password	
		@FindBy(how=  How.NAME,using ="password")
		WebElement Password;
	 
	    // Confirm Password 
		
	     @FindBy(how=  How.NAME,using ="confirmPassword")
         WebElement Confirm_Password;
	     
	 	
	 	// Click on the Submit Button
	 	
	 	@FindBy(how=  How.NAME,using ="register")
	 	WebElement Submit;
		 
		//handle popup 
	public void remoteControl() throws Throwable{
		
		try {
		      
		    
		      Robot robot = new Robot();
		   //   robot.mouseMove(x, y);
		     
		      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
		     
		      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
		      
		      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
		  
		      robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		      Thread.sleep(3000);// can also use robot.setAutoDelay(500);
		    } catch (AWTException e) {
		      System.err.println("Error clicking Cancel.");
		      e.printStackTrace();
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    }
		
	}	
	//@When("^I enter the Booking details and search for october (\\d+)  and return on Nov (\\d+)$")
	public void BookingInformation(String FirstName, String LastName, 
			String PhoneNumber, String Email_id, String ResidentialAdddress,String CityName, String StateName,
			String PostalCodeNumber,String CountryName,String UserName, String Pass, String ConfirmPass
			
			) throws Throwable {
	   //Enter the STARTING  POINT
		First_Name.sendKeys(FirstName);
		Thread.sleep(3000);
		Last_Name.sendKeys(LastName);
		Thread.sleep(3000);
		Phone.sendKeys(PhoneNumber);
		Thread.sleep(3000);
		Email.sendKeys(Email_id);
		Thread.sleep(3000);
		Address.sendKeys(ResidentialAdddress);
		Thread.sleep(3000);
		City.sendKeys(CityName);
		Thread.sleep(3000);
		State_Province.sendKeys(StateName);
		Thread.sleep(3000);
		Postal_Code.sendKeys(PostalCodeNumber);
		
		Thread.sleep(5000);
		Select childObjects = new Select(Country);	
		childObjects.selectByVisibleText(CountryName);
		
		Thread.sleep(3000);
		User_Name.sendKeys(UserName);
		Thread.sleep(3000);
		Password.sendKeys(Pass);
		Thread.sleep(3000);
		Confirm_Password.sendKeys(ConfirmPass);	  
		Thread.sleep(3000);
		Submit.click();
	
	}
	//@Then("^I should see airlines and their corresponding flight price$")
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
	//@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	  driver.close();
	}





}

