package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadDataRegressionExpress {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://uat.regressionxpress.dcpgreendot.com/settings/3");
		driver.findElement(By.cssSelector("input#username")).sendKeys("rgajul@deloitte.com");
		driver.findElement(By.cssSelector("input#password")).sendKeys("password");
		driver.findElement(By.cssSelector("p-button[type='submit']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='View Project']")).click();
		driver.findElement(By.xpath("//img[@src='assets/images/settings.svg']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Data Fields']")).click();	
		driver.findElement(By.xpath("//span[@class='p-button-label ng-star-inserted']")).click();
		driver.findElement(By.xpath("//input[@class='ng-untouched ng-pristine ng-invalid p-inputtext p-component']")).sendKeys("test");
	}

}
