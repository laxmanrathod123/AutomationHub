package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptEx1 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.location='https://www.rediff.com/'");
		Thread.sleep(1000);
		String pagetitle=(String) js.executeScript("return document.title");
		System.out.println(pagetitle);
		WebElement signInbtn=driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		js.executeScript("arguments[0].click", signInbtn);
		Thread.sleep(1000);		
		WebElement usernamebtn=driver.findElement(By.cssSelector("#login1"));
		js.executeScript("arguments[0].value='laxmanrathod2142@gmail.com'", usernamebtn);
		Thread.sleep(1000);		
		js.executeScript("window.scrollBy(0,3000)");
		
		WebElement disclamer=driver.findElement(By.xpath("//a[contains(text(),'Disclaimer')]"));
		js.executeScript("arguments[0].scrollIntoView(true)", disclamer);
		Thread.sleep(5000);
		System.out.println("program end");
	}

}
