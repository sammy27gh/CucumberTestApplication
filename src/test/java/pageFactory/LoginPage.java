
package pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver; 
	
	@FindBy(how= How.NAME,using ="Email")
	WebElement UserName;
	

	@FindBy(how= How.NAME,using ="signIn")
	WebElement Next;
	
	@FindBy(how= How.NAME, using = "Passwd" ) 
	WebElement Pass;

	
	@FindBy(how = How.NAME, using = "signIn") 
	WebElement submit;
	// bing element 
	
	
	
	@FindBy(how= How.NAME,using = "q")
	WebElement Search;
	
	@FindBy(how= How.NAME,using = "go")
	WebElement clickSearch;
	
	// constructor for the class
	public LoginPage(WebDriver driver){
		this.driver = driver;
	PageFactory.initElements(driver, this);
	
	}

	// this method types in and click the to login. 
	public void login(String UName, String Password){
		
		UserName.sendKeys(UName);
		Next.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Pass.sendKeys(Password);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		submit.click();
	}
	
         public void searchBing(String SearchTerm){
        	 
        	 Search.sendKeys(SearchTerm);
        	 
        	 clickSearch.click();
        	 
         }
         
         

}
