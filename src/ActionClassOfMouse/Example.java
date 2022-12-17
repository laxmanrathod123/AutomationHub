package ActionClassOfMouse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Example {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		WebElement signInbtn=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        String text=signInbtn.getText();
        System.out.println(text);
		Actions action= new Actions(driver);
		action.moveToElement(signInbtn).build().perform();
		
		action.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).
		click().keyDown(Keys.SHIFT).sendKeys("hellow").build().perform();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);
		WebElement privacybtn=driver.findElement(By.xpath("//a[text()='Privacy Notice']"));
		js.executeScript("arguments[0].scrollIntoView(true)", privacybtn);
		//"window.scrollBy(0,500)"
		
		Thread.sleep(9000);
		
		
		driver.quit();
		System.out.println("Program end");
	}

}
