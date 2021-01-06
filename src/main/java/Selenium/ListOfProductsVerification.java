package Selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ListOfProductsVerification {
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
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath(
				"//div[@class='inventory_item_label']/a[@id='item_5_title_link']/parent::div/following-sibling::div/button[text()='ADD TO CART']")).click();
		String str5=driver.findElement(By.xpath(
				"//div[@class='inventory_item_label']/a[@id='item_5_title_link']/parent::div/following-sibling::div/button[text()='REMOVE']")).getText();
		System.out.println(str5);
		driver.findElement(By.xpath(
				"//div[@class='inventory_item_label']/a[@id='item_4_title_link']/parent::div/following-sibling::div/button[text()='ADD TO CART']")).click();
      String str2=driver.findElement(By.xpath(
				"//div[@class='inventory_item_label']/a[@id='item_4_title_link']/parent::div/following-sibling::div/button[text()='REMOVE']")).getText();
        System.out.println(str2);
        driver.findElement(By.xpath(
				"//div[@class='inventory_item_label']/a[@id='item_2_title_link']/parent::div/following-sibling::div/button[text()='ADD TO CART']")).click();
        String str3=driver.findElement(By.xpath(
				"//div[@class='inventory_item_label']/a[@id='item_2_title_link']/parent::div/following-sibling::div/button[text()='REMOVE']")).getText();
        System.out.println(str3);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']")).click();
        
       
	}

	

	}


