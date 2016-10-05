/**
 * 
 */
/**
 * @author samuel
 *
 */
package LoginSuit;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import login.aLoginPage;



public class cAppTest {
	 
	WebDriver driver;
	 
	static String driverPath = "C:\\Users\\samuel.samuel-andoh\\Downloads\\";
	
	
	@BeforeTest
	public void setup() {
		System.out.println("*******************");
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.bing.com/");
	}
	/*
	@BeforeTest
	public void setup1(){
		  driver = new FirefoxDriver();
		 
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  Reporter.log("launch the internet browser ");
		  //driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
		  driver.get("http://www.bing.com/");
	
		    }
	*/
	

			
			  @Test(priority=0)
			public void bingSearchTest2() throws InterruptedException{
		     // invoke the beforeTest method over here 
				setup();
				
			aLoginPage bingSearch = new aLoginPage(driver);
			bingSearch.searchBing("Books");
		     //String searchFind = "driver.getPageSource().contains(Becker Books)";
			System.out.println(" verifying the test contains online shopping 3 ");
		     boolean test = driver.getPageSource().contains("o");
			
			Assert.assertEquals(test, true);
		     
		     driver.close();
		     
		     Thread.sleep(2000);
			}
		   
	   
}