/**
 * 
 */
/**
 * @author samuel
 *
 */
package LoginSuit;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.InputEvent;
import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

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
		
		//driver.get("http://www.bing.com/");
		//driver.get("http://www.helloselenium.com/2015/03/how-to-upload-file-using-java-robot.html");
		
		//driver.get("http://my.monsterindia.com/create_account.html");
		driver.get("http://www.helloselenium.com/2015/03/how-to-upload-file-using-java-robot.html");
		
	}       
	
			  
			
					public void bingSearchTest1() throws InterruptedException{
				    Reporter.log("Test for Books ");
				    
				    
					aLoginPage bingSearch = new aLoginPage(driver);
					bingSearch.searchBing("Dentistry");
				     
					WebDriverWait wait = new WebDriverWait(driver, 10);
				    @SuppressWarnings("unused")
					WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Images")));
                   // element.click();
				    try {
					      
					    
					      Robot robot = new Robot();
					   //   robot.mouseMove(x, y);
					      Thread.sleep(7000);
					      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
					      Thread.sleep(7000);
					      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
					      Thread.sleep(7000);
					      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
					      Thread.sleep(7000);
					      robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
					      Thread.sleep(3000);// can also use robot.setAutoDelay(500);
					    } catch (AWTException e) {
					      System.err.println("Error clicking Cancel.");
					      e.printStackTrace();
					    } catch (InterruptedException e) {
					      e.printStackTrace();
					    }
					
					   Thread.sleep(7000);
								
					  //String searchFind = "driver.getPageSource().contains(Becker Books)";
				       boolean test = driver.getPageSource().contains("dentistry");
					
				     try{
					  Assert.assertEquals(test, true);
				    // Assert.assertEquals(test, true);
				      driver.close();				     
				      Thread.sleep(2000);	
				      
				     } catch(Exception e){
						 
					Assert.assertEquals(test, false);
						 
					 }
		   
	   
         }
					
					//java.awt.event.KeyEvent
					
					
					@Test
					public void Fileupload() throws AWTException, InterruptedException{
					 
					 
					// Start browser
					// WebDriver driver = new FirefoxDriver();
					 
					// maximize browser
					 driver.manage().window().maximize();
					        
					  // Specify the file location with extension
					 StringSelection sel = new StringSelection("C:\\Users\\samuel.samuel-andoh\\Desktop\\1.docx");
					 
					   // Copy to clipboard
					 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
					 System.out.println("selection" +sel);
					 
					 
					// Open Monster.com
					// driver.get("http://my.monsterindia.com/create_account.html");
					 try {
					      
						    
					      Robot robot = new Robot();
					   //   robot.mouseMove(x, y);
					      Thread.sleep(7000);
					      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
					      Thread.sleep(7000);
					      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
					      Thread.sleep(7000);
					      robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
					      Thread.sleep(7000);
					      robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
					      Thread.sleep(3000);// can also use robot.setAutoDelay(500);
					    } catch (AWTException e) {
					      System.err.println("Error clicking Cancel.");
					      e.printStackTrace();
					    } catch (InterruptedException e) {
					      e.printStackTrace();
					    }
					     Thread.sleep(2000);
					 
					 // This will scroll down the page 
					   JavascriptExecutor js = (JavascriptExecutor)driver;
					   js.executeScript("scroll(0,350)");
					 
					    // Wait for 5 seconds
				   	 Thread.sleep(5000);
					 
				       	// This will click on Browse button
					 driver.findElement(By.name("uploadFileInput")).click();
					 
					 
					 
					 System.out.println("Browse button clicked");
					 
					 // Create object of Robot class
					 Robot robot = new Robot();
					 Thread.sleep(1000);
					      
					  // Press Enter
					 robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
					 
					// Release Enter
					// robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
					 
					  // Press CTRL+V
					 robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
					 robot.keyPress(java.awt.event.KeyEvent.VK_V);
					 
					// Release CTRL+V
					// robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
					// robot.keyRelease(java.awt.event.KeyEvent.VK_V);
					 Thread.sleep(1000);
					        
					         //Press Enter 
					 robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
					 robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
					 
					}		 
			
					 
} 
					
		