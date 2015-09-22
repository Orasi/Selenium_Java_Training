package TODO_15_PageFactoryModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageFactory.apps.bluesource.loginPage.LoginPage;
import pageFactory.apps.bluesource.navBar.NavBar;

public class _01_PageFactoryModel {
	String url = "https://bluesourcestaging.herokuapp.com";
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	@AfterTest
	public void afterTest(){
		driver.close();
		driver.quit();
	}
	
	@Test
	public void test(){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
		
		NavBar navbar = new NavBar(driver);
		Assert.assertTrue(navbar.navBarVisible());
	}
}
