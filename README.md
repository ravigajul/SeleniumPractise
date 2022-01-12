# SeleniumPractise
https://www.selenium.dev/documentation/en/webdriver/browser_manipulation/
# History
2004 Selenium 1.4
Supports Major Programming Languges
Apache 2.0 License- Open Source
Web Driver API--Native calls to the browsers
Browsers Drivers provided by browser vendors
# Selenium Grid
For parallel testing -multiple selenium tests to run concurrently both local and remote servers
# Selenium IDE 
Firefox plugging for record and play back.

# Drivers
ChromeDriver --owned by Google
GeckoDriver --Owned by Mozilla
EdgeDriver--Owned by Microsoft
Safari Driver--Owned by Apple
WebdriverManager --Bongarcia's for automatic driver executable download.
# Headless Chrome Browser Testing
## ChromeOptions options= new ChromeOptions();
## Options.addArguments("window-size=1400,800");
## Options.addArguments("headless")'

# Browser Navigation
    1 	driver.getCurrentUrl();
    2 	driver.navigate().back();
    3 	driver.navigate().forward();
    4 	driver.navigate().refresh();
    5 	driver.getTitle();    6 	
    7 	// Opens a new tab and switches to new tab
    8 	driver.switchTo().newWindow(WindowType.TAB);
    9 	// Opens a new window and switches to new window
   10 	driver.switchTo().newWindow(WindowType.WINDOW);   11 	
   12 	//Close the tab or window
   13 	driver.close();   14 	
   15 	//Switch back to the old tab or window
   16 	driver.switchTo().window(originalWindow);
  # iframes
    1 	//This won't work
    2 	driver.findElement(By.tagName("button")).click();
    3 	//Store the web element
    4 	WebElement iframe = driver.findElement(By.cssSelector("#modal>iframe"));
    6 	//Switch to the frame
    7 	driver.switchTo().frame(iframe);    8 	
    9 	//Now we can click the button
   10 	driver.findElement(By.tagName("button")).click(); 
# Leaving a frame
    1 	// Return to the top level
    2 	driver.switchTo().defaultContent();  
# Switching windows or tabs	
	//Store the ID of the original window
	String originalWindow = driver.getWindowHandle();	
	//Check we don't have other windows open already
	assert driver.getWindowHandles().size() == 1;	
	//Click the link which opens in a new window
	driver.findElement(By.linkText("new window")).click();	
	//Wait for the new window or tab
	wait.until(numberOfWindowsToBe(2));	
	//Loop through until we find a new window handle
	for (String windowHandle : driver.getWindowHandles()) {
	    if(!originalWindow.contentEquals(windowHandle)) {
	        driver.switchTo().window(windowHandle);
	        break;
	    }
	}
	//Wait for the new tab to finish loading content
	wait.until(titleIs("Selenium documentation"));	
# Ways to Find Element
By.ClassName
By.CssSelector
By.Id
By.Name
By.Xpath
# Xpath-Axes
	1. Parent
		a. Syntax:  <<xpath of some element>>//parent::<<parents tag>>
	2. Preceding Sibling
		a. Syntax: <<xpath of some element>>//preceding-sibling::<<sibling tag>>
	3. Following Sibling
		a. Syntax: <<xpath of some element>>//following-sibling::<<followingtag>>

# Relative Locators
Selenium uses the JavaScript function getBoundingClientRect() to find the relative elements. This function returns properties of an element such as right, left, bottom, and top, near(
Returns the WebElement, which is at most 50px away from the specified element)

    1 	import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
    2 	
    3 	WebElement passwordField= driver.findElement(By.id("password"));
    4 	WebElement emailAddressField = driver.findElement(withTagName("input")
    5 	                                                  .above(passwordField));
  



# Actions

Element.SendKeys
Element.Submit
Click
DragandDrop
KeyDown
MoveToElement


# Assertions
# Exception handling

# Synchronization
## Implict Wait
An implicit wait is to tell WebDriver to poll the DOM for a certain amount of time when trying to find an element or elements if they are not immediately available. The default setting is 0, meaning disabled. Once set, the implicit wait is set for the life of the session.	
	WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://somedomain/url_that_delays_loading");
	WebElement myDynamicElement = driver.findElement(By.id("myDynamicElement"));
## Explicit Wait
Explicit waits are available to Selenium clients for imperative, procedural languages. They allow your code to halt program execution, or freeze the thread, until the condition you pass it resolves. The condition is called with a certain frequency until the timeout of the wait is elapsed. This means that for as long as the condition returns a falsy value, it will keep trying and waiting.	
	WebDriver driver = new ChromeDriver();
	driver.get("https://google.com/ncr");
	driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
	// Initialize and wait till element(link) became clickable - timeout in 10 seconds
	WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
	// Print the first result
	System.out.println(firstResult.getText());
