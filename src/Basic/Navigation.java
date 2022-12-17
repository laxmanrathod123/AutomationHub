package Basic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String[] args) {

		System.out.println("Program Start");
		//	String url="https://rahulshettyacademy.com/locatorspractice/";
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

			WebDriver driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https:www.google.com");		
			driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
			driver.navigate().back();
			driver.navigate().forward();
			driver.quit(); 
			System.out.println("program end");
		
	}

}
