package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormyPage {

	public static WebElement txtFirstName(WebDriver driver) {
		return driver.findElement(By.id("first-name"));
	}
	public static WebElement txtLastName(WebDriver driver) {
		return driver.findElement(By.id("last-name"));
	}
	public static WebElement txtJobTitle(WebDriver driver) {
		return driver.findElement(By.id("job-title"));
	}
	public static WebElement radEdu(WebDriver driver) {
		return driver.findElement(By.id("radio-button-2"));
	}
	public static WebElement chkSex(WebDriver driver) {
		return driver.findElement(By.id("checkbox-1"));
	}
	
	public static Select drpExp(WebDriver driver) {
		Select drpYearsOfExp= new Select(driver.findElement(By.id("select-menu")));
		return drpYearsOfExp; 
	}
	public static WebElement dteDate(WebDriver driver) {
		return driver.findElement(By.id("datepicker"));
	}
	public static WebElement btnSubmit(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a"));
	}
	public static WebElement txtMessage(WebDriver driver) {
		return driver.findElement(By.xpath("/html/body/div/div1"));
	}
	
}