## FluentWait 
	FluentWait instance defines the maximum amount of time to wait for a condition, as well as the frequency with which to check the condition.
	Users may configure the wait to ignore specific types of exceptions whilst waiting, such as NoSuchElementException when searching for an element on the page.	
	// Waiting 30 seconds for an element to be present on the page, checking
	// for its presence once every 5 seconds.
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	  .withTimeout(Duration.ofSeconds(30))
	  .pollingEvery(Duration.ofSeconds(5))
	  .ignoring(NoSuchElementException.class);
	
	WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	  public WebElement apply(WebDriver driver) {
	    return driver.findElement(By.id("foo"));
	  }
	});
	
	From <https://www.selenium.dev/documentation/en/webdriver/waits/> 
# ScreenShots
## FullScreen
    1 	import org.apache.commons.io.FileUtils;
    2 	import org.openqa.selenium.chrome.ChromeDriver;
    3 	import java.io.*;
    4 	import org.openqa.selenium.*;
    5 	
    6 	public class SeleniumTakeScreenshot {
    7 	    public static void main(String args[]) throws IOException {
    8 	        WebDriver driver = new ChromeDriver();
    9 	        driver.get("http://www.example.com");
   10 	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   11 	        FileUtils.copyFile(scrFile, new File("./image.png"));
   12 	        driver.quit();
   13 	    }
   14 	}
  
## TakeElementScreenshot
    1 	import org.apache.commons.io.FileUtils;
    2 	import org.openqa.selenium.*;
    3 	import org.openqa.selenium.chrome.ChromeDriver;
    4 	import java.io.File;
    5 	import java.io.IOException;
    6 	
    7 	public class SeleniumelementTakeScreenshot {
    8 	  public static void main(String args[]) throws IOException {
    9 	    WebDriver driver = new ChromeDriver();
   10 	    driver.get("https://www.example.com");
   11 	    WebElement element = driver.findElement(By.cssSelector("h1"));
   12 	    File scrFile = element.getScreenshotAs(OutputType.FILE);
   13 	    FileUtils.copyFile(scrFile, new File("./image.png"));
   14 	    driver.quit();
   15 	  }
   16 	}
   17 
 # Http proxies
    1 	import org.openqa.selenium.Proxy;
    2 	import org.openqa.selenium.WebDriver;
    3 	import org.openqa.selenium.chrome.ChromeDriver;
    4 	import org.openqa.selenium.chrome.ChromeOptions;
    5 	
    6 	public class proxyTest {
    7 	  public static void main(String[] args) {
    8 	    Proxy proxy = new Proxy();
    9 	    proxy.setHttpProxy("<HOST:PORT>");
   10 	    ChromeOptions options = new ChromeOptions();
   11 	    options.setCapability("proxy", proxy);
   12 	    WebDriver driver = new ChromeDriver(options);
   13 	    driver.get("https://www.google.com/");
   14 	    driver.manage().window().maximize();
   15 	    driver.quit();
   16 	  }
   17 	}
  

# Parameterization

## @Parameter
## @dataprovider

# Inspect AutoHide Panel
How do you inspect a autohide panel : while in source panel of inspector window, click F8 to turn on the debug mode. The screen pauses there to inspect the element.

# CSS Selector
To go to sibling we write nth of type
https://www.noon.com/uae-en/

div.sc-GTWni.GkeGT>div:nth-of-type(2)

Chropath/selectorshub  addin in chrome for rel/abs xpath

Absolute Xpath : starts from the root node. If the element location is changed, identification fails. Always starts with single /
Relative Xpath - start with double // . Starts from the middle of the DOM

# Xpath-Methods 

	1. Ancestor //input[@id="test"]/ancestor ::*
	2. Ancestor-or-self //input[@id="test"]/ancestor-or-self ::*
	3. Child  //input[@id="test"]/child::*
	4. Parent
	5. Preceding
	6. Following
	7. Self
	8. Descendent
	9. Shadow DOM : xpath doesn't support shadow dom, hence we write css selector
	10. For SVG element  : //*[local-name()='svg']
	11. //*[normalize-space()='Practice Projects'] ---To remove leading spaces when checking

# Challenges

Cannot test windows application. Doesn't support window based applications
We cannot test mobile apps
Limited reporting. However TestNG can be used
Handling dynamic elements..with xpath or css selectors ..
Handling page load. Use explicit waits 
Window based pop up windows. Auto IT for windows based pop ups
Automate Captcha..general issue for all automation.
Selenium cannot be used for automation flash objects-for ex: You tube videos. SIKULI can be used

