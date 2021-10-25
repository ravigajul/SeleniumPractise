/*
 * package Log4J; import org.apache.log4j.LogManager; import
 * org.apache.log4j.Logger; import org.apache.log4j.xml.DOMConfigurator; import
 * java.util.concurrent.TimeUnit; import org.openqa.selenium.*; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.interactions.Actions; import
 * org.openqa.selenium.support.ui.Select;
 * 
 * public class Log4jDemo { static final Logger logger =
 * LogManager.getLogger(Log4jDemo.class.getName());
 * 
 * public static void main(String[] args) {
 * 
 * DOMConfigurator.configure("Log4j.xml");
 * logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
 * logger.info("TEST Has Started");
 * System.setProperty("webdriver.chrome.driver",
 * "\\Users\\rgajul\\Documents\\Me\\elearning\\Ex_Files_Selenium_EssT\\Downloads\\chromedriver_win32\\chromedriver.exe"
 * );
 * 
 * WebDriver driver= new ChromeDriver(); driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 * driver.navigate().to("https://formy-project.herokuapp.com/form");
 * System.out.println(driver.getTitle());
 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 * logger.info("Appication is launched"); //First Name WebElement
 * txtFirstName=driver.findElement(By.id("first-name"));
 * txtFirstName.sendKeys("Ravi");
 * 
 * //Last Name WebElement txtLastName=driver.findElement(By.id("last-name"));
 * txtLastName.sendKeys("Gajul");
 * 
 * //Radio WebElement
 * rad=driver.findElement(By.xpath("//*[@id=\"radio-button-2\"]")); rad.click();
 * 
 * //Checkbox WebElement cBox=driver.findElement(By.id("checkbox-2"));
 * cBox.click();
 * 
 * //DropDown
 * 
 * Select drpYearsOfExp= new Select(driver.findElement(By.id("select-menu")));
 * drpYearsOfExp.selectByVisibleText("0-1"); drpYearsOfExp.selectByIndex(3);
 * 
 * //Date Picker
 * 
 * WebElement datePicker = driver.findElement(By.id("datepicker"));
 * datePicker.click(); WebElement prev= driver.findElement(By.xpath(
 * "/html/body/div[2]/div[1]/table/thead/tr[2]/th[1]")); prev.click();
 * logger.info("Initial data entered"); //navigating to home page.
 * 
 * driver.findElement(By.id("logo")).click();
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * logger.info("Navigated to Home Page"); //scroll down to element WebElement
 * KnMPress= driver.findElement(By.xpath("/html/body/div/div/li[9]/a")); Actions
 * actions = new Actions(driver); actions.moveToElement(KnMPress);
 * KnMPress.click(); logger.info("Scrolling successfully done"); //AutoComplete
 * 
 * driver.findElement(By.id("logo")).click();
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * driver.findElement(By.xpath("/html/body/div/div/li[1]/a")).click(); //click
 * Auto Complete driver.findElement(By.id("autocomplete")).
 * sendKeys("614 Marsh Trail Circle Northeast, Sandy Springs, GA, USA");
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * driver.findElement(By.className("pac-item")).click();
 * 
 * logger.info("Auto complete action successfully done"); //Switch to Active
 * Window
 * 
 * driver.findElement(By.id("logo")).click();
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * driver.findElement(By.xpath("/html/body/div/div/li[13]/a")).click(); //Click
 * Switch to Window driver.findElement(By.id("new-tab-button")).click();
 * 
 * String originalHandle=driver.getWindowHandle(); //getting the window handle
 * for(String handle1: driver.getWindowHandles()) {
 * driver.switchTo().window(handle1); //switching window
 * 
 * } driver.switchTo().window(originalHandle);
 * 
 * logger.info("Swtiching to Active Windows"); //switch to alert
 * 
 * driver.findElement(By.id("alert-button")).click(); Alert alert =
 * driver.switchTo().alert(); //switching to alert. // alert.accept();
 * alert.dismiss(); logger.warn("Alert dismissed");
 * 
 * //Execute Java Script driver.findElement(By.id("logo")).click();
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * driver.findElement(By.xpath("/html/body/div/div/li[10]/a")).click();
 * driver.findElement(By.id("modal-button")).click();
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * 
 * WebElement CloseButton = driver.findElement(By.id("close-button"));
 * JavascriptExecutor js=(JavascriptExecutor)driver;
 * js.executeScript("arguments[0].click();", CloseButton);
 * 
 * System.out.println("Test Complete!!"); //driver.quit();
 * logger.info("Test completed successfully"); logger.error("error test");
 * logger.debug("debug test");
 * 
 * logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
 * //Close the Browser. driver.close(); } }
 * 
 */