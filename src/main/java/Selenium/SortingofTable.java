package Selenium;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class SortingofTable {

	@Test
	public void startup() {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");

		List<WebElement> li = driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr/td[1]"));
		String[] beforesort = new String[li.size()];// store the list in an array
		for (int i = 0; i < li.size(); i++) {
			// String abc=li.get(0).getText();
			// Assert.assertEquals(abc, "Alfreds Futterkiste");
			beforesort[i] = li.get(i).getText();// get the text into the array
		}
		System.out.println("***before sort by java sort function**");
		Print(beforesort);
		Arrays.sort(beforesort);
		System.out.println("**after sort by java sort function**");
		Print(beforesort);
		// click on the button and again get the list of webelements and store it in
		// array
		driver.findElement(By.xpath("//button[contains(text(),'Sort')]")).click();
		li = driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr/td[1]"));
		String[] aftersort = new String[li.size()];// store the list in an array
		for (int i = 0; i < li.size(); i++) {
			
			aftersort[i] = li.get(i).getText();// get the text into the array
			System.out.println("***After click on sort****");
			Print(aftersort);
			Assert.assertEquals(aftersort, beforesort);
			System.out.println("sort verification is done properly");
		}

	}

	public static void Print(String ar[]) {
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}

}
