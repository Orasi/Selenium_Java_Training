package TODO_14_Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class _01_Actions {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	String username = "company.admin";
	String password = "test";
	
	// Define the proxy for the username textbox
	@FindBy(id = "employee_username")
	private WebElement txtUsername;
	// Define the proxy for the password textbox
	@FindBy(id = "employee_password")
	private WebElement txtPassword;
	// Define the proxy for the login button
	@FindBy(name = "commit")
	private WebElement btnLogin;
	

	@FindBy(linkText = "Dropdown")
	private WebElement lnkDropdown;
	//Define a proxy for the dropdown list
	@FindBy(id = "dropdown")
	private WebElement lstDropdown;
	
	@FindBy(css = "#content > div > div:nth-child(3)")
	private WebElement imgFigure1;
	@FindBy(css = "#content > div > div:nth-child(3) > div > a")
	private WebElement lnkFigure1ProfileLink;
	@FindBy(css = "#content > div > div:nth-child(4)")
	private WebElement imgFigure2;
	@FindBy(css = "#content > div > div:nth-child(4) > div > a")
	private WebElement lnkFigure2ProfileLink;
	@FindBy(css = "#content > div > div:nth-child(5)")
	private WebElement imgFigure3;
	@FindBy(css = "#content > div > div:nth-child(5) > div > a")
	private WebElement lnkFigure3ProfileLink;

	@Test(priority = 3)
	public void test() {
		// Create a new WebDriver
		driver = new FirefoxDriver();
		// Create a WebDriverWait
		wait = new WebDriverWait(driver, (long)10.0);
		//Create a new action object using the current driver
		action = new Actions(driver);
		// Navigate to the BlueSource homepage
		driver.get("https://bluesourcestaging.herokuapp.com");
		// Use Selenium's PageFactory to initialize the proxy elements
		PageFactory.initElements(driver, this);
		//Sync to the an element being clickable and visible
		wait.until(ExpectedConditions.elementToBeClickable(txtUsername));
		wait.until(ExpectedConditions.visibilityOf(txtUsername));
		// Set the value for the username textbox by chaining together actions
		action.moveToElement(txtUsername).click().sendKeys(username).build().perform();
		// Set the value for the password textbox by chaining together actions
		action.moveToElement(txtPassword).click().sendKeys(password).build().perform();
		//Sync to the an element being clickable and visible
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		// Click the login button
		action.moveToElement(btnLogin).click().build().perform();
		
		
		// Close the current browser
		driver.close();
		// Quit the WebDriver sessions
		driver.quit();
	}
	
	@Test(priority = 2)
	public void selects() throws InterruptedException {
		// Create a new WebDriver
		driver = new FirefoxDriver();
		// Create a WebDriverWait
		wait = new WebDriverWait(driver, (long)10.0);
		//Create a new action object using the current driver
		action = new Actions(driver);
		// Navigate to the Internet homepage
		driver.get("http://the-internet.herokuapp.com/");
		// Use Selenium's PageFactory to initialize the proxy elements
		PageFactory.initElements(driver, this);
		//Wait for the link to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(lnkDropdown));
		// Click the dropdown link
		action.moveToElement(lnkDropdown).click().build().perform();
		
		/*
		 * Use Selenium's PageFactory to reinitialize the proxy elements to
		 * avoid a StaleElementReferenceException or an ElementNotFoundException
		 */
		PageFactory.initElements(driver, this);
		//Send keys to the select object to select by visible text
		action.moveToElement(lstDropdown).sendKeys("Option 1").build().perform();
		//Sleep to allow visibility
		Thread.sleep(1000);
		//Send keys to the select object to select by visible text
		action.moveToElement(lstDropdown).sendKeys("Option 2").build().perform();
		//Sleep to allow visibility
		Thread.sleep(1000);
		//Send keys to the select object to select by visible text
		action.moveToElement(lstDropdown).sendKeys("Option 1").build().perform();
		//Sleep to allow visibility
		Thread.sleep(1000);


		// Close the current browser
		driver.close();
		// Quit the WebDriver sessions
		driver.quit();
	}
	
	@Test(priority = 1)
	public void hovers() throws InterruptedException{
		// Create a new WebDriver
		driver = new FirefoxDriver();
		// Create a WebDriverWait
		wait = new WebDriverWait(driver, (long)10.0);
		//Create a new action object using the current driver
		action = new Actions(driver);
		// Navigate to the Internet homepage
		driver.get("http://the-internet.herokuapp.com/hovers");
		// Use Selenium's PageFactory to initialize the proxy elements
		PageFactory.initElements(driver, this);
		
		//Wait for the first figure to be visible
		wait.until(ExpectedConditions.visibilityOf(imgFigure1));
		
		//Move to the first figure and wait for a profile link to be visible
		action.moveToElement(imgFigure1).build().perform();
		wait.until(ExpectedConditions.visibilityOf(lnkFigure1ProfileLink));
		//Wait to allow for visibility
		Thread.sleep(1000);
		
		//Move to the second figure and wait for a profile link to be visible
		action.moveToElement(imgFigure2).build().perform();
		wait.until(ExpectedConditions.visibilityOf(lnkFigure2ProfileLink));
		//Wait to allow for visibility
		Thread.sleep(1000);
		
		//Move to the third figure and wait for a profile link to be visible
		action.moveToElement(imgFigure3).build().perform();
		wait.until(ExpectedConditions.visibilityOf(lnkFigure3ProfileLink));
		//Wait to allow for visibility
		Thread.sleep(1000);
		
		// Close the current browser
		driver.close();
		// Quit the WebDriver sessions
		driver.quit();
	}
}
