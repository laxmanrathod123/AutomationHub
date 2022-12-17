package SSLCertification;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Program start");
		ChromeOptions options= new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Program end");
		
	}

}
