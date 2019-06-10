package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverPractise
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.ie.driver", "\\Users\\rgajul\\Downloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
//		\\System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgajul\\Documents\\Me\\elearning\\Ex_Files_Selenium_EssT\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver= new ChromeDriver();
		WebDriver driver= new InternetExplorerDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.cleartrip.com/");
		driver.findElement(By.cssSelector("#userAccountLink > span.span.span19.truncate")).click();
		driver.findElement(By.cssSelector("#SignIn")).click();
//		driver.switchTo().frame(driver.findElement(By.cssSelector("html")));
		driver.switchTo().frame(1);
		
		//Fluent Wait
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#email"))));
		driver.findElement(By.cssSelector("#email")).sendKeys("test@test.com");
		
		
		/*driver.navigate().to("https://formy-project.herokuapp.com/form");
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//First Name
		WebElement txtFirstName=driver.findElement(By.id("first-name"));
		txtFirstName.sendKeys("Ravi");
		
		//Last Name
		WebElement txtLastName=driver.findElement(By.id("last-name"));
		txtLastName.sendKeys("Gajul");
		
		//Radio
		WebElement rad=driver.findElement(By.xpath("//*[@id=\"radio-button-2\"]"));
		rad.click();
		
		//Checkbox
		WebElement cBox=driver.findElement(By.id("checkbox-2"));
		cBox.click();
		
		//DropDown
		
		Select drpYearsOfExp= new Select(driver.findElement(By.id("select-menu")));
		drpYearsOfExp.selectByVisibleText("0-1");
		drpYearsOfExp.selectByIndex(3);
		
		//Date Picker
		
		WebElement datePicker = driver.findElement(By.id("datepicker"));
		datePicker.click();
		WebElement prev= driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[2]/th[1]"));
		prev.click();
		
		//navigating to home page.
		
		driver.findElement(By.id("logo")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//scroll down to element
		WebElement KnMPress= driver.findElement(By.xpath("/html/body/div/div/li[9]/a"));
		Actions actions = new Actions(driver);
		actions.moveToElement(KnMPress);
		KnMPress.click();
		
		//AutoComplete
		
		driver.findElement(By.id("logo")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div/li[1]/a")).click(); //click Auto Complete
		driver.findElement(By.id("autocomplete")).sendKeys("614 Marsh Trail Circle Northeast, Sandy Springs, GA, USA");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("	).click();
		
		//Switch to Active Window
		
		driver.findElement(By.id("logo")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div/li[13]/a")).click(); //Click Switch to Window
		driver.findElement(By.id("new-tab-button")).click();
		
		String originalHandle=driver.getWindowHandle(); //getting the window handle
		for(String handle1: driver.getWindowHandles())
		{
			driver.switchTo().window(handle1); //switching window

		}
		driver.switchTo().window(originalHandle);
		
		
		//switch to alert
		
		driver.findElement(By.id("alert-button")).click();
		Alert alert = driver.switchTo().alert(); //switching to alert.
		// alert.accept();
		alert.dismiss();
		
		
		//Execute Java Script
		driver.findElement(By.id("logo")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div/li[10]/a")).click();
		driver.findElement(By.id("modal-button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement CloseButton = driver.findElement(By.id("close-button"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", CloseButton);
		
		System.out.println("Test Complete!!");
		//driver.quit();
		*/
	
	}

}
