package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ManageIntegerations {

	@Test()
	public void manageintegerations() throws InterruptedException {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Manage Integrations']/i")));
		driver.findElement(By.xpath("//div[@title='Manage Integrations']/i")).click();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		@SuppressWarnings("deprecation")
		WebDriverWait wait2 = new WebDriverWait(driver, 40);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='add-button']/i")));

		driver.findElement(By.xpath("//div[@class='add-button']/i"))
				.click();
		Thread.sleep(5000);
		@SuppressWarnings("deprecation")
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//select[@id='DataSourceType']")));
		Select sel=new Select(driver.findElement(By.xpath("//select[@id='DataSourceType']")));
		sel.selectByVisibleText("Jira");
		driver.findElement(By.xpath("//input[@name='Key']")).sendKeys("jira2");
		driver.findElement(By.xpath("//input[@name='url']")).sendKeys("https://ictcrp.atlassian.net:443");
		Select sel2=new Select(driver.findElement(By.xpath("//select[@name='auth']")));
		sel2.selectByVisibleText("Single Sign On");
		
		
		driver.manage().window().maximize();
		
}
}