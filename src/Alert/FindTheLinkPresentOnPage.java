package Alert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindTheLinkPresentOnPage {
 public static void main(String[] args) {
	 System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
       
     
         // Here we are limiting webdriver scope from entire page to footer page
        WebElement footer= (WebElement) driver.findElements(By.xpath("//div[@id='gf-BIG']"));
      int sizeoffooter=footer.findElements(By.tagName("a")).size();
      System.out.println("sizeoffooter:"+sizeoffooter);
     
         driver.quit();
 		System.out.println("Program end");
}
 
	

}


