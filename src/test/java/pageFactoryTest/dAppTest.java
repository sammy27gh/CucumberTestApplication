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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.aLoginPage;

public class dAppTest {
	 
	WebDriver driver;
	  
	@BeforeTest
	   public void setup1(){
	 
	  driver = new FirefoxDriver();
	 
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	  //driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
	  driver.get("http://www.bing.com/");

	    }



	//@Test
	public void parameter() throws InterruptedException, ClassNotFoundException, SQLException{
		
		setup1();
	   
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
	 				 
	 	     	setup1();
	 		
	
 		}	
 		
		   
	}   
}