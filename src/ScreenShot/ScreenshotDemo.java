package ScreenShot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectModel.FormyPage;

public class ScreenshotDemo {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"\\Users\\rgajul\\Documents\\Me\\elearning\\Ex_Files_Selenium_EssT\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://formy-project.herokuapp.com/form");
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FormyPage.txtFirstName(driver).sendKeys("Ravi");
		FormyPage.txtLastName(driver).sendKeys("Gajul");
		FormyPage.txtJobTitle(driver).sendKeys("Test Engineer");
		FormyPage.chkSex(driver).click();
		FormyPage.drpExp(driver).selectByIndex(3);
		FormyPage.radEdu(driver).click();
		FormyPage.dteDate(driver).sendKeys("02/01/2019");
		FormyPage.btnSubmit(driver).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {

			if (FormyPage.txtMessage(driver).getText().equalsIgnoreCase("The form was successfully submitted!")) {
				System.out.println(FormyPage.txtMessage(driver).getText());
			} else {
				System.out.println("There was an error submitting the page");
			}
		}

		catch(Exception e)
		{
			
			//take screenshots
			  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(screenshot, new File("C:\\Users\\rgajul\\eclipse-workspace\\SeleniumPractise\\src\\ScreenShot\\screenshots.png"));
			
		}
	}
}
