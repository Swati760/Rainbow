package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PriceHtoLRikstoto {
	@Test
	public void startup() {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.finn.no/bap/forsale/search.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//label[@for='christmas-bap-gift-wish']//font//font[contains(text(),'Want help ' )]")).click();
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='search-sorter']")));
		sel.selectByValue("PRICE_DESC");
		WebDriverWait wait3 = new WebDriverWait(driver, 50);
		wait3.until(
			ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-results\"]/div[2]/article[1]/div[2]/div/div/font/font")));
		String item = driver.findElement(By.xpath("//*[@id=\"page-results\"]/div[2]/article[1]/div[2]/div/div/font/font"))
				.getText();
			System.out.println(item);
}
}
