/**
 * 
 */
/**
 * @author samuel
 *
 */
package pageFactoryTest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.aLoginPage;

public class dAppTest {
	 
	WebDriver driver;
	 
	static String driverPath = "C:\\Users\\samuel.samuel-andoh\\Downloads\\";
	
	
	//@BeforeTest
	public void setup() {
		System.out.println("*******************");
		System.out.println("launching IE browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.bing.com/");
	}

	//@Test
	public void parameter() throws InterruptedException, ClassNotFoundException, SQLException{
		
		setup();
	   
		// put the data base method in here 
		
		String userName = "sa";
 		String password = "Sk@456321";

 		String url = "jdbc:sqlserver://104.37.189.218\\SQLEXPRESS;databaseName=Books";

 		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 		Connection conn = DriverManager.getConnection(url, userName, password);
 		Statement sta =  conn.createStatement();
 		String Sql = "select * from Books.[dbo].[seleniumTestData]";
 		ResultSet rs = sta.executeQuery(Sql);
 		while (rs.next()) {
 			
 			System.out.println(rs.getString(1)); 
 		// This is where we test with the database to see if the connection is possible
			  
				aLoginPage newsTest = new aLoginPage(driver);
				
				newsTest.searchBing(rs.getString(1));
				Thread.sleep(9000);
				
				boolean test = driver.getPageSource().contains("o");
			
			
			Assert.assertEquals(test, true);
			 Thread.sleep(4000);

	 	     	driver.close();
	 				 
	 	     	setup();
	 		
	
 		}	
 		
		   
	}   
}