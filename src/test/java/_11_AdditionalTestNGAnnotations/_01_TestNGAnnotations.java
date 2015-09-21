package _11_AdditionalTestNGAnnotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @summary This class exposes some basic TestNG behavior using predefined
 *          annotations
 */
public class _01_TestNGAnnotations {
	WebDriver driver;
	WebElement element;
	
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/");
	}
	
	@Test
	public void test(){
		
	}
	
	@AfterTest
	public void afterTest(){
		
	}

}
