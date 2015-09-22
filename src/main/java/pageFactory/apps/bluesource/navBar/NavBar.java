package pageFactory.apps.bluesource.navBar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBar {
	/*
	 * Declare NavBar fields
	 */
	WebDriver driver;
	WebDriverWait wait;
	
	/*
	 * Define NavBar WebElements
	 */
	@FindBy(linkText = "Logout")
	private WebElement lnkLogout;
	
	/*
	 * Define a NavBar constructor
	 */
	public NavBar(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, (long)10.0);
	}
	
	/*
	 * Define NavBar interactions
	 */
	public boolean navBarVisible(){
		return lnkLogout.isDisplayed();
	}
}
