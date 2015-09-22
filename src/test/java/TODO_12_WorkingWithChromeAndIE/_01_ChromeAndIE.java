package TODO_12_WorkingWithChromeAndIE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * @summary This class reexamines the Select elements example, this time using
 *          the Chrome and IE browser. One difference between Firefox and both
 *          IE and Chrome is that both the IE and Chrome WebDriver executables
 *          must have their locations defined in the script or a helper method.
 */
public class _01_ChromeAndIE {
	WebDriver driver;

	// Define a proxy for the Dropdown link on the homepage
	@FindBy(linkText = "Dropdown")
	private WebElement lnkDropdown;
	// Define a proxy for the dropdown list
	@FindBy(id = "dropdown")
	private WebElement lstDropdown;

	@Test(priority = 1)
	public void chromeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();

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
		// Promote the WebElement to a Select element
		Select select = new Select(lstDropdown);
		// Select an option by its value
		select.selectByValue("1");
		// Sleep to allow visibility
		Thread.sleep(1000);
		// Select an option by its index in the list
		select.selectByIndex(2);
		// Sleep to allow visibility
		Thread.sleep(1000);
		// Select an option by its visible text
		select.selectByVisibleText("Option 1");
		// Sleep to allow visibility
		Thread.sleep(1000);

		// Close the current browser
		driver.close();
		// Quit the WebDriver sessions
		driver.quit();
	}
	
	@Test(priority = 2)
	public void internetExplorerTest() throws InterruptedException {
		System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
		driver = new ChromeDriver();

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
		// Promote the WebElement to a Select element
		Select select = new Select(lstDropdown);
		// Select an option by its value
		select.selectByValue("1");
		// Sleep to allow visibility
		Thread.sleep(1000);
		// Select an option by its index in the list
		select.selectByIndex(2);
		// Sleep to allow visibility
		Thread.sleep(1000);
		// Select an option by its visible text
		select.selectByVisibleText("Option 1");
		// Sleep to allow visibility
		Thread.sleep(1000);

		// Close the current browser
		driver.close();
		// Quit the WebDriver sessions
		driver.quit();
	}
}
