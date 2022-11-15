package com.VMS.TestCases;

import java.io.File;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.Duration;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

import com.VMS.PageObject.vms_Login;
import com.VMS.Utilities.readConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass 

  {
	public static readConfig readConfigData = new readConfig();
	public static String VMSURL = readConfigData.getBaseURL();
	public static String BrowserName = readConfigData.getBrowser();
	public static WebDriver driver;
	public static Logger log ;
	public static String currentIP;
	
	
	@BeforeClass
	public static void setup()
	{
		switch (BrowserName.toLowerCase())
		{
		   case "chrome" :
			   WebDriverManager.chromedriver().setup();
			   driver = new ChromeDriver();
				driver.manage().window().maximize();
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
			break;
						
		default:
			driver = null ;
			break;
		}
		
		// Implicit wait of 30 seconds on all web Element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// for Logging.
		log =  LogManager.getLogger("zOwnProject");
		
		vms_Login login = new vms_Login(driver);
		login.DoLogin();		
	}
		
	public void handlePlayerWidnow() throws Exception
	{
		try 
		  { 
			WebElement playerPopup = driver.findElement(By.xpath("//iframe[1]"));
   		  if (playerPopup.isDisplayed())
	     	  { 
   			      Thread.sleep(2000);
		          Actions act = new Actions(driver);
		          act.sendKeys(Keys.ESCAPE).build().perform(); // Close the player window popup
		          Thread.sleep(1000);		           
		       }
		      else 
		        {
			       System.out.println("Logged in to application succesfully and Monitoring page has been opened."); 
		        }
		  }		  
		  catch(Exception e) 
		   { 
			    WebElement playerPopup = driver.findElement(By.xpath("//iframe[1]")); 
			    if (playerPopup.isDisplayed())
			    {
		           driver.switchTo().frame(1);
		           System.out.println("Switched to player popup frame successfully"); // Switch to player popup window. 
		           Thread.sleep(1000);
		           driver.findElement(By.cssSelector("button[ng-click$='close()']")).click();
		           Thread.sleep(500); 
		           driver.switchTo().defaultContent(); 
             	  // Switch back to main/default frame/window. 
		         } 
		  else 
		    { 
			  System.out.println("Logged in to application succesfully and Monitoring page has been opened.");
		    }
		  
		  }
	}
	
	public void capctureScreenshot(WebDriver driver, String testName) throws IOException
	  {
		// Step 1: Convert WebDriver object to TakeScreenshot Interface.
		TakesScreenshot screenshot = ((TakesScreenshot)driver); 
		
		//Step 2 : Call getScreenshotAs method to create image file.
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png");  
		
		// Step 3 : Copy image file to destination.
		FileUtils.copyFile(src, dest);
	  }
	
	
	public static String getcurrentMachineIP() throws Exception
	  {
		try(final DatagramSocket socket = new DatagramSocket())
		{
			  socket.connect(InetAddress.getByName("8.8.4.4"), 80);
			  currentIP = socket.getLocalAddress().getHostAddress();
	    }
		return currentIP;
	  }
	
	
	public static void jsClick(WebElement Element) throws Exception
	  {JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", Element);
	  }
	
	
	//@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
	
	

}
