package com.VMS.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

import com.VMS.PageObject.vms_AlarmsJournalPage;
import com.VMS.PageObject.vms_AlarmsPage;
import com.VMS.PageObject.vms_CamerasAndDevicesPage;
import com.VMS.PageObject.vms_DigitalInputsPage;
import com.VMS.PageObject.vms_EventAlarmsSearchPage;
import com.VMS.PageObject.vms_GroupHierarchyPage;
import com.VMS.PageObject.vms_IntegrationPartnerPage;
import com.VMS.PageObject.vms_Login;
import com.VMS.PageObject.vms_MapPage;
import com.VMS.PageObject.vms_NetworkingPage;
import com.VMS.PageObject.vms_ProcedurePage;
import com.VMS.PageObject.vms_RelayOutputPage;
import com.VMS.PageObject.vms_VAXResourcesPage;
import com.VMS.PageObject.vms_VAXWebpagePage;
import com.VMS.PageObject.vms_WebPagesPage;
import com.VMS.Utilities.readConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass 
{
	public static readConfig readConfigData = new readConfig();
	public static String VMSURL = readConfigData.getBaseURL();
	public static String BrowserName = readConfigData.getBrowser();
	public static WebDriver driver;
	public static Logger log =  LogManager.getLogger("zOwnProject");
	public static String currentIP;
	public static FileInputStream fs;		
	
	public vms_CamerasAndDevicesPage camAndDev;
	public vms_IntegrationPartnerPage Integrationpartner;
	public vms_WebPagesPage webpage ;
	public vms_ProcedurePage procedure ;
	public vms_AlarmsPage alarm ;
	public vms_NetworkingPage networking ;
	public vms_VAXWebpagePage vaxwebserver ; 
	public vms_EventAlarmsSearchPage EventQuerySearch; 
	public vms_DigitalInputsPage DigitalInput ;
	public vms_RelayOutputPage RelayOutput ;
	public vms_MapPage Maps ;
	public vms_GroupHierarchyPage GroupH ;
	public vms_AlarmsJournalPage AlarmTab ;
	public vms_VAXResourcesPage VAXresources ;
	public JavascriptExecutor executor;
	
	
	
	@BeforeClass
	public void setup() throws Exception
	{
		switch (BrowserName.toLowerCase())
		{
		   case "chrome" :
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--remote-allow-origins=*");
				opt.setExperimentalOption("prefs", prefs);
				opt.addArguments("--disable-extensions");
				opt.addArguments("disable-infobars");
				//opt.addArguments("--headless");
				opt.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});  // To disable info bar - Chrome is being controlled by automated test software
				WebDriverManager.chromedriver().setup();
	    	    driver = new ChromeDriver(opt);	
	    	    log.debug("Chrome Browser is opened");
			break;

		   case "edge" :
				WebDriverManager.edgedriver().setup();
			    driver = new EdgeDriver();
			    driver.manage().window().maximize();
			break;
			
		   case "ie" :
				System.setProperty("webdriver.ie.driver", ".\\Drivers\\IEDriverServer.exe");
			    driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			break;
						
		default:
			driver = null ;
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// Implicit wait of 30 seconds on all web Element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(VMSURL);
			
		  vms_Login login = new vms_Login(driver); 
		  login.DoLogin();
		 
		  camAndDev = new vms_CamerasAndDevicesPage(driver); 
		  webpage = new vms_WebPagesPage(driver);  
		  procedure = new vms_ProcedurePage(driver);
		  alarm = new vms_AlarmsPage(driver);
		  networking = new vms_NetworkingPage(driver);
		  vaxwebserver = new vms_VAXWebpagePage(driver);
		  Integrationpartner = new vms_IntegrationPartnerPage(driver);
		  EventQuerySearch = new vms_EventAlarmsSearchPage(driver);
		  DigitalInput= new vms_DigitalInputsPage(driver);
		  RelayOutput = new vms_RelayOutputPage(driver);
		  Maps = new vms_MapPage(driver);
		  GroupH = new vms_GroupHierarchyPage(driver);
		  AlarmTab = new vms_AlarmsJournalPage(driver);
		  VAXresources = new vms_VAXResourcesPage(driver);
		  fs = new FileInputStream("C:\\Users\\nikhils\\Music\\OwnFramework\\TestData\\TestData.xlsx");		
		  
	}
		
	public void handlePlayerWidnow() throws Exception
	{
		try 
		  { 
			WebElement playerPopup = driver.findElement(By.xpath("//iframe[1]"));
   		  if (playerPopup.isDisplayed())
	     	  {   Thread.sleep(2000);
		          Actions act = new Actions(driver);
		          act.sendKeys(Keys.ESCAPE).build().perform(); // Close the player window popup
		          Thread.sleep(1000);		  }
		      else 
		        {     System.out.println("Logged in to application succesfully and Monitoring page has been opened.");     }
		  }		  
		  catch(Exception e) 
		   {    WebElement playerPopup = driver.findElement(By.xpath("//iframe[1]")); 
			    if (playerPopup.isDisplayed())
			    {    driver.switchTo().frame(1);
		             System.out.println("Switched to player popup frame successfully"); // Switch to player popup window. 
		             Thread.sleep(1000);
		             driver.findElement(By.cssSelector("button[ng-click$='close()']")).click();
		             Thread.sleep(500); 
		             driver.switchTo().defaultContent(); 
             	     // Switch back to main/default frame/window. 
		         } 
		        else 
		         {        System.out.println("Logged in to application succesfully and Monitoring page has been opened.");      }
		   }
		}
	
	public void capctureScreenshot(WebDriver driver, String testName) throws IOException
	  {
		// Step 1: Convert WebDriver object to TakeScreenshot Interface.
		TakesScreenshot screenshot = ((TakesScreenshot)driver); 
		
		//Step 2 : Call getScreenshotAs method to create image file.
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");  
	
		// Step 3 : Copy image file to destination.
		FileUtils.copyFile(src, dest);
	  }
	
	public static String getcurrentMachineIP() throws Exception 
	  {
		try(final DatagramSocket socket = new DatagramSocket())
		{     socket.connect(InetAddress.getByName("8.8.4.4"), 80);
			  currentIP = socket.getLocalAddress().getHostAddress();       }
		return currentIP;
	  }
	
	public static void jsClick(WebElement Element)
	  {JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", Element);  }
	
	public static void jsScrollDownByPixels(int pixels) throws Exception
	  {JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("window.scrollBy(0,"+pixels+")"); }
	
	public static void jsSendKeys(WebElement textBoxToEnterTextUsingJS, String textToEnter) throws Exception
	  {    JavascriptExecutor executor = (JavascriptExecutor)driver;
		   executor.executeScript("document.getElementByID("+textBoxToEnterTextUsingJS+").value = ‘"+textToEnter+"’;");      }
	
	public static void wait(int sleepTime)
	{
		try { Thread.sleep(sleepTime); } catch (InterruptedException e) { e.printStackTrace();  }
	}
	
	
	
	
	
	
	//@AfterClass
	public void tearDown()
	{
		if (driver != null)
		driver.close();
		driver.quit();
	}
	
}
