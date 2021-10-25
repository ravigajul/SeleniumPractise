package ElementInShadowDom;

import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDom {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		String chromeProfile = "C:\\Users\\rgajul\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
		ArrayList<String> switches = new ArrayList<String>();
		switches.add("--user-data-dir=" + chromeProfile);
		capabilities.setCapability("chrome.switches", switches);
		WebDriver driver = new ChromeDriver(capabilities);
		driver.get("chrome://downloads/");
		WebElement element = driver.findElement(By.tagName("downloads-manager"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"arguments[0].shadowRoot.getElementById('downloadsList').shadowRoot.getElementById('frb0').shadowRoot.getElementById('file-link').click();",
				element);
	}

}
