package BrokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {

		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List <WebElement>links=driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		SoftAssert a= new SoftAssert();
		for(WebElement link:links) {
			
		String Url=	link.getAttribute("href");
		HttpURLConnection conn= (HttpURLConnection)new URL(Url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode=conn.getResponseCode();
		System.out.println(respCode);
		a.assertTrue(respCode<400,"The link with text" + link.getText()+ "is broken with code " + respCode);
		}
		a.assertAll();
		//Thread.sleep(1000);
		System.out.println();
		//String url=driver.findElement(By.xpath("//a[text()='SoapUI']")).getAttribute("href");
		String url=driver.findElement(By.xpath("//a[text()='Broken Link']")).getAttribute("href");
		HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode=conn.getResponseCode();
		System.out.println(respCode);
		
		
		driver.quit();
		System.out.println("Program end");
	}

}
