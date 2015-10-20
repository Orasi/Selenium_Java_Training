package _01_SimpleSeleniumExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @summary Create a WebDriver, navigate to a web page, use the driver to
 *          locate (using XPath) and interact with WebElements, then close the browser and end
 *          the web driver session
 */
public class _06_UsingDriverFindBy_XPath_Advanced {
	@Test
	public void textEquals() {
		//Create a new WebDriver
		WebDriver driver = new FirefoxDriver();
		//Navigate to the The-Internet Heroku table page
		driver.get("http://the-internet.herokuapp.com/dropdown");
		//Use the xpath to click to option from a listbox that the displayed text is "Option 2"
		driver.findElement(By.xpath("//*[@id='dropdown']/option[text()='Option 2']")).click();		
		//Close the current browser
		driver.close();
		//Quit the WebDriver sessions
		driver.quit();
	}
	
	@Test(dependsOnMethods = {"textEquals"})
	public void contains() {
		//Create a new WebDriver
		WebDriver driver = new FirefoxDriver();
		//Navigate to the The-Internet Heroku table page
		driver.get("http://the-internet.herokuapp.com/tables");
		//Use the xpath to click the table header with the partial class name "last". This 
		//will click the column header with the class name of "last-name" and sort the table
		driver.findElement(By.xpath("//*[@id='table2']/thead/tr/th/span[contains(@class,'last')]")).click();		
		//Close the current browser
		driver.close();
		//Quit the WebDriver sessions
		driver.quit();
	}
	
	@Test(dependsOnMethods = {"contains"})
	public void multipleIdentifiers() {
		//Create a new WebDriver
		WebDriver driver = new FirefoxDriver();
		//Navigate to the The-Internet Heroku table page
		driver.get("http://the-internet.herokuapp.com/tables");
		//Use the multiple identifying xpath to find an element in the email column with the text "tconway@earthlink.net" 
		//Use assertion on getText() to verify element was found
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='table2']/tbody/tr/td[contains(@class,'email') and text()='tconway@earthlink.net']")).getText().equals("tconway@earthlink.net"));		
		//Close the current browser
		driver.close();
		//Quit the WebDriver sessions
		driver.quit();
	}
	
	/*
	 * Step 1: Ensure we are on the correct row by validating the td email class has the email we want
	 * 	"//*[@id='table2']/tbody/tr/td[contains(@class,'email') and text()='tconway@earthlink.net']"
	 * Step 2: Move back up to the tr element, this allows us to select out next element
	 * 	"/../"
	 * Step 3: Click the edit link in the row where the email resides
	 * 	"/td[@class='action']/a[text()='edit']"
	 * 
	 * Full xpath: "//*[@id='table2']/tbody/tr/td[contains(@class,'email') and text()='tconway@earthlink.net']/../td[@class='action']/a[text()='edit']"
	 *
	 * HTML from example below
	 <tr>
        	<td class="last-name">Conway</td>
        	<td class="first-name">Tim</td>
        	<td class="email">tconway@earthlink.net</td>
        	<td class="dues">$50.00</td>
        	<td class="web-site">http://www.timconway.com</td>
                <td class="action">
                  <a href="#edit">edit</a>
                  <a href="#delete">delete</a>
                </td>
      	</tr>
	 */
	@Test(dependsOnMethods = {"multipleIdentifiers"})
	public void navigateBackwardsOnXpath() {
		//Create a new WebDriver
		WebDriver driver = new FirefoxDriver();
		//Navigate to the The-Internet Heroku table page
		driver.get("http://the-internet.herokuapp.com/tables");
		//See step by step what is happening above
		driver.findElement(By.xpath("//*[@id='table2']/tbody/tr/td[contains(@class,'email') and text()='tconway@earthlink.net']/../td[@class='action']/a[text()='edit']")).click();		
		//Ensure the URL contains "edit" to validate the edit link was clicked
		Assert.assertTrue(driver.getCurrentUrl().contains("edit"));
		//Close the current browser
		driver.close();
		//Quit the WebDriver sessions
		driver.quit();
	}
}
