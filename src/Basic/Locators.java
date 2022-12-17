package Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Program Start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		
		driver.findElement(By.id("inputUsername")).sendKeys("laxmanrathod2142@gmail.com");
		//driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("inputPassword")).sendKeys("hidfh");
		driver.findElement(By.className("signInBtn")).click();

		String text=driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println("error text :"+ text);

		System.out.println("Program End");
		driver.quit();
	}

}
