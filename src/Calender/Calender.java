package Calender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.path2usa.com/travel-companion/");
		 WebElement dt=driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", dt);
		 Thread.sleep(9000);
		
		 List<WebElement> dates=driver.findElements(By.xpath("//span[@class='flatpickr-day ']")); 
		 int count=dates.size();
		  
		  for(int i=0; i<count; i++) {
			  String text=dates.get(i).getText();
		  System.out.println("text is:"+ text);
		  if(text.equalsIgnoreCase("23")) {
		  dates.get(i).click(); 
		  break; 
		  } 
		  }
		  
		  Thread.sleep(3000); 
		//driver.quit();
		 
		System.out.println("Program end");
		
	}

}
