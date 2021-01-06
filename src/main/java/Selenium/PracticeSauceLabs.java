package Selenium;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PracticeSauceLabs {

	@Test
	public void startup() {
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
		// List<WebElement> li =
		//List<WebElement> li =driver.findElements(By.xpath("//div[@class='pricebar']/div[@class='inventory_item_price']"));
		List<WebElement> li = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		ArrayList<String> main = new ArrayList<String>();

		for (WebElement e : li) {
			main.add(e.getText());
						
		}
		System.out.println("***before sort by java sort function**");
		Print(main);
		Comparator<Object> c = Collections.reverseOrder();
		Collections.sort(main, c);

		System.out.println("**after sort by java sort function**");
		Print(main);
		@SuppressWarnings("deprecation")
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='product_sort_container']")));
		Select sel = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		// sel.selectByVisibleText("Price (high to low)");
		sel.selectByVisibleText("Name (Z to A)");
		
	//	li= driver.findElements(By.xpath("//div[@class='pricebar']/div[@class='inventory_item_price']"));
		li = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		List<String> main2 = new ArrayList<String>();
		for (WebElement e : li) {
			main2.add(e.getText());

		}
		System.out.println("After click on dropdown");
		Print(main2);
		Assert.assertEquals(main2, main);

	}

	public static void Print(List<String> arraylist) {
		for (int counter = 0; counter < arraylist.size(); counter++) {
			System.out.println(arraylist.get(counter));
		}

	}
}
