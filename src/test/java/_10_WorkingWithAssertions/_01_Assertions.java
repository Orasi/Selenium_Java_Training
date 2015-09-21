package _10_WorkingWithAssertions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @summary This class gives a brief overview and demonstration of only some of
 *          the TestNG Assertions
 */
public class _01_Assertions {
	// Declare a WebDriver
	WebDriver driver;
	// Declare a WebElement
	WebElement element;
	// Declare a Point
	Point location;
	// Declare a Dimension
	Dimension size;
	// Declare and define a URL
	String url = "http://the-internet.herokuapp.com";

	@Test
	public void test() {
		// Create a new WebDriver
		driver = new FirefoxDriver();
		// Navigate to the desired web page
		driver.get(url);
		// Grab the element under inspection
		element = driver.findElement(By.linkText("Sortable Data Tables"));

		// Assert that the element is not null
		Assert.assertNotNull(element);
		// Assert that the element is displayed
		Assert.assertEquals(element.isDisplayed(), true);
		// Assert that the element is not disabled
		Assert.assertNotEquals(element.isEnabled(), false);
		// Assert that the element's text matches that which is expected
		Assert.assertEquals(element.getText(), "Sortable Data Tables");
		// Assert that the element's tag name is that which is expected
		Assert.assertEquals(element.getTagName(), "a");
		// Assert that an element attribute matches that which is expected
		Assert.assertEquals(element.getAttribute("href"), url + "/tables");

		/*
		 * Run assertions on the location and height of the element. This can be
		 * used as an alternate mean to determine if an object is visible.
		 */
		// Grab the elements x and y-coordinates
		location = element.getLocation();
		// Assert that the element's x-coordinate is greater than zero
		Assert.assertTrue((location.x > 0));
		// Assert that the element's y-coordinate is greater than zero
		Assert.assertTrue((location.y > 0));
		//Grab the element's height and width
		size = element.getSize();
		//Assert that the element's height is greater than zero
		Assert.assertTrue((size.height > 0));
		//Assert that the element's width is greater than zero
		Assert.assertTrue((size.width > 0));

		//Close the browser
		driver.close();
		//Quit the driver
		driver.quit();
	}
}
