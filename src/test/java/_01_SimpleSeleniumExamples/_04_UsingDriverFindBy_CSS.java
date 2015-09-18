package _01_SimpleSeleniumExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @summary Create a WebDriver, navigate to a web page, use the driver to
 *          locate (using CSS) and interact with WebElements, then close the browser and end
 *          the web driver session
 */
public class _04_UsingDriverFindBy_CSS {
	@Test
	public void test() {
		//Create a new WebDriver
		WebDriver driver = new FirefoxDriver();
		//Navigate to the BlueSource homepage
		driver.get("https://bluesourcestaging.herokuapp.com");
		//Use the driver to locate the username textbox and set it's value
		driver.findElement(By.cssSelector("#employee_username")).sendKeys("company.admin");
		//Use the driver to locate the password textbox and set it's value
		driver.findElement(By.cssSelector("#employee_password")).sendKeys("test");
		//Use the driver to locate the login button and click it
		driver.findElement(By.cssSelector("#new_employee > div.container.login-form > div:nth-child(3) > input")).click();
		//Close the current browser
		driver.close();
		//Quit the WebDriver sessions
		driver.quit();
	}
}
