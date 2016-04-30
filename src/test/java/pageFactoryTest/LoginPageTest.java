/**
 * 
 */
/**
 * @author samuel
 *
 */
package pageFactoryTest;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.LoginPage;

public class LoginPageTest {
	 
	WebDriver driver;
	  
	@BeforeTest
	   public void setup(){
	 
	  driver = new FirefoxDriver();
	 
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	  //driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
	  driver.get("http://www.bing.com/");

	    }

	

		@Test
		public void bingSearchTest() throws InterruptedException{
		LoginPage bingSearch = new LoginPage(driver);
		bingSearch.searchBing("Books");
	     //String searchFind = "driver.getPageSource().contains(Becker Books)";
	     boolean test = driver.getPageSource().contains("Online shopping");
		
		Assert.assertEquals(test, true);
	  
	     driver.close();
	     
	     Thread.sleep(2000);
		}
		
		@Test
		public void bingSearchTest1() throws InterruptedException{
	     // invoke the beforeTest method over here 
			setup();
		LoginPage bingSearch = new LoginPage(driver);
		bingSearch.searchBing("Books");
	     //String searchFind = "driver.getPageSource().contains(Becker Books)";
	     boolean test = driver.getPageSource().contains("Online shopping");
		
		Assert.assertEquals(test, true);
	  
	     driver.close();
	     
	     Thread.sleep(2000);
		}
		@Test
		public void bingSearchTest2() throws InterruptedException{
	     // invoke the beforeTest method over here 
			setup();
			
		LoginPage bingSearch = new LoginPage(driver);
		bingSearch.searchBing("Books");
	     //String searchFind = "driver.getPageSource().contains(Becker Books)";
		System.out.println(" verifying the test contains online shopping 3 ");
	     boolean test = driver.getPageSource().contains("Online shopping");
		
		Assert.assertEquals(test, true);
	     
	     driver.close();
	     
	     Thread.sleep(2000);
		}
		
		

}