package DyanamicDropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DyanamicExample {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		String text=driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).getText();
		//a[@value='BLR']
		//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
		System.out.println(" Before Text of selected dropdown :" +text );
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		String text1=driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).getText();
		//a[@value='MAA'])[2]
		//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']
		System.out.println("After Text of selected dropdown :" +text1 );
		Thread.sleep(2000);
		
		// This step for date selection
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[5]/a[1]")).click();
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Program end");
	}

}
