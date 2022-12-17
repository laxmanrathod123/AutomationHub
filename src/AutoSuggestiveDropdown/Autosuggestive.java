package AutoSuggestiveDropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestive {

	public static void main(String[] args) throws InterruptedException {


		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> options=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
		
		for(WebElement ele: options) {
			if(ele.getText().equalsIgnoreCase("India")){
				String text=ele.getText();
				System.out.println("text :" + text);
				ele.click();
				break;
			}
		}
		Thread.sleep(2000);
		
		driver.quit();
		System.out.println("Program end");
	}

}
