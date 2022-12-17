package Dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticdropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		//List<WebElement> options= driver.findElements(By.id("ctl00_mainContent_DropDownListCurrency"));
		/*
		 * for(WebElement option : options) {
		 * if(option.getText().equalsIgnoreCase("AED")) { String text=option.getText();
		 * System.out.println("dropdown selected :" + text); option.click(); break;
		 * 
		 * } }
		 */
		Thread.sleep(3000);
		
		
		
		
		  Select select = new Select(staticdropdown);
		  select.selectByIndex(3);
		  Thread.sleep(3000); 
		  String selectedoption=select.getFirstSelectedOption().getText();
		  System.out.println("selected option : " +selectedoption); 
		  Thread.sleep(3000);
		  select.selectByVisibleText("AED"); String
		  selectedoption1=select.getFirstSelectedOption().getText();
		  System.out.println("selected option : " +selectedoption1);
		  Thread.sleep(3000); select.selectByValue("INR"); String
		  selectedoption3=select.getFirstSelectedOption().getText();
		  System.out.println("selected option : " +selectedoption3);
		  Thread.sleep(3000);
		 
		driver.quit();
		System.out.println("Program end ");
		
	}

}
