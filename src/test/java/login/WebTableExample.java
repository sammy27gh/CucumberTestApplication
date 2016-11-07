package login;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class WebTableExample {
 
	public static void main(String[] args) {
 
	String part1 = "//*[@id='main']/table[1]/tbody/tr[";
	String part2 = "]/td[";
	String part3= "]";
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\samuel.samuel-andoh\\Downloads\\chromedriver.exe");
	//ChromeDriver driver = new ChromeDriver();
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://www.w3schools.com/html/html_tables.asp");
	WebElement table = driver.findElement(By.xpath("//*[@id='main']/table[1]/tbody"));
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	System.out.println("total rows--"+rows.size());
	List<WebElement> columns =rows.get(0).findElements(By.tagName("th"));
	System.out.println("total columns--"+columns.size());
	for(int i=1;i<rows.size();i++){
	  for(int j=0;j<columns.size();j++){
		String xpathValue = part1+(i+1)+part2+(j+1)+part3;
		System.out.print(driver.findElement(By.xpath(xpathValue)).getText());
		System.out.print("\t");
		System.out.print("");
	   }
              
	
		
 
	}
 
}
}