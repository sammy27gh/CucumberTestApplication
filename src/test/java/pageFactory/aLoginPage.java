
package pageFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

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

