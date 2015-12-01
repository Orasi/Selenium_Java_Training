package pageFactory.apps.bluesource.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageUsingPageFactory {
	/*
	 * Declare LoginPage fields
	 */
	String username = "company.admin";
	String password = "test";
	WebDriver driver;
	WebDriverWait wait;
	
	/*
	 * Define LoginPage WebElements
	 */
	@FindBy(id = "employee_username") private WebElement txtUsername;
	
	@FindBy(id = "employee_password") private WebElement txtPassword;
	
	@FindBy(name = "commit") private WebElement btnLogin;
	
	/*
	 * Define a LoginPage constructor
	 */
	public LoginPageUsingPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		wait = new WebDriverWait(this.driver, (long)10.0);
	}
	
	/*
	 * Define LoginPage interactions
	 */
	public void login(){
		setUsername();
		setPassword();
		clickLogin();
	}
	
	private void setUsername(){
		wait.until(ExpectedConditions.visibilityOf(txtUsername));
		txtUsername.sendKeys(username);
	}
	
	private void setPassword(){
		wait.until(ExpectedConditions.visibilityOf(txtPassword));
		txtPassword.sendKeys(password);
	}
	
	private void clickLogin(){
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		btnLogin.click();
	}
}
