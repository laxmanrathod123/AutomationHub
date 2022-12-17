package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropD {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']")).sendKeys("unit");
		List<WebElement> autodp = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/div"));
		for (int i = 0; i < autodp.size(); i++) {
			String text = autodp.get(i).getText();
			System.out.println("text is :" + text);
			if (text.equalsIgnoreCase("United Kingdom (UK)")) {
				autodp.get(i).click();
				break;
			}
		}
		String selectedText = driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']"))
				.getAttribute("value");
		System.out.println("selectedText:" + selectedText);
		Thread.sleep(3000);
 
		// Another way to do this
		driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']")).sendKeys("ind");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String AnotherSelectedText = driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']"))
				.getAttribute("value");
		System.out.println("AnotherSelectedText:" + AnotherSelectedText);
		driver.quit();
		System.out.println("Program end");

	}

}
