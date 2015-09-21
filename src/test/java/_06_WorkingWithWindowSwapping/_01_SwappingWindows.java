package _06_WorkingWithWindowSwapping;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class _01_SwappingWindows {

	/**
	 * @summary Create a driver, navigate to a window, capture the first window
	 *          handle, click a link in such a way as to open a second window,
	 *          determine the second window handle then swap to it, interact
	 *          with an object on the second window, swap back to the first
	 *          window, close and then quit the browser
	 * @throws InterruptedException
	 */
	@Test
	public void test() throws InterruptedException {
		// Create a driver
		WebDriver driver = new FirefoxDriver();
		// Define the key chain used to click a link and open a new window
		String selectLinkOpeninNewTab = Keys.chord(Keys.SHIFT, Keys.RETURN);
		// Define a variable to hold the first window handle
		String firstWindowHandle = driver.getWindowHandle();
		// Define a variable to hold the second window handle
		String secondWindowHandle = null;

		// Navigate to the desired webpage
		driver.get("http://the-internet.herokuapp.com/");
		// Locate and element and send the key chain to open the second window
		driver.findElement(By.linkText("Dropdown")).sendKeys(selectLinkOpeninNewTab);

		// Wait until the driver contains more than one window handle
		do {
			Thread.sleep(500);
		} while (driver.getWindowHandles().size() < 2);
		// Determine the second window handle
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equalsIgnoreCase(firstWindowHandle)) {
				secondWindowHandle = handle;
			}
		}
		// Switch to the new window
		driver.switchTo().window(secondWindowHandle);

		//Interact with the second window
		interactWithNewWindow(driver);

		// Return control to the first window
		driver.switchTo().window(firstWindowHandle);

		// Close the driver
		driver.close();
		// Quit the browser session
		driver.quit();
		System.out.println("First Window Handle: " + firstWindowHandle);
		System.out.println("Second Window Handle: " + secondWindowHandle);
	}

	/**
	 * @summary Contains behavior to interact with a second window, which to
	 *          which control has been given to the driver
	 * @param driver - WebDriver for the test
	 * @throws InterruptedException - Exception handling for Thread.sleep()
	 */
	private void interactWithNewWindow(WebDriver driver) throws InterruptedException {
		// Define an element on the second window
		Select select = new Select(driver.findElement(By.id("dropdown")));
		// Interact with the element on the second page
		select.selectByVisibleText("Option 1");
		Thread.sleep(1000);
		select.selectByVisibleText("Option 2");
		Thread.sleep(1000);
	}
}
