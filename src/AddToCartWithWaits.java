
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartWithWaits {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		// "Cauliflower","Beetroot"

		String[] itename = { "Brocolli", "Cucumber", "Cauliflower", "Beetroot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItems(driver, itename);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		String promotext=driver.findElement(By.cssSelector("span.promoInfo")).getText();
		System.out.println("Text on the promo :" + promotext) ;
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		System.out.println("Program end");
	}

	public static void addItems(WebDriver driver, String[] itename) throws InterruptedException {
		int j = 0;
		List<WebElement> vegitables = driver.findElements(By.cssSelector("h4.product-name"));
		int size = vegitables.size();
		System.out.println("size of the vegetable :" + size);

		for (int i = 0; i < size; i++) {
			String[] splitname = vegitables.get(i).getText().split("-");
			// Cucumber - 1 Kg
			String name = splitname[0].trim();
			List itemlist = Arrays.asList(itename);
			if (itemlist.contains(name)) {
				j++;
				// button[text()='ADD TO CART']
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itename.length) {
					break;
				}

			}

		}

	}

}
