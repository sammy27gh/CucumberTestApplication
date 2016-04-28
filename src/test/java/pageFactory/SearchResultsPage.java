package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

	WebDriver driver;
	 String textValue;
	
	// constructor for the class
		public SearchResultsPage(WebDriver driver){
			this.driver = driver;
		PageFactory.initElements(driver, this);
		
		}
		//search for the page search text from the search results page 
		


		
}
