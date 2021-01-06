package Selenium;

import java.util.ArrayList;
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

public class PriceSortHtoL {
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
		List<WebElement> list_of_products_price = driver
				.findElements(By.xpath("//div[@class='pricebar']/div[@class='inventory_item_price']"));
		ArrayList<Float> pricelist = new ArrayList<Float>();
		for (int i = 0; i < list_of_products_price.size(); i++) {
			String product_price = list_of_products_price.get(i).getText();
			// System.out.println(product_price);
			String price = product_price.replace("$", "");
			// System.out.println(price);
			float float_product_price = Float.parseFloat(price);
			pricelist.add(float_product_price);

		}
		System.out.println("***before sort by java sort function**");
		Print(pricelist);
		Comparator<Object> c = Collections.reverseOrder();
		Collections.sort(pricelist, c);
		//Highest Product is
		float high_price =pricelist.get(0);
		System.out.println("High Product Price is:"+high_price);

		System.out.println("**after sort by java sort function**");
		Print(pricelist);
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='product_sort_container']")));
		Select sel = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		sel.selectByVisibleText("Price (high to low)");
		list_of_products_price = driver
				.findElements(By.xpath("//div[@class='pricebar']/div[@class='inventory_item_price']"));
		ArrayList<Float> pricelist2 = new ArrayList<Float>();
		for (int i = 0; i < list_of_products_price.size(); i++) {
			String product_price = list_of_products_price.get(i).getText();
			// System.out.println(product_price);
			String price = product_price.replace("$", "");
			// System.out.println(price);
			float float_product_price = Float.parseFloat(price);
			pricelist2.add(float_product_price);
		}
		System.out.println("After click on dropdown");
		Print(pricelist2);
		Assert.assertEquals(pricelist2, pricelist);

	}

	public static void Print(List<Float> arraylist) {
		for (int counter = 0; counter < arraylist.size(); counter++) {
			System.out.println(arraylist.get(counter));
		}

	}
}
