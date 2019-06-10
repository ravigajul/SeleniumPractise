package Switching;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "\\Users\\rgajul\\Documents\\Me\\elearning\\Ex_Files_Selenium_EssT\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to("https://formy-project.herokuapp.com/switch-window");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String originalHandle=driver.getWindowHandle();
		driver.findElement(By.id("new-tab-button")).click();	
		driver.switchTo().window(originalHandle);
		driver.findElement(By.id("alert-button")).click();
		driver.switchTo().alert().accept();
	}
}
