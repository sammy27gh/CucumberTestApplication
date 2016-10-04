/**
 * 
 */
/**
 * @author samuel
 *
 */
package loginTest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import login.aLoginPage;



public class bAppTest {
	 
	
	
	
	static String driverPath = "C:\\Users\\samuel.samuel-andoh\\Downloads\\";
	public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.out.println("*******************");
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.bing.com/");
	}
	
			  
					 @Test
					public void bingSearchTest1() throws InterruptedException{
						 
						
				     // invoke the beforeTest method over here 
						   setup();
						   
			         Reporter.log("Test for Books ");
					aLoginPage bingSearch = new aLoginPage(driver);
					bingSearch.searchBing("Dentistry");
				     //String searchFind = "driver.getPageSource().contains(Becker Books)";
				     boolean test = driver.getPageSource().contains("what the hell is that");
					
				     try{
					Assert.assertEquals(test, true);
				    // Assert.assertEquals(test, true);
		 
		    
				     driver.close();
				     
				     Thread.sleep(2000);
					
				     
				} catch(Exception e){
						 
					Assert.assertEquals(test, false);
						 
					 }
		   
	   
         }
}