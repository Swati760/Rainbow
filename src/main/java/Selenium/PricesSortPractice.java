package Selenium;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

@Test
public class PricesSortPractice {
	public void startup() throws ParseException {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		// Fetch All the Products Text
		List<WebElement> list_of_products = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		List<WebElement> list_of_products_price = driver
				.findElements(By.xpath("//div[@class='pricebar']/div[@class='inventory_item_price']"));

		// Use of HashMaop to store Products and Their prices(after conversion to
		// Integer)
		String product_name;
		String product_price;
		float float_product_price;
		HashMap<Float, String> map_final_products = new HashMap<Float, String>();
		for (int i = 0; i < list_of_products.size(); i++) {
			product_name = list_of_products.get(i).getText();// Iterate and fetch product name
			product_price = list_of_products_price.get(i).getText();// Iterate and fetch product price
			String price = product_price.replace("$", "");// Replace anything will space other than numbers
			float_product_price = Float.parseFloat(price);// Convert to Float
			map_final_products.put(float_product_price, product_name);// Add product and price in HashMap
		}
		Reporter.log("Product Name and price fetched from UI and saved in HashMap as:" + map_final_products.toString()
				+ "<br>", true);
		// Get all the keys from Hash Map and save it in ArrayList then sort it
		Set<Float> allkeys = map_final_products.keySet();
		ArrayList<Float> array_list_values_product_prices = new ArrayList<Float>(allkeys);
		Collections.sort(array_list_values_product_prices);
		Print(array_list_values_product_prices);
		//Highest Product is
				float high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
				
				//Low price is
				float low_price = array_list_values_product_prices.get(0);
				
				Reporter.log("High Product Price is: " + high_price + " Product name is: " + map_final_products.get(high_price),true);
				Reporter.log("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price),true);
				
				//Get List of All values from Hash Map. Right now we do not need it so commenting
				//Collection<String> allValues = map_final_products.values();
				//ArrayList<String> array_list_values_product_names = new ArrayList<String>(allValues);
				
			 
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		wait3.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='product_sort_container']")));
		Select sel = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		sel.selectByVisibleText("Price (low to high)");
	}
	
	
			 			 
	public static void Print(ArrayList<Float> arraylist) {
		for (int counter = 0; counter < arraylist.size(); counter++) {
			System.out.println(arraylist.get(counter));
		}
	}
	
	}


