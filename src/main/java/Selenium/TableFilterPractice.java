package Selenium;

import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Test
public class TableFilterPractice {

	

	public void verify() {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Table')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Table Filter')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Orange')]")).click();
		List<WebElement> li = driver.findElements(By.xpath("//span[contains(text(),'(Orange)')]"));
		for (WebElement e : li)
		{
		    System.out.println(e.getText());
		    Assert.assertEquals("(Orange)", e.getText());
		  
		}
	}
}
