package ActionClassOfMouse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {

	public static void main(String[] args) {

		System.out.println("Program start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/droppable/  ");
		//Switching to frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		//identifying the source and the target elment
		WebElement source= driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target= driver.findElement(By.xpath("//div[@id='droppable']"));
		//Creating the object of the Actions class
		
		// how to know how much frame present inside the webpage
		//System.out.println(driver.findElement(By.tagName("iframe")).getSize());
		
		Actions action= new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
		driver.quit();
		System.out.println("Program end");
	}

}
