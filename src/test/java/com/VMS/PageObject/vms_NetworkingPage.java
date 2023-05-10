package com.VMS.PageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class vms_NetworkingPage {

	
	WebDriver ldriver;
	WebDriverWait wait;
	
	public vms_NetworkingPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
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
		 vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		   vms_ConfigurationPage cp = hm.openConfigurationPage();
		   cp.openNetworkingPage();
		try {
			Thread.sleep(500);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
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
	}
	
	public void enterVAXIP(String VAXIP)
	{
		VAXIPtestbox.click();
		VAXIPtestbox.clear();
		VAXIPtestbox.sendKeys(VAXIP);
	}
	
	public void clickOnSaveBtn()
	{
		saveBtn.click();
	}
	
	public void verifyConfiguredVAX() throws Exception
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
		Thread.sleep(1000);
		ldriver.manage().window().minimize();
		ldriver.close();
		ldriver.switchTo().window(MainWindow);
		
	}
	
	public void enableVAXTab(String VAXipToConfigure) throws Exception
	{
	if(verifyVAXtabIsEnabled().equalsIgnoreCase("Disabled"))
	{
	   openNetworingPage();
	   enabletheVAXIntegrationToggleBtn();
	   System.out.println("VAX Integration toggle btn enabled");
	   enterVAXIP(VAXipToConfigure);
	   System.out.println("VAX IP is entered");
	   clickOnSaveBtn();
	   Thread.sleep(1500);
	}
	else
	{  System.out.println("VAX Tab is already enabled.");  }
	
	}
	
	
	
	
	
}	
	
	