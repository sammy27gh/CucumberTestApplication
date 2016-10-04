/**
 * 
 */
package LoginSuit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.testng.annotations.Test;

import login.login;

public class loginTest {

	WebDriver driver = new HtmlUnitDriver();
		
	@Test
	
  public void app_Test() throws InterruptedException{
		
	login Ltest=PageFactory.initElements(driver, login.class);
	  
	Ltest.app_login();
	Thread.sleep(5000);
	boolean app_login_books= driver.getPageSource().contains("login");
	Assert.assertEquals(app_login_books, true);
  }
  
	@Test
	 public void app_gmailAccountTest() throws Throwable{
	login gmailObject=PageFactory.initElements(driver, login.class);
	gmailObject.app_gmailAccount("sammy27gh@yahoo.com", "ska123456");
	boolean app_gmailAccountValidate= driver.getPageSource().contains("tag");
	Assert.assertEquals(app_gmailAccountValidate, true);
	 } 
}
