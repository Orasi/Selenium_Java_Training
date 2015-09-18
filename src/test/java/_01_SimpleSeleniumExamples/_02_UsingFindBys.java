package _01_SimpleSeleniumExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * @summary Define proxy elements using Selenium "FindBys", create a WebDriver,
 *          navigate to a web page, initialize the proxy elements for this page
 *          (making them tangible objects), interact with the elements, then
 *          close the browser and end the web driver session
 */
public class _02_UsingFindBys {
	// Define the proxy for the username textbox
	@FindBy(id = "employee_username")
	private WebElement txtUsername;
	// Define the proxy for the password textbox
	@FindBy(id = "employee_password")
	private WebElement txtPassword;
	// Define the proxy for the login button
	@FindBy(name = "commit")
	private WebElement btnLogin;

	@Test
	public void test() {
		// Create a new WebDriver
		WebDriver driver = new FirefoxDriver();
		// Navigate to the BlueSource homepage
		driver.get("https://bluesourcestaging.herokuapp.com");
		// Use Selenium's PageFactory to initialize the proxy elements
		PageFactory.initElements(driver, this);
		// Set the value for the username textbox
		txtUsername.sendKeys("company.admin");
		// Set the value for the password textbox
		txtPassword.sendKeys("test");
		// Click the login button
		btnLogin.click();
		// Close the current browser
		driver.close();
		// Quit the WebDriver sessions
		driver.quit();
	}
}
