package _13_WaitsAndExpectedConditions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @summary This class reexamines the JavaScript Alert example as well as the Frame Swapping example, this time using
 *          WebDriverWaits.
 */
public class _01_WaitsAndExpectedConditions {
	// Declare a WebDriver
	WebDriver driver;
	// Declare a WebDriverWait
	WebDriverWait wait;
	// Declare an Alert
	Alert alert;
	// Declare and define a message to be used with a JavaScript prompt
	String promptMessage = "Come along, Pond!";
	
	@FindBy(css = "#content > div > ul > li:nth-child(1) > button")
	private WebElement trigger1;
	
	@FindBy(css = "#content > div > ul > li:nth-child(2) > button")
	private WebElement trigger2;
	
	@FindBy(css = "#content > div > ul > li:nth-child(3) > button")
	private WebElement trigger3;
	
	@FindBy(id = "result")
	private WebElement result;

	/**
	 * @summary Interacts with a JavaScript alert, reporting the enclosed text,
	 *          closing the object and verifying the expected behavior is
	 *          performed
	 * @throws InterruptedException
	 */
	@Test
	public void javaScriptAlert() throws InterruptedException {
		// Create a new WebDriver
		driver = new FirefoxDriver();
		// Define a WebDriverWait
		wait = new WebDriverWait(driver, (long) 10.0);
		// Navigate to a web page
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		//Wait for the title to contain some specific text
		wait.until(ExpectedConditions.titleIs("The Internet"));
		wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/javascript_alerts"));
		//Initialize elements on this page
		PageFactory.initElements(driver, this);
		//Wait for the first trigger element to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(trigger1));
		//Wait for the first trigger to contain some specific text
		wait.until(ExpectedConditions.textToBePresentInElement(trigger1, "Click for JS Alert"));
		//Wait for the first trigger to be visible on the page
		wait.until(ExpectedConditions.visibilityOf(trigger1));
		// Click the first alert trigger
		trigger1.click();
		// Wait until an alert is present
		wait.until(ExpectedConditions.alertIsPresent());
		// Switch to the alert
		alert = driver.switchTo().alert();
		// Output the alert text
		System.out.println("JavaScript Alert Text: " + alert.getText());
		// "Accept" the alert
		alert.accept();
		// Allow time for the alert to close
		Thread.sleep(1000);
		//Wait for the first trigger to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(trigger1));
		// Compare the result text to that which is expected
		wait.until(ExpectedConditions.textToBePresentInElement(result, "You successfuly clicked an alert"));
	}

	@Test(dependsOnMethods = { "javaScriptAlert" })
	public void javaScriptConfirm() throws InterruptedException {
		//Initialize elements on this page
		PageFactory.initElements(driver, this);
		//Wait for the first trigger element to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(trigger2));
		//Wait for the first trigger to contain some specific text
		wait.until(ExpectedConditions.textToBePresentInElement(trigger2, "Click for JS Confirm"));
		//Wait for the first trigger to be visible on the page
		wait.until(ExpectedConditions.visibilityOf(trigger2));
		// Click the second alert trigger
		trigger2.click();
		// Wait until an alert is present
		wait.until(ExpectedConditions.alertIsPresent());
		// Switch to the alert
		alert = driver.switchTo().alert();
		// Output the alert text
		System.out.println("JavaScript Confirm Text: " + alert.getText());
		// "Accept" the alert
		alert.accept();
		// Allow time for the alert to close
		Thread.sleep(1000);
		//Wait for the first trigger to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(trigger2));
		// Compare the result text to that which is expected
		wait.until(ExpectedConditions.textToBePresentInElement(result, "You clicked: Ok"));


		//Initialize elements on this page
		PageFactory.initElements(driver, this);
		//Wait for the first trigger element to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(trigger2));
		//Wait for the first trigger to contain some specific text
		wait.until(ExpectedConditions.textToBePresentInElement(trigger2, "Click for JS Confirm"));
		//Wait for the first trigger to be visible on the page
		wait.until(ExpectedConditions.visibilityOf(trigger2));
		// Click the second alert trigger
		trigger2.click();
		// Wait until an alert is present
		wait.until(ExpectedConditions.alertIsPresent());
		// Switch to the alert
		alert = driver.switchTo().alert();
		// Output the alert text
		System.out.println("JavaScript Confirm Text: " + alert.getText());
		// "Dismiss" the alert
		alert.dismiss();
		// Allow time for the alert to close
		Thread.sleep(1000);
		//Wait for the first trigger to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(trigger2));
		// Compare the result text to that which is expected
		wait.until(ExpectedConditions.textToBePresentInElement(result, "You clicked: Cancel"));
	}

