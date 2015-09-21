package _03_WorkingWithSelects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * @summary Define proxy WebElements, create a WebDriver, navigate to a web page
 *          with a dropdown list, initialize the proxies, promote a WebElement
 *          to a Select element, use the driver to locate and interact with the
 *          Select element, then close the browser and end the web driver
 *          session
 */
public class _01_SelectElements {
	//Define a proxy for the Dropdown link on the homepage
	@FindBy(linkText = "Dropdown")
	private WebElement lnkDropdown;
	//Define a proxy for the dropdown list
	@FindBy(id = "dropdown")
	private WebElement lstDropdown;

	@Test
	public void test() throws InterruptedException {
		// Create a new WebDriver
		WebDriver driver = new FirefoxDriver();
		// Navigate to the Internet homepage
		driver.get("http://the-internet.herokuapp.com/");
		// Use Selenium's PageFactory to initialize the proxy elements
		PageFactory.initElements(driver, this);
		// Click the dropdown link
		lnkDropdown.click();

		
		/*
		 * Use Selenium's PageFactory to reinitialize the proxy elements to
		 * avoid a StaleElementReferenceException or an ElementNotFoundException
		 */
		PageFactory.initElements(driver, this);
		//Promote the WebElement to a Select element
		Select select = new Select(lstDropdown);
		//Select an option by its value
		select.selectByValue("1");
		//Sleep to allow visibility
		Thread.sleep(1000);
		//Select an option by its index in the list
		select.selectByIndex(2);
		//Sleep to allow visibility
		Thread.sleep(1000);
		//Select an option by its visible text
		select.selectByVisibleText("Option 1");
		//Sleep to allow visibility
		Thread.sleep(1000);


		// Close the current browser
		driver.close();
		// Quit the WebDriver sessions
		driver.quit();
	}
}
