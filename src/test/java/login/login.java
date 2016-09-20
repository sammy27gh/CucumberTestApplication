package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.server.SeleniumServer;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class login {
	 
  public WebDriver driver =  new HtmlUnitDriver(true);

  // constructor for the class
 	public login(WebDriver driver){
 	this.driver = driver;
 	PageFactory.initElements(driver, this);
 	
 	}
  
	// Locate the objects necessary for the Search Functionality
	@FindBy(how =How.NAME ,   using= "q") // This is used to locate the userName
	WebElement Search;
	
	
	@FindBy(how =How.NAME ,   using= "go")// This is used to Submit Button 
	WebElement Submit;
	 

	//Locate the the objects stack overflow.
	

	
	@FindBy(how =How.ID ,   using= "email") // This is used to locate the userName
	WebElement UserName;
	
	@FindBy(how =How.ID ,   using= "password") // This is used to locate the userName
	WebElement Password;

	@FindBy(how= How.ID , using = "submit-button" )// this is the locate 
	WebElement Login;
	
	
	
    public void app_login() throws InterruptedException{
    	
    	// Launch the URL 
    
        driver.get("https://www.facebook.com/");
    	//wait for 6 seconds 
        Thread.sleep(6000);
      
       
        
    }
        
    public void app_gmailAccount(String uName, String Pword) throws Throwable{
    	
    	//launch the URL 
    	driver.get("https://stackoverflow.com/users/login?ssrc=head&returnurl=http%3a%2f%2fstackoverflow.com%2f");
    	
    	
    	//Enter the UserName
    	 UserName.sendKeys(uName);
    	 Thread.sleep(6000);
    	//Enter the Password
    	 UserName.sendKeys(Pword);
    	//Click on Enter.
    	 Thread.sleep(6000);
    	 Login.click();
    }
    

}
