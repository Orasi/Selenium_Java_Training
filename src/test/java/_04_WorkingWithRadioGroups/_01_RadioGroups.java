package _04_WorkingWithRadioGroups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * @summary Define and list of WebElements and a proxy element using Selenium "FindBy", create a WebDriver,
 *          navigate to a web page, initialize the proxy element for this page
 *          (making them tangible objects), interact with the elements, then
 *          close the browser and end the web driver session
 */
public class _01_RadioGroups {
	//Define a List of WebElements
	List<WebElement> eleRadiosButtons = null;
	//Define the proxy for the "radio group"
	@FindBy(css = "#main > p:nth-child(34)")
	private WebElement radRadioGroup;
	
	
	@Test
	public void test() throws InterruptedException{
		// Create a new WebDriver
		WebDriver driver = new FirefoxDriver();
		//Navigate to a page that has radio buttons
		driver.get("http://www.w3schools.com/html/html_forms.asp");
		//Initialize the proxies for this page
		PageFactory.initElements(driver, this);
		
		
		
		//Grab the child elements (actual radio buttons) for the "radio group"
		eleRadiosButtons = radRadioGroup.findElements(By.name("sex"));
		//Iterate through each element in the List and clck on it
		for(WebElement element : eleRadiosButtons){
			element.click();
			Thread.sleep(1000);
		}
		
		

		// Close the current browser
		driver.close();
		// Quit the WebDriver sessions
		driver.quit();
	}
}
