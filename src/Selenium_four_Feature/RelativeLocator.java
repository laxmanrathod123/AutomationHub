package Selenium_four_Feature;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class RelativeLocator {

	public static void main(String[] args) {


		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameeditbox=driver.findElement(By.xpath("//input[@name='name']"));
		//driver.findElement(with(By.tagName("label")).above(nameeditbox)).getText();
		// Need to go with selenium 4
	}

}
