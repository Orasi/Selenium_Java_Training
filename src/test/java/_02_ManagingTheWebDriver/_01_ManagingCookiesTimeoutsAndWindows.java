package _02_ManagingTheWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @summary Create a WebDriver, manage the WebDriver cookies, timeouts and
 *          browser window, navigate to a web page, use the driver to locate and
 *          interact with WebElements, then close the browser and end the web
 *          driver session
 */
public class _01_ManagingCookiesTimeoutsAndWindows {
	@Test
	public void test() {
		// Create a new WebDriver
		WebDriver driver = new FirefoxDriver();

		// Delete all cookies from the cache
		driver.manage().deleteAllCookies();
		/*
		 * Set the implicit wait timeout - the amount of time the driver will
		 * search for a WebElement if it is not immediately present
		 */
		driver.manage().timeouts().implicitlyWait((long) 10.0, TimeUnit.SECONDS);
		/*
		 * Set the page load timeout - the amount of time the driver will wait
		 * for the page to be completely loaded
		 */
		driver.manage().timeouts().pageLoadTimeout((long) 20.0, TimeUnit.SECONDS);
		/*
		 * Set the script timeout - the amount of time the WebDriver will wait for a command from the script
		 */
		driver.manage().timeouts().setScriptTimeout((long) 20.0, TimeUnit.SECONDS);
		/*
		 * Maximize the window to fit the screen
		 */
		driver.manage().window().maximize();

		// Navigate to the BlueSource homepage
		driver.get("https://bluesourcestaging.herokuapp.com");
		// Use the driver to locate the username textbox and set it's value
		driver.findElement(By.id("employee_username")).sendKeys("company.admin");
		// Use the driver to locate the password textbox and set it's value
		driver.findElement(By.id("employee_password")).sendKeys("test");
		// Use the driver to locate the login button and click it
		driver.findElement(By.name("commit")).click();
		// Close the current browser
		driver.close();
		// Quit the WebDriver sessions
		driver.quit();
	}
}
