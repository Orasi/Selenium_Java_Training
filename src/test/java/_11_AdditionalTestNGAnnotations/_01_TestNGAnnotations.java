package _11_AdditionalTestNGAnnotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @summary This class exposes some basic TestNG behavior using predefined
 *          annotations.
 * @see http://testng.org/doc/documentation-main.html#annotations         
 */
public class _01_TestNGAnnotations {
	//Declare a WebDriver
	WebDriver driver;
	//Declare a WebElement
	WebElement element;
	
	//Define a proxy for the Dropdown link on the homepage
	@FindBy(linkText = "Dropdown")
	private WebElement lnkDropdown;
	//Define a proxy for the dropdown list
	@FindBy(id = "dropdown")
	private WebElement lstDropdown;
	
	/**
	 * @summary will be run before any test method belonging to the classes inside the <test> tag is run
	 */
	@BeforeTest
	public void beforeTest() {
		//Create a WebDriver
		driver = new FirefoxDriver();
		//Navigate to a web page
		driver.get("http://the-internet.herokuapp.com/");
		// Use Selenium's PageFactory to initialize the proxy elements
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void test() throws InterruptedException{
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
	}
	
	/**
	 * @summary will be run after all the test methods belonging to the classes inside the <test> tag have run. 
	 */
	@AfterTest
	public void afterTest(){
		// Close the current browser
		driver.close();
		// Quit the WebDriver sessions
		driver.quit();
	}

}
