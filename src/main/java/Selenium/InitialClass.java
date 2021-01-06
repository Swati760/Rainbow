package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class InitialClass {

	public WebDriver driver;

	@BeforeTest()
	public void startup() {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://73.99.5.45:7777/#/login");
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("narsi@ictcrp.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Narsi@007");
		driver.findElement(By.xpath("//button[@type='submit']/span")).click();
	

	}
	
	



}
