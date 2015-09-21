package _09_WorkingWithJavaScriptExecutors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @summary This class demonstrates useful ways to inject scripts into the
 *          JavaScript engine that drives the browser. In this way you can
 *          interact with object when traditional Selenium methods do not seem
 *          to work. This does mean that you are injecting JavaScript into the
 *          DOM and altering the application, so this option should be seen as a
 *          last result.
 */
public class _01_JavaScriptExecutors {
	// Define a WebDriver
	WebDriver driver;
	// Define a WebElement
	WebElement element;
	// Define a JavaScript executor
	JavascriptExecutor jse;
	// Define a timeout for DOM ready states
	int timeout = 20;

	@Test
	public void test() throws InterruptedException {
		// Create a WebDriver
		driver = new FirefoxDriver();
		// Create a JavaScriptExecutor
		jse = (JavascriptExecutor) driver;
		// Navigate to the application homepage
		driver.get("http://the-internet.herokuapp.com/");
		// Grab an element to interact with
		element = driver.findElement(By.linkText("Sortable Data Tables"));

		// Use JavaScript to scroll an element into view
		scrollIntoView();
		// Use JavaScript to highlight an element
		highlight();
		// User JavaScript to click an element
		jsClick();
		// Use JavaSCript to determine the HTML DOM ready state
		System.out.println("\n\n******************************************");
		System.out.println("DOM IS COMPLETE: " + String.valueOf(isDomComplete()));
		System.out.println("DOM OS INTERACTIVE: " + String.valueOf(isDomInteractive()));
		System.out.println("******************************************\n\n");

		// Close the browser
		driver.close();
		// Quit the current WebDriver session
		driver.quit();
	}

	/**
	 * @summary Uses JavaScript to highlight an element in the application
	 */
	public void highlight() {
		jse.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	/**
	 * @summary Uses JavaScript to scroll an element into view
	 */
	public void scrollIntoView() {
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Uses JavaScript to scroll an element into view and then click it
	 */
	public void jsClick() {
		jse.executeScript("arguments[0].scrollIntoView(true);arguments[0].click();", element);
	}

	/**
	 * Uses JavaScript to determine if the HTML DOM readyState is "complete."
	 * The readyState can have 1 of 5 values:
	 * 		uninitialized - Has not started loading yet
	 * 		loading - Is loading
	 *		loaded - Has been loaded
	 *		interactive - Has loaded enough and the user can interact with it
	 * 		complete - Fully loaded
	 * @return Boolean true if the readyState is complete, false otherwise
	 * @throws InterruptedException
	 *             Exception handling for Thread.sleep()
	 */
	public boolean isDomComplete() throws InterruptedException {
		int count = 0;
		Object obj = null;

		do {
			// this returns a boolean
			obj = jse.executeScript("var result = document.readyState; return (result == 'complete');");
			if (count == timeout) {
				return obj.equals(true);
			}
			Thread.sleep(500);
			count++;
		} while (obj.equals(false));

		return obj.equals(true);
	}

	/**
	 * Uses JavaScript to determine if the HTML DOM readyState is "complete" or
	 * "interactive." This accepts a less than complete readyState.
	 * The readyState can have 1 of 5 values:
	 * 		uninitialized - Has not started loading yet
	 * 		loading - Is loading
	 *		loaded - Has been loaded
	 *		interactive - Has loaded enough and the user can interact with it
	 * 		complete - Fully loaded
	 * @return Boolean true if the readyState is complete or interactive, false
	 *         otherwise
	 * @throws InterruptedException
	 *             Exception handling for Thread.sleep()
	 */
	public boolean isDomInteractive() throws InterruptedException {
		int count = 0;
		Object obj = null;

		do {
			// this returns a boolean
			obj = jse.executeScript(
					"var result = document.readyState; return (result == 'complete' || result == 'interactive');");
			if (count == timeout) {
				return obj.equals(true);
			}
			Thread.sleep(500);
			count++;
		} while (obj.equals(false));

		return obj.equals(true);
	}
}
