package EndToEndTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		Thread.sleep(1000);
		String atb1=driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_0']")).getAttribute("class");
		System.out.println("before:" + atb1);
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		Thread.sleep(1000);
		
		
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
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		String text=driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).getText();
		//a[@value='BLR']
		//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
		System.out.println(" Before Text of selected dropdown :" +text );
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		String text1=driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).getText();
		//a[@value='MAA'])[2]
		//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']
		System.out.println("After Text of selected dropdown :" +text1 );
		Thread.sleep(1000);
		
		// This step for date selection
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[5]/a[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
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
		Thread.sleep(1000);
		
		List<WebElement> options= driver.findElements(By.id("ctl00_mainContent_DropDownListCurrency"));
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("AED")) {
				String dptext=option.getText();
				System.out.println("dropdown selected :" + dptext);
				option.click();
			}
		}
		Thread.sleep(2000);
		WebElement staticdropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		  Select select = new Select(staticdropdown);
		  select.selectByIndex(3);
		  Thread.sleep(1000); 
		  String selectedoption=select.getFirstSelectedOption().getText();
		  System.out.println("selected option : " +selectedoption);
		  Thread.sleep(1000); 
		  driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		  Thread.sleep(1000); 
		  
		driver.quit();
		System.out.println("Program end");
	}

}
