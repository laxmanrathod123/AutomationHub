import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class FluentWait {

	public static void main(String[] args) {


		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
	    driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	    driver.findElement(By.xpath("//button[text()='Start']")).click();
	    // Wait wait = new FluentWait(WebDriver reference).withTime
	}

}
