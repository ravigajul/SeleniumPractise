package com.test;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExtension {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File(
				"C:\\Program Files (x86)\\Pegasystems\\Pega Robot Studio\\BrowserExtensions\\Chrome\\lajjpilliikppcbaghjehndpfdiiphbe_main.crx"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String chromeProfile = "C:\\Users\\gajur\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
		ArrayList<String> switches = new ArrayList<String>();
		switches.add("--user-data-dir=" + chromeProfile);
		switches.add("--remote-debugging-port=6609");
		capabilities.setCapability("chrome.switches", switches);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get("https://www.google.com");
		driver.navigate().to("chrome://extensions/");

		WebElement host1 = driver.findElement(By.xpath("//extensions-manager"));
		SearchContext context1 = host1.getShadowRoot();
		Thread.sleep(1000);

		WebElement viewManager = context1
				.findElement(By.cssSelector("cr-view-manager#viewManager extensions-item-list#items-list"));
		SearchContext context2 = viewManager.getShadowRoot();
		Thread.sleep(1000);

		/* This can be deleted
		 * WebElement itemsList =
		 * context2.findElement(By.cssSelector("extensions-item-list#items-list"));
		 * SearchContext context3 = itemsList.getShadowRoot(); Thread.sleep(1000);
		 */

		WebElement addin = context2.findElement(By.cssSelector("extensions-item#lajjpilliikppcbaghjehndpfdiiphbe"));
		SearchContext context3 = addin.getShadowRoot();
		Thread.sleep(1000);

		WebElement toggleBtn = context3.findElement(By.cssSelector("cr-toggle#enableToggle"));
		SearchContext context4 = toggleBtn.getShadowRoot();
		Thread.sleep(1000);

		WebElement knob = context4.findElement(By.cssSelector("span#knob"));
		knob.click();
		System.out.println("test");

		/*
		 * driver.findElement(By.xpath("//extensions-manager")).getShadowRoot()
		 * .findElement(By.
		 * cssSelector("cr-view-manager#viewManager extensions-item-list#items-list"))
		 * .getShadowRoot().findElement(By.cssSelector(
		 * "extensions-item#lajjpilliikppcbaghjehndpfdiiphbe"))
		 * .getShadowRoot().findElement(By.cssSelector("cr-toggle#enableToggle")).
		 * getShadowRoot() .findElement(By.cssSelector("span#knob")).click();
		 */

		System.out.println("test");

	}
}
