package Dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpadateDropdown {

	public static void main(String[] args) throws InterruptedException {


		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		String BeforeText=driver.findElement(By.id("divpaxinfo")).getText();
		System.out.println("BeforeText: " + BeforeText);
		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
        String AfterText=driver.findElement(By.className("paxinfo")).getText();
		System.out.println("AfterText: " + AfterText);
		driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Program end");
	}

}
