package Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchUrl {

	public static void main(String[] args) {

		System.out.println("Program Start");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Introduction\\Driver\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		String titleofPage=driver.getTitle();
		System.out.println("title of the page : " + titleofPage);
		
		String currenturl=driver.getCurrentUrl();
		System.out.println("current url of the page :" + titleofPage);
		
		System.out.println("Program End");
		driver.quit();
		
	}

}
