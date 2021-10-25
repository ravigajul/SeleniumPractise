package ExecuteJavaScript;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExecuteJS {

	@Test
	public void JSEnterData() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://formy-project.herokuapp.com/form");	
		
		//execute by arg[0]
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement el=(WebElement) js.executeScript("return document.querySelector('input#first-name')");
		js.executeScript("arguments[0].value='TestJSDataEntry';",el);
		Thread.sleep(3000);
		
		//execute by js in dom
		js.executeScript("document.querySelector('input#first-name').value='OtherValue';");
		Thread.sleep(3000);
		
		//execute by selenium on element returned by js
		el.clear();
		el.sendKeys("Hahaha");
	}
}
