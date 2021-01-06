package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Verifyaddedproduct {

	@Test
	public void verify() {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		driver.findElement(By.xpath(
				"//div[@class='inventory_item_label']/a[@id='item_1_title_link']/parent::div/following-sibling::div/button[text()='ADD TO CART']"))
				.click();
		String item = driver.findElement(By.xpath("//a[@id='item_1_title_link']/div[@class='inventory_item_name']"))
				.getText();
		System.out.println(item);
		driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']")).click();
		String item1 = driver.findElement(By.xpath("//a[@id='item_1_title_link']/div[@class='inventory_item_name']"))
				.getText();
		System.out.println(item);
		System.out.println(item.equals(item1));// true

	}

}
