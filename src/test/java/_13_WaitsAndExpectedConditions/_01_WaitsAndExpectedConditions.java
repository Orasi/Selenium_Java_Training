package _13_WaitsAndExpectedConditions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class _01_WaitsAndExpectedConditions {
	WebDriver driver;
	WebDriverWait wait;
	WebElement element;
	WebElement result;
	Alert alert;

	@Test
	public void javaScriptAlert() {
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		element = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button"));
		element.click();
		wait = new WebDriverWait(driver, (long)10.0);
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.accept();
		result = driver.findElement(By.id("result"));
		wait.until(ExpectedConditions.textToBePresentInElement(result, "You successfuly clicked an alert"));
	}

	@Test(dependsOnMethods = { "javaScriptAlert" })
	public void javaScriptConfirm() {
		element = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button"));
		element.click();
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.accept();
		wait.until(ExpectedConditions.textToBePresentInElement(result, "You clicked: Ok"));

		element = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button"));
		element.click();
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.dismiss();
		wait.until(ExpectedConditions.textToBePresentInElement(result, "You clicked: Cancel"));
	}

	@Test(dependsOnMethods = { "javaScriptAlert", "javaScriptConfirm" })
	public void javaScriptPrompt() throws InterruptedException {
		element = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button"));
		element.click();
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.accept();
		wait.until(ExpectedConditions.textToBePresentInElement(result, "You entered:"));

		element = driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button"));
		element.click();
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.dismiss();
		wait.until(ExpectedConditions.textToBePresentInElement(result, "You entered: null"));		

		driver.close();
		driver.quit();
	}
}
