package com.VMS.PageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VMS.TestCases.BaseClass;

public class vms_NetworkingPage {

	
	WebDriver ldriver;
	WebDriverWait wait;
	
	public vms_NetworkingPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		if (ldriver.getCurrentUrl().contains("configuration"))
		 {  vms_ConfigurationPage cp = new vms_ConfigurationPage(ldriver);
		    cp.openNetworkingPage();       }
		 else 
		 {   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		     vms_ConfigurationPage cp = hm.openConfigurationPage();
		     cp.openNetworkingPage();      }
	     BaseClass.wait(1000);
		 BaseClass.log.info("Networking page is opened");
	}
	
	// Identify webElements
	@FindBy(xpath = "//span[@vms-navigation-state='vax']") 
	public WebElement vaxTab;
	
	//@FindBy(xpath = "//toggle-switch[@name='openVaxInterface']/following-sibling::md-switch[@aria-checked='true']") 
	//public WebElement enableVAXIntegrationToggleBtn1;
	
	@FindBy(xpath = "//toggle-switch[@name='openVaxInterface']/following-sibling::md-switch[@aria-checked='false']") 
	public WebElement enableVAXIntegrationToggleBtn2;
	
	@FindBy(css = "input[name='vaxAddress']")
	public WebElement VAXIPtestbox;
	
	@FindBy(xpath = "//div[@class='vms-big-btn-footer']/button[1]")
	public WebElement saveBtn;
	
	
	
	public void openNetworingPage()
	{
		if (ldriver.getCurrentUrl().contains("configuration"))
		 {  vms_ConfigurationPage cp = new vms_ConfigurationPage(ldriver);
		    cp.openNetworkingPage();       }
		 else 
		 {   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		     vms_ConfigurationPage cp = hm.openConfigurationPage();
		     cp.openNetworkingPage();      }
           BaseClass.wait(500);
           BaseClass.log.info("Networking page is opened.");
	}
	
	public String verifyVAXtabIsEnabled()
	{
		String State;
		String vaxTabState = vaxTab.getAttribute("class");
		if(vaxTabState.contains("vms-menu-button-disabled"))
		{  State = "Disabled";  	}
		else 
		{  State = "Enabled";		}
		return State;
	}
		
	public void enabletheVAXIntegrationToggleBtn()
	{
		if(enableVAXIntegrationToggleBtn2.getAttribute("aria-checked").equalsIgnoreCase("true"))
		{ }
		else 
		{  enableVAXIntegrationToggleBtn2.click();   }
		BaseClass.log.info("Enable VAX taggle button is enabled.");
	}
	
	public void enterVAXIP(String VAXIP)
	{
		VAXIPtestbox.click();
		VAXIPtestbox.clear();
		VAXIPtestbox.sendKeys(VAXIP);
		BaseClass.log.info("VAX ip is entered");
	}
	
	public void clickOnSaveBtn()
	{
		saveBtn.click();
		BaseClass.log.info("Clicked on SAVE button");
	}
	
	public void verifyConfiguredVAX() 
	{
		String MainWindow, ChildWindow ;
		if(verifyVAXtabIsEnabled().equalsIgnoreCase("Enabled"))
		{
			vaxTab.click();
		}
		else
		{  System.out.println("VAX is not enabled.");    }
		
		Set<String> allWindows = ldriver.getWindowHandles();
		System.out.println("Total number of windows = "+allWindows.size());
		Iterator<String> I1= allWindows.iterator();
		
		MainWindow = I1.next();
		ChildWindow = I1.next();
		
		ldriver.switchTo().window(ChildWindow);
		BaseClass.wait(1000);
		ldriver.manage().window().minimize();
		ldriver.close();
		ldriver.switchTo().window(MainWindow);
		
	}
	
	public void enableVAXTab(String VAXipToConfigure) 
	{
	if(verifyVAXtabIsEnabled().equalsIgnoreCase("Disabled"))
	{
	   openNetworingPage();
	   enabletheVAXIntegrationToggleBtn();
	   enterVAXIP(VAXipToConfigure);
	   clickOnSaveBtn();
	   BaseClass.wait(1500);
	}
	else
	{  System.out.println("VAX Tab is already enabled.");  }
	
	}
	
	
	
	
	
}	
	
	