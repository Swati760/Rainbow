package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ButtonDisplayRikstoto {
	@Test
	public static boolean check() {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.finn.no/bap/forsale/search.html");
		driver.manage().window().maximize();
		
	WebElement element=   driver.findElement(By.xpath("//div[@class='flex-align u-mt16']/button"));
	    if (element.isDisplayed())
	    {
	        return true;
	    }
	    return false;
	} 

}
