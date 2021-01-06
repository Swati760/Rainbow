package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class MyBase {
	WebDriver driver;

	@Test()
	public void jenkinsjob() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://73.99.5.45:7777/#/login");
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("narsi@ictcrp.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Narsi@007");
		driver.findElement(By.xpath("//button[@type='submit']/span")).click();

		Thread.sleep(50000);

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Jenkins Jobs']/i")));
		driver.findElement(By.xpath("//div[@title='Jenkins Jobs']/i")).click();
		driver.manage().window().maximize();
		Thread.sleep(50000);
		@SuppressWarnings("deprecation")
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[contains(text(),'PrisAutomation')]//parent::tr//input[@type='checkbox']")));

		driver.findElement(By.xpath("//td[contains(text(),'PrisAutomation')]//parent::tr//input[@type='checkbox']"))
				.click();
		driver.findElement(By.xpath("//button[contains(text(),'Run selected Jobs')]")).click();

		String url = driver.getCurrentUrl();
		System.out.println(url);

	}

}
