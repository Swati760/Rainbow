package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import org.testng.annotations.*;

public class LaunchChrome extends MyBase{

	@SuppressWarnings("deprecation")
	@Test

	public void method() {
		// TODO Auto-generated method stub
		// String projectpath=System.getProperty("user.dir");
		// System.out.println(projectpath);

	
			
			System.setProperty("webdriver.chrome.driver",
					"/C:/Users/Anil/eclipse-workspace/MySeleniumTestScript/drivers/resources/chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.get("http://demo.automationtesting.in/");
			String url = driver.getCurrentUrl();
			System.out.println(url);
			driver.manage().window().maximize();
		WebElement el=driver.findElement(By.id("email"));
		el.sendKeys("swati12sethi@gmail.com");
		driver.findElement(By.xpath("//img[@id='enterimg']")).click();
		//Register page
		driver.findElement(By.xpath("//input[contains(@ng-model,'FirstName')]")).sendKeys("Swati");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Last Name')]")).sendKeys("Sethi");
		driver.findElement(By.xpath("//input[contains(@ng-model,'Email')]")).sendKeys("sunil.khera57@gmail.com");
		driver.findElement(By.xpath("//textarea[(@ng-model='Adress')]")).sendKeys("#B-601,balaji Tower");;
		driver.findElement(By.xpath("//input[contains(@type,'tel')]")).sendKeys("92524651");
		//driver.findElement(By.xpath("//label[text()='Gender*']")).sendKeys("92524651");
		WebElement radio1=driver.findElement(By.xpath("//input[@value='Male']"));
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Male']")));
		 boolean bl = radio1.isEnabled();
         System.out.println("Is Male radio button enabled "+bl);
         radio1.click();
         boolean radioBtnNewSelectionStatus = radio1.isSelected();

         System.out.println("Male radio Selection status after perform click() event: "+radioBtnNewSelectionStatus);
		//WebElement radio2=driver.findElement(By.xpath("//input[@value='FeMale']"));
       
              
         WebElement check1 = driver.findElement(By.xpath("//input[@value='Cricket']"));
         check1.click();
         System.out.println("Clicked Check Box..");
              
         WebElement check2 = driver.findElement(By.xpath("//input[@value='Movies']"));
         check2.click();
         System.out.println("Checked all Boxes..");
          
         Select sel = new Select(driver.findElement(By.xpath("//div/select[@id='countries']")));
         sel.selectByVisibleText("Australia");
         
		
		
		

		
		
	}
}
