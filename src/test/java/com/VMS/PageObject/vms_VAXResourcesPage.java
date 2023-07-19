package com.VMS.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class vms_VAXResourcesPage 
{
	WebDriver ldriver;
	WebDriverWait wait ;
	
	public vms_VAXResourcesPage(WebDriver rdriver)
	{
	     ldriver = rdriver;
	     PageFactory.initElements(rdriver, this);
	     wait = new WebDriverWait(ldriver, Duration.ofSeconds(15));
	}
	
	@FindAll(@FindBy(xpath = "//span[contains(@ng-if,'VAXDoorResource')]"))
	public List<WebElement> allVAXdoorsInVMS ;
	
	@FindAll(@FindBy(xpath = "//span[contains(@ng-if,'VAXActionPlanResource')]"))
	public List<WebElement> allVAXactionPlansInVMS ;
	
	
	
	
	
	
	public void openVAXResourcesPage()
    {
	   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
	   vms_ConfigurationPage cp = hm.openConfigurationPage();
	  cp.openVAXResourcesPage();
	try {
		Thread.sleep(500);
    } catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