# AUTO IT -
 Is a third party software used for automating windows based appliations that can be integrated with selenium
    1 	Autoit.au3 compile Autoit.au3 script to generate autoit.exe and call it like below.
    2 	ControlFocus("Open","",1148)
    3 	ControlSetText("Open","",1148,"C:\Users\rgajul\Desktop\Tejawsi.txt")
    4 	sleep(1000)
    5 	ControlClick("Open","",1148)
    6 	Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/com/uploadfile/Upload.exe");
    7 
# SIKULI

SIKULI/SIKULIXAPI- is a third party automation tool that recognizes objects through image based recognition.


# Object repository

Page Object Model
Id, classname, name, tagname, linkedtext, xpath, css selectors.

How do you find out all the broken links in a webpage?
    1 	WebDriverManager.chromedriver().setup();
    2 	WebDriver driver=new ChromeDriver();
    3 	        driver.get("https://demoqa.com/broken");
    4 	        List<WebElement> urls=driver.findElements(By.tagName("a"));
    5 	        HttpURLConnection huc=null;
    6 	        String url="";
    7 	        for (WebElement webElement : urls) {
    8 	                url=webElement.getAttribute("href");
    9 	                if(url==""){
   10 	                        System.out.println("href is not configured");
   11 	                }else{
   12 	                        huc=(HttpURLConnection) new URL(url).openConnection();
   13 	                        huc.setRequestMethod("HEAD");
   14 	                        huc.connect();
   15 	                        int responseCode = huc.getResponseCode();
   16 	                        if(responseCode>=400){
   17 	                                System.out.println(webElement.getText() + "--->url is broken");
   18 	                        }else{
   19 	                                System.out.println(webElement.getText() + "-->url is not broken");
   20 	                        }
   21 	                }
   22 	                
   23 	                
   24 	        }
   25 	        driver.quit();
   26 	}
  
  # Uploading a File/Windows Authentication

	1. Sendkeys("file path") will work if the element being used is <input type ='file'] //input[@type='file']
	2. Use Robot Class
	3. Use AutoIT

Install AutoIt and AutoIT editor. Auto it is a third party software to automate windows applications.
Record or generate script in autoit editor. Compile the script to generate a corresponding .exe from .au3 script
Use Runtime.getRunTime().exec("path of the .exe file generated above")

# Design Patterns
##  SRP Design Pattern (Single Responsibility Pattern)

Difference between scanner.next and scanner.nextLine(); why scanner.next line doesn't print the string if it is used after scanner.nextInt();

Scanner scan = new Scanner(System.in)
int i = scan.nextInt();
double d=scan.nextDouble();
scan.nextLine(); // this will read the '\n' character left out by previous statement so that the next line can read full line as it is.
String s=scan.nextLine();

Output Formatting
System.out.printf("%-15s%03d%n",s1,x);
%-15s…15 characters in total left justified(can be spaces after a word)
%15s ….15 characters as is and no justification
%03d ---Leading digits with 000's if the original number is less than 3 digits.
The first column contains the String and is left justified using exactly  characters.
The second column contains the integer, expressed in exactly  digits; if the original input has less than three digits, you must pad your output's leading digits with zeroes.
![image](https://user-images.githubusercontent.com/51070896/119314789-c584e480-bc92-11eb-8125-9ff2f36df4bb.png)
		
# Handling Nested Shadow Elements
	driver.findElement(By.xpath("//extensions-manager")).getShadowRoot()
				.findElement(By.cssSelector("cr-view-manager#viewManager extensions-item-list#items-list"))
				.getShadowRoot().findElement(By.cssSelector("extensions-item#lajjpilliikppcbaghjehndpfdiiphbe"))
				.getShadowRoot().findElement(By.cssSelector("cr-toggle#enableToggle")).getShadowRoot()
				.findElement(By.cssSelector("span#knob")).click()
		
		or 
	WebElement host1 = driver.findElement(By.xpath("//extensions-manager"));
	SearchContext context1 = host1.getShadowRoot();
	Thread.sleep(1000);

	WebElement viewManager = context1.findElement(By.cssSelector("cr-view-manager#viewManager extensions-item-list#items-list"));
	SearchContext context2 = viewManager.getShadowRoot();
	Thread.sleep(1000);
	WebElement addin = context2.findElement(By.cssSelector("extensions-item#lajjpilliikppcbaghjehndpfdiiphbe"));
	SearchContext context3 = addin.getShadowRoot();
	Thread.sleep(1000);

	WebElement toggleBtn = context3.findElement(By.cssSelector("cr-toggle#enableToggle"));
	SearchContext context4 = toggleBtn.getShadowRoot();
	Thread.sleep(1000);

	WebElement knob = context4.findElement(By.cssSelector("span#knob"));
	knob.click();
