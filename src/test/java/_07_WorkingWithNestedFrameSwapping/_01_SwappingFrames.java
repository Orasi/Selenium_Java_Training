package _07_WorkingWithNestedFrameSwapping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @summary This class deals with switching between nested frames in a web
 *          application. A collection of frames is called a frameset; you do not
 *          actively interact with framesets in this class, but the concept is
 *          useful to understand when navigating between frames. When a page
 *          first loads, the driver will be pointed at the default content; for
 *          this exercise, it helps to think of it as the top-most parent of the
 *          HTML. To get to a nested frame, you must first navigate through it's
 *          parent frames. Once the desired frame is reached, you may interact
 *          with the elements as usual (Keep in mind that some things, like
 *          xpath. will be relative to the current frame).
 * 
 *          EXAMPLE 1 - Navigating to child frames: If frame 1c is nested inside
 *          frame 1b, which is nested inside frame 1a, you must first switch to
 *          frame 1a, then switch to frame 1b, then switch to frame 1c, and then
 *          the elements within 1c can be properly interacted with by the
 *          driver.
 * 
 *          Once inside a nested frame, should you need to use elements inside
 *          another frame that is not a child frame of the current frame, then
 *          you must back all of the way out and reestablish contact with the
 *          default content. This will be the case whether working within the
 *          same frameset, or a different frameset altogether.
 * 
 *          EXAMPLE 2 - Navigating to frames outside of the current frameset: If
 *          you are in frame 1c and wish to navigate to frame 2a (read: a
 *          different frameset), then you must first switch back to the default
 *          content, then switch to frame 2a
 * 
 *          Two methods will be shown for switching frames: 1.
 *          driver.switchTo().frame() 2.
 *          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver
 *          .findElement(By.name())))
 */
public class _01_SwappingFrames {
	// Define a field that will hold the text of a given frame
	String frameText;

	@Test
	public void test() {
		// Create a new WebDriver
		WebDriver driver = new FirefoxDriver();
		// Create a new WebDriverWait - used to demostrate a second technique
		// for switching frames
		WebDriverWait wait = new WebDriverWait(driver, (long) 10.0);
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
				driver.switchTo().frame(leftFrame);
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
				driver.switchTo().frame("frame-top");
				// Switch to the top-middle frame
				driver.switchTo().frame(middleFrame);
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
				driver.switchTo().frame("frame-top");
				// Switch to the top-right frame
				driver.switchTo().frame(rightFrame);
				// Grab the text from the frame
				frameText = driver.findElement(By.xpath("/html/body")).getText();
				// Output the text from the frame
				System.out.println("TOP-RIGHT FRAME TEXT: " + frameText);

		//******************************
		//*	SWITCH TO THE BOTTOM FRAME *
		//******************************
		// Switch to the default content
		driver.switchTo().defaultContent();
		/*
		 * Use the WebDriverWait to wait for the bottom frame to be available
		 * and then switch to it. This is perhaps the more elegant of the two
		 * frame-switching solutions
		 */
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
