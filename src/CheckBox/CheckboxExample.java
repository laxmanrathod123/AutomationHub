package CheckBox;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxExample {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		boolean flag1=driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected();
		System.out.println("checkbox is selected: " +flag1);
		Assert.assertFalse(flag1);
		
	   driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
	   Thread.sleep(2000);
	   
		boolean flag=driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected();
		System.out.println("checkbox is selected: " +flag);
		assertTrue(flag);
		
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
		int size=checkbox.size();
		System.out.println("count of the checkbox: " + size);
		
	
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		Thread.sleep(2000);
		String atb1=driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_0']")).getAttribute("class");
		System.out.println("before:" + atb1);
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		Thread.sleep(2000);
		
		
		String atb=driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_0']")).getAttribute("class");
		System.out.println("After:" + atb);
		if(atb.contains("select-label")) {
			Assert.assertTrue(true);
			System.out.println("is disable");
		}
		else {
			Assert.assertFalse(false);
			System.out.println("is enable");
		}
		driver.quit();
		System.out.println("Program end");
	}

}
