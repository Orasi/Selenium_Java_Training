package _08_WorkingWithJavaScriptAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @summary This class demonstrates how to interact with various types of
 *          alerts. Selenium tends to treat alerts in a general manner, in that
 *          if an alert is found, an accept (OK, Yes, etc) or a dismiss (No,
 *          Cancel, etc) is used to interact with it. Additional features, such
 *          as sending keys, are unique to different types of alerts.
 */
public class _01_Alerts {
	// Declare a WebDriver
	WebDriver driver;
	// Declare a WebElement
	WebElement element;
	// Declare a WebElement that holds the resulting text from interactions
	WebElement result;
	// Declare an Alert
	Alert alert;
	// Declare and define a message to be used with a JavaScript prompt
	String promptMessage = "Come along, Pond!";

	/**
	 * @summary Interacts with a JavaScript alert, reporting the enclosed text,
	 *          closing the object and verifying the expected behavior is
	 *          performed
	 * @throws InterruptedException
	 */
	@Test
	public void javaScriptAlert() throws InterruptedException {
		//Create a new WebDriver
		driver = new FirefoxDriver();
		//Navigate to a web page
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		//Find the first alert trigger
		element = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button"));
		//Click the first alert trigger
		element.click();
		//Allow some time for the alert to open
		Thread.sleep(1000);
		//Switch to the alert
		alert = driver.switchTo().alert();
		//Output the alert text
		System.out.println("JavaScript Alert Text: " + alert.getText());
		//"Accept" the alert
		alert.accept();
		//Allow time for the alert to close
		Thread.sleep(1000);
		//Grab the text from the result element
		result = driver.findElement(By.id("result"));
		//Compare the result text to that which is expected
		if (result.getText().equalsIgnoreCase("You successfuly clicked an alert")) {
			System.out.println("Output as expected.");
		} else {
			System.out.println("Output not as expected.");
		}
	}

	@Test(dependsOnMethods = { "javaScriptAlert" })
	public void javaScriptConfirm() throws InterruptedException {
		//Find the second alert trigger
		element = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button"));
		//Click the second alert trigger
		element.click();
		//Allow some time for the alert to open
		Thread.sleep(1000);
		//Switch to the alert
		alert = driver.switchTo().alert();
		//Output the alert text
		System.out.println("JavaScript Confirm Text: " + alert.getText());
		//"Accept" the alert
		alert.accept();
		//Allow time for the alert to close
		Thread.sleep(1000);
		//Compare the result text to that which is expected
		if (result.getText().equalsIgnoreCase("You clicked: Ok")) {
			System.out.println("Output as expected.");
		} else {
			System.out.println("Output not as expected.");
		}

		//Find the second alert trigger again
		element = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button"));
		//Click the second alert trigger again
		element.click();
		//Allow some time for the alert to open
		Thread.sleep(1000);
		//Switch to the alert
		alert = driver.switchTo().alert();
		//Output the alert text
		System.out.println("JavaScript Confirm Text: " + alert.getText());
		//"Dismiss" the alert
		alert.dismiss();
		//Allow time for the alert to close
		Thread.sleep(1000);
		//Compare the result text to that which is expected
		if (result.getText().equalsIgnoreCase("You clicked: Cancel")) {
			System.out.println("Output as expected.");
		} else {
			System.out.println("Output not as expected.");
		}
	}

	@Test(dependsOnMethods = { "javaScriptAlert", "javaScriptConfirm" })
	public void javaScriptPrompt() throws InterruptedException {
		//Find the third alert trigger
		element = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button"));
		//Click the third alert trigger
		element.click();
		//Allow some time for the alert to open
		Thread.sleep(1000);
		//Switch to the alert
		alert = driver.switchTo().alert();
		//Output the alert text
		System.out.println("JavaScript Prompt Text: " + alert.getText());
		//Send a string to the alert prompt
		alert.sendKeys(promptMessage);
		//"Accept" the alert
		alert.accept();
		//Allow time for the alert to close
		Thread.sleep(1000);
		//Compare the result text to that which is expected
		if (result.getText().equalsIgnoreCase("You entered: " + promptMessage)) {
			System.out.println("Output as expected.");
		} else {
			System.out.println("Output not as expected.");
		}

		//Find the third alert trigger again
		element = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button"));
		//Click the third alert trigger again
		element.click();
		//Allow some time for the alert to open
		Thread.sleep(1000);
		//Switch to the alert
		alert = driver.switchTo().alert();
		//Output the alert text
		System.out.println("JavaScript Prompt Text: " + alert.getText());
		//"Dismiss" the alert
		alert.dismiss();
		//Allow time for the alert to close
		Thread.sleep(1000);
		//Compare the result text to that which is expected
		if (result.getText().equalsIgnoreCase("You entered: null")) {
			System.out.println("Output as expected.");
		} else {
			System.out.println("Output not as expected.");
		}

		//Close the borwser
		driver.close();
		//Quit the browser session
		driver.quit();
	}
}
