package Selenium;

import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Test
public class PracticeJqueryDropdown {

	

	public void verify() {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//First click on dropdown to show options 
		WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("//span[@class='selection']//span[@id='select2-country-container']")));
		dropdown.click();
		//Now find desired option and click 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Denmark')]"))).click();
		
	}
}
