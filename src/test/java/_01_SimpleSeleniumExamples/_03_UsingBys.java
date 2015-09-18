package _01_SimpleSeleniumExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @summary Use Selenium "By" locators to define values to be used by the driver
 *          to find elements, create a WebDriver, navigate to a web page, use
 *          the driver to locate and interact with WebElements,then close the
 *          browser and end the web driver session
 */
public class _03_UsingBys {
	By byUsername = By.id("employee_username");
	By byPassword = By.id("employee_password");
	By byLogin = By.name("commit");

	@Test
	public void test() {
		// Create a new WebDriver
		WebDriver driver = new FirefoxDriver();
		// Navigate to the BlueSource homepage
		driver.get("https://bluesourcestaging.herokuapp.com");
		// Use the driver to locate the username textbox and set it's value
		driver.findElement(byUsername).sendKeys("company.admin");
		// Use the driver to locate the password textbox and set it's value
		driver.findElement(byPassword).sendKeys("test");
		// Use the driver to locate the login button and click it
		driver.findElement(byLogin).click();
		// Close the current browser
		driver.close();
		// Quit the WebDriver sessions
		driver.quit();
	}
}
