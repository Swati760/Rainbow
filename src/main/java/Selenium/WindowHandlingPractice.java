package Selenium;

import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingPractice {
	
	@Test()
	public void startup() {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
		WebElement btnOpenWindow= driver.findElement(By.xpath("//button[@id='openwindow']"));
		String currentwindow=driver.getWindowHandle();
		btnOpenWindow.click();
		Set<String> allWindows= driver.getWindowHandles();
		
		for(String childwindow:allWindows)
		{
			if(!childwindow.equals(currentwindow))
			driver.switchTo().window(childwindow);
			System.out.println(driver.getTitle());
			WebElement inputsearchCourse= driver.findElement(By.xpath("//class[@id='search-courses']"));
			inputsearchCourse.sendKeys("manual");
			
			
			
		}
		
		

}
}
