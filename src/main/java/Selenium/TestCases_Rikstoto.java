package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCases_Rikstoto {
	
		
	
	@Test
	public void startup() {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.finn.no/bap/forsale/search.html");
		driver.manage().window().maximize();
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='search-sorter']")));
		sel.selectByValue("PUBLISHED_ASC");
		WebDriverWait wait3 = new WebDriverWait(driver, 50);
		wait3.until(
			ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[1]//div[@class='ads__unit__content']//a")));
		String item = driver.findElement(By.xpath("//article[1]//div[@class='ads__unit__content']//a"))
				.getText();
			System.out.println(item);
			driver.findElement(By.xpath("//div[@class='flex-align u-mt16']/button")).click();
			String item1 = driver.findElement(By.xpath("//article[1]//div[@class='ads__unit__content']//a"))
					.getText();
			System.out.println(item1);
			System.out.println(item.equals(item1));
	
			
			

}
}

