
package login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class aLoginPage {
	
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
	
	
	// Elements to click around the web to validate the navigate().clicks
    @FindBy(how =  How.LINK_TEXT, using = "FREE SELENIUM WEBDRIVER TRAINING ONLINE")
    WebElement SELENIUM;
    
    @FindBy(how =  How.LINK_TEXT, using = "ABOUT")
    WebElement about;
    
    @FindBy(how =  How.LINK_TEXT, using = "BLOG POSTS")
    WebElement blog;
	
	
	// constructor for the class
	public aLoginPage(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
	}

	// this method types in and click the to login. 
	public void login(String UName, String Password){
		Reporter.log("validate UserName ");
		UserName.sendKeys(UName);
		Next.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Validate the Password ");
		Pass.sendKeys(Password);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Reporter.log("Validate the Submit Page");
		submit.click();
	}
	// This method checks for the search term
         public void searchBing(String SearchTerm){    
        	 Reporter.log("validate Search Field ");
        	 Search.sendKeys(SearchTerm);   
        	 Reporter.log("validate Search Button");
        	 clickSearch.click();
        	 
        	 
         }
         
         // Find the the news link on top of the page 
         @FindBy(how =  How.ID, using = "scpl3")
         WebElement News;
         
         // click on the News  link
            public void News(){
           	News.click();
        	 
         }
            
       
            
           public void checkNavigation() throws InterruptedException{
        	
            SELENIUM.click();
	        Thread.sleep(5000);
				

            about.click();
	        Thread.sleep(5000);
        	   

            blog.click();
	        Thread.sleep(5000);
        	   
           } 
            
            
            
            
            
            
         
            /*
		   	  * We are going to upload the file into the application. 
		   	  * 
		   	  * */
		       	// This will click on Browse button
            public void uploadAnyFile(String BrowseWebProperty, String PathtoFiletoUpload ) throws Exception{
            	//uploadFileInput
            	
            	  // Specify the file location with extension
				 StringSelection sel = new StringSelection(PathtoFiletoUpload);
				 
				   // Copy to clipboard
				 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
				 System.out.println("selection" +sel);
				 
				 //Locate the WebElement that has the browser property.
				 driver.findElement(By.name(BrowseWebProperty)).click();
				 
				 // Create object of Robot class
				 Robot robot = new Robot();
				 Thread.sleep(1000);
				      
				  // Press Enter
				 robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
				  // Press CTRL+V
				 robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
				 robot.keyPress(java.awt.event.KeyEvent.VK_V);
			
				 Thread.sleep(1000);
				        
				         //Press Enter 
				 robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
				 robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);	
            	
            	
            	
            }
            
            
            // method to connect to the database 
            
            public void  Database() throws ClassNotFoundException, SQLException{
          	  
          		String userName = "sa";
          		String password = "Sk@456321";

          		String url = "jdbc:sqlserver://104.37.189.218\\SQLEXPRESS;databaseName=Books";

          		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          		Connection conn = DriverManager.getConnection(url, userName, password);
          		Statement sta =  conn.createStatement();
          		String Sql = "SELECT * FROM cELEBRITY.[dbo].[Celebrity]";
          		ResultSet rs = sta.executeQuery(Sql);
          		while (rs.next()) {
          			System.out.println(rs.getString(1)); 
          			boolean News = driver.getPageSource().contains(rs.getString(1));
        			Assert.assertEquals(News, true);
          	  
          		}

           }
}