	@Test(dependsOnMethods = { "javaScriptAlert", "javaScriptConfirm" })
	public void javaScriptPrompt() throws InterruptedException {
		//Initialize elements on this page
		PageFactory.initElements(driver, this);
		//Wait for the first trigger element to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(trigger3));
		//Wait for the first trigger to contain some specific text
		wait.until(ExpectedConditions.textToBePresentInElement(trigger3, "Click for JS Prompt"));
		//Wait for the first trigger to be visible on the page
		wait.until(ExpectedConditions.visibilityOf(trigger3));
		// Click the second alert trigger
		trigger3.click();
		// Wait until an alert is present
		wait.until(ExpectedConditions.alertIsPresent());
		// Switch to the alert
		alert = driver.switchTo().alert();
		// Output the alert text
		System.out.println("JavaScript Prompt Text: " + alert.getText());
		// Send a string to the alert prompt
		alert.sendKeys(promptMessage);
		// "Accept" the alert
		alert.accept();
		// Allow time for the alert to close
		Thread.sleep(1000);
		//Wait for the first trigger to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(trigger3));
		// Compare the result text to that which is expected
		wait.until(ExpectedConditions.textToBePresentInElement(result, "You entered: " + promptMessage));


		//Initialize elements on this page
		PageFactory.initElements(driver, this);
		// Click the second alert trigger
		trigger3.click();
		// Wait until an alert is present
		wait.until(ExpectedConditions.alertIsPresent());
		// Switch to the alert
		alert = driver.switchTo().alert();
		// Output the alert text
		System.out.println("JavaScript Prompt Text: " + alert.getText());
		// "Dismiss" the alert
		alert.dismiss();
		// Allow time for the alert to close
		Thread.sleep(1000);
		//Wait for the first trigger to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(trigger3));
		// Compare the result text to that which is expected
		wait.until(ExpectedConditions.textToBePresentInElement(result, "You entered: null"));

		// Close the browser
		driver.close();
		// Quit the browser session
		driver.quit();
	}
	
	@Test(dependsOnMethods = { "javaScriptAlert", "javaScriptConfirm", "javaScriptPrompt" })
	public void test() {
		// Define a field that will hold the text of a given frame
		String frameText;
		// Create a new WebDriver
		driver = new FirefoxDriver();
		// Create a new WebDriverWait - used to demostrate a second technique
		// for switching frames
		wait = new WebDriverWait(driver, (long) 10.0);
		// Navigate to the webpage with nested frames
		driver.get("http://the-internet.herokuapp.com/nested_frames");

		//***************************
		//*	SWITCH TO THE TOP FRAME *
		//***************************
		// From the default content, navigate to the top frame
		driver.switchTo().frame("frame-top");

				// Define the child frames
				WebElement leftFrame = driver.findElement(By.name("frame-left"));
				WebElement middleFrame = driver.findElement(By.name("frame-middle"));
				WebElement rightFrame = driver.findElement(By.name("frame-right"));

				//********************************
				//*	SWITCH TO THE TOP-LEFT FRAME *
				//********************************
				// Switch to the top-left child frame
//				driver.switchTo().frame(leftFrame);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(leftFrame));
				// Grab the text from the frame
				frameText = driver.findElement(By.xpath("/html/body")).getText();
				// Output the text from the frame
				System.out.println("\n\n******************************************************");
				System.out.println("TOP-LEFT FRAME TEXT: " + frameText);

				//**********************************
				//*	SWITCH TO THE TOP-MIDDLE FRAME *
				//**********************************
				// Switch to the default content
				driver.switchTo().defaultContent();
				// Switch to the top frame
//				driver.switchTo().frame("frame-top");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame-top"));
				// Switch to the top-middle frame
//				driver.switchTo().frame(middleFrame);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(middleFrame));
				// Grab the text from the frame
				frameText = driver.findElement(By.xpath("/html/body")).getText();
				// Output the text from the frame
				System.out.println("TOP-MIDDLE FRAME TEXT: " + frameText);

				//*********************************
				//*	SWITCH TO THE TOP-RIGHT FRAME *
				//*********************************
				// Switch to the default content
				driver.switchTo().defaultContent();
				// Switch to the top frame
//				driver.switchTo().frame("frame-top");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame-top"));
				// Switch to the top-right frame
//				driver.switchTo().frame(rightFrame);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(rightFrame));
				// Grab the text from the frame
				frameText = driver.findElement(By.xpath("/html/body")).getText();
				// Output the text from the frame
				System.out.println("TOP-RIGHT FRAME TEXT: " + frameText);

		//******************************
		//*	SWITCH TO THE BOTTOM FRAME *
		//******************************
		// Switch to the default content
		driver.switchTo().defaultContent();
		// Switch to the bottom frame
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("frame-bottom"))));
		// Grab the text from the frame
		frameText = driver.findElement(By.xpath("/html/body")).getText();
		// Output the text from the frame
		System.out.println("BOTTOM FRAME TEXT: " + frameText + "\n");
		System.out.println("******************************************************\n\n");

		//Close the current browser
		driver.close();
		//Quit the current WebDriver session
		driver.quit();
	}
}
