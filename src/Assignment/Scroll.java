package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector(\'.tableFixHead\').scrollTop=50000");
		Thread.sleep(5000);
		
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0; i<values.size(); i++) {
		sum=  sum+	Integer.parseInt(values.get(i).getText());
			
		}
		System.out.println("sum :"+ sum);
		Thread.sleep(2000);
	int ActualText=Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		System.out.println("ActualText :"+ActualText);
		Assert.assertEquals(ActualText, sum);
		Thread.sleep(2000);
		//Printing the first table values
		List<WebElement>pricevalue=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]"));
		int sumofprice=0;
		for(int i=0; i<pricevalue.size(); i++) {
			
			String textPricevalue=pricevalue.get(i).getText();
			System.out.println("textPricevalue: " +textPricevalue);
			sumofprice=sumofprice  + Integer.parseInt(textPricevalue);
			
		}
		System.out.println("sumofprice :" + sumofprice);
		int size =driver.findElements(By.xpath("//table[@name='courses']//tr")).size();
		// Printing the number of rows present in the first table
		System.out.println("Number of rows: " + size );
		
		//printing the number of column present in the first table
		int columnsize=driver.findElements(By.xpath("//table[@name='courses']//th")).size();
		System.out.println("columnsize: " + columnsize);
		// printing the data present in the Third row of the first table
		String textofrow=driver.findElement(By.xpath("//table[@name='courses']//tr[3]")).getText();
		System.out.println("Text present on the third row: " + textofrow );
		Thread.sleep(2000);
		
		System.out.println("***************************");
		System.out.println();
		// SOLUTION OF THESE BY USING ANOTHER WAY
		
		WebElement table=driver.findElement(By.xpath("//table[@name='courses'] "));
		//printing the number of rows
	System.out.println(table.findElements(By.tagName("tr")).size());
	//printing the number of column
	System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
	// printing the data present in the second row of the first table
	List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
	System.out.println(secondrow.get(0).getText());
	System.out.println(secondrow.get(1).getText());
	System.out.println(secondrow.get(2).getText());
	
	
		
		
		driver.quit();
		System.out.println("Program end");
		
	}

}
