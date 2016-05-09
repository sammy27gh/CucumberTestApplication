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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.aLoginPage;

public class bAppTest {
	 
	
	
	
	//static String driverPath = "C:\\Users\\Administrator\\Documents\\IEDriver\\";
	public WebDriver driver;
	/*
	@BeforeTest
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching IE browser");
		System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void testGooglePageTitleInIEBrowser() {
		driver.navigate().to("http://www.bing.com");
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}
	
	*/
	
	@BeforeTest
				   public void setup1(){
				  driver = new FirefoxDriver();
				 
				  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				  Reporter.log("launch the internet browser ");
				  //driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
				  driver.get("http://www.bing.com/");
			
				    }

	

			  
					 @Test
					public void bingSearchTest1() throws InterruptedException{
				     // invoke the beforeTest method over here 
						   setup1();
						   
			         Reporter.log("Test for Books ");
					aLoginPage bingSearch = new aLoginPage(driver);
					bingSearch.searchBing("Dentistry");
				     //String searchFind = "driver.getPageSource().contains(Becker Books)";
				     boolean test = driver.getPageSource().contains("o");
					
					//Assert.assertEquals(test, true);
				     Assert.assertEquals(test, true);
		 
		    
				     driver.close();
				     
				     Thread.sleep(2000);
					}
					 
			
		   
	   
}