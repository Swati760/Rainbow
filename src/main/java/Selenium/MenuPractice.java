package Selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MenuPractice {
	@Test
	public void startup() {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("admin@yourstore.com");
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Actions act = new Actions(driver);
		WebElement mousehovercatalog = driver.findElement(By.xpath("//span[text()='Catalog']"));
		act.moveToElement(mousehovercatalog).click().build().perform();
		List<WebElement> dropdowns = driver.findElements(By.xpath("//ul[@class = 'treeview-menu']//a"));
		System.out.println(dropdowns.size());

		for (WebElement dropdown : dropdowns) {
			System.out.println(dropdown.getText());

		}
	}
}
