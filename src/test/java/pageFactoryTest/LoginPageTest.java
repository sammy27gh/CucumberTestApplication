/**
 * 
 */
/**
 * @author samuel
 *
 */
package pageFactoryTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.LoginPage;
import pageFactory.SearchResultsPage;

public class LoginPageTest {
	 
	WebDriver driver;
	  
	@BeforeTest
	   public void setup(){
	 
	  driver = new FirefoxDriver();
	 
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	  //driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
	  driver.get("http://www.bing.com/");

	    }
	
	// this test checks for the login functionality
	 /*   public void loginTest(){
		
	    LoginPage objLogin = new LoginPage(driver);
		
		objLogin.login("healthyandwellnessproducts@gmail.com", "healthyandwellnessproducts123");
	
	}*/
		@Test
		public void bingSearchTest(){
		LoginPage bingSearch = new LoginPage(driver);
		bingSearch.searchBing("Books");
	     //String searchFind = "driver.getPageSource().contains(Becker Books)";
		//SearchResultsPage searchR  =  new SearchResultsPage(driver);
		
	   Assert.assertTrue(driver.getPageSource().contains("Becker"));
	   
		}
	

}