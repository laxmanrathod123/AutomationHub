package Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class DynamicLogin {

	public static void main(String[] args) throws InterruptedException {

		
		System.out.println("Program Start");
	//	String url="https://rahulshettyacademy.com/locatorspractice/";
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String password=getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		
		driver.findElement(By.id("inputUsername")).sendKeys("laxmanrathod2142@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(3000);
		String Actualloginmsg=driver.findElement(By.tagName("p")).getText ();
	   Assert.assertEquals(Actualloginmsg, "You are successfully logged in.");
	   
	   String textloginpage=driver.findElement(By.xpath("//div[@class='login-container']/h1")).getText();
	   System.out.println("text on page : " + textloginpage);
	   driver.quit();
	   System.out.println("Program End");
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		Thread.sleep(5000);
		String stringpassword=driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		// Please use temporary password 'rahulshettyacademy' to Login.
				String[] passarray=stringpassword.split("'");
				String password=passarray[1].split("'")[0];
				driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
				Thread.sleep(3000);
				return password;
		
	}

}
