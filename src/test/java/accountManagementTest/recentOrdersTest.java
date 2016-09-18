package accountManagementTest;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import acccountManagement.recentOrders;








public class recentOrdersTest {
	
	//static String driverPath = "C:\\Users\\samuel.samuel-andoh\\Downloads\\";
	
	WebDriver driver = new HtmlUnitDriver(); 
	@BeforeTest
		public void setup()  {
		System.out.println("*******************");
		System.out.println("launching Chrome browser");
		
		
		driver.get("https://gapps.waldenu.edu/Login.aspx");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
   /*
   public void loginTest() throws Throwable{
	   Thread.sleep(10000);
      recentOrders recOrders = new recentOrders();
      Thread.sleep(10000);
      recOrders.login("sammy27gh@yahoo.com", "ska123456");
        	 
         }
   */
   @Test
   public void LoginTest() throws Throwable{
	   
	   recentOrders  recOrders = new recentOrders(driver);	  
	   
       recOrders.login("samuel.andoh@waldenu.edu", "ska123456");
       
	  boolean recentOrderTest= driver.getPageSource().contains("Career Services");
	
	    Assert.assertEquals(recentOrderTest, true);
   }
   @Test
   public void update_Recent_Order_CreditCardDetailsTest() throws Throwable{
	   recentOrders  recOrdersCredit = new recentOrders(driver);	
	   recOrdersCredit.update_Recent_Order_CreditCardDetails();
	   boolean recOrdersCreditTest= driver.getPageSource().contains("Career Services");
		Assert.assertEquals(recOrdersCreditTest, true);
   }
 
}
