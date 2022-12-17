package Stream;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamOnWebTables {
// pagination concept is also executed with do while loop
	public static void main(String[] args) throws InterruptedException {
 //
		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// click on column
		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
		
		// capture all elements into list
		List<WebElement>elementsList=driver.findElements(By.xpath("//tr/td[1]"));
		
		// capture text all webelement into new original list
		List<String>origionalList=elementsList.stream().map(ele-> ele.getText()).collect(Collectors.toList());
		origionalList.forEach(ele->System.out.println("Original list:" + ele));
		System.out.println();
		// stored the original list into soreted list
		List<String> sortedList=origionalList.stream().sorted().collect(Collectors.toList());
		sortedList.forEach(ele->System.out.println("Sorted list:" +ele));
		// compare both original and sorted list
		Assert.assertTrue(origionalList.equals(sortedList));
		System.out.println();
		List <String> price;
		do {
			List<WebElement>rows=driver.findElements(By.xpath("//tr/td[1]"));
		
		 price=rows.stream().filter(ele-> ele.getText().contains("Rice")).map(ele->getPriceVeggi(ele)).collect(Collectors.toList());
		price.forEach(s->System.out.println("elemen with price :" + s));
		
		if(price.size()<1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(price.size()<1);
		
		Thread.sleep(3000);
		driver.quit();
		System.out.println("Program End");
	}

	private static String getPriceVeggi(WebElement ele) {
		// TODO Auto-generated method stub
		String priceValue=ele.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
