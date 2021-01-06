package Selenium;

import java.awt.event.ActionEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

@Test()
public class Letitkode {
	public void startup() {
		System.setProperty("webdriver.chrome.driver",
				"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
		driver.switchTo().frame("courses-iframe");
		 WebElement inputsearchbox = driver.findElement(By.xpath("//input[@id='search-courses']"));
         inputsearchbox.sendKeys("manual testing");
         WebElement searchboxclick = driver.findElement(By.xpath("//i[@title='Search']"));
         searchboxclick.click();
         driver.switchTo().defaultContent();
         WebElement hidebox=driver.findElement(By.xpath("//input[@value='Hide']"));
        // WebElement btnmousehover=driver.findElement(By.xpath("//button[@id='mousehover']"));
         Actions act= new Actions(driver);
         act.moveToElement(hidebox).click().build().perform();
       //  act.moveToElement(btnmousehover).build().perform();
      //   WebElement mousehoverdrp=driver.findElement(By.xpath("//a[text()='Reload']"));
      //   mousehoverdrp.click();
         
		
		
		
		
	}

}
