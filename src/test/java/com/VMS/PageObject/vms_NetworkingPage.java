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
	
	@FindBy(xpath = "(//md-switch[@role='checkbox'])[2]") 
	public WebElement enableVAXIntegrationToggleBtn1;
	
	@FindBy(xpath = "(//div[@class='md-thumb'])[2]") 
	public WebElement enableVAXIntegrationToggleBtn2;
	
	@FindBy(css = "input[name='vaxAddress']")
	public WebElement VAXIPtestbox;
	
	@FindBy(xpath = "//div[@class='vms-big-btn-footer']/button[1]")
	public WebElement saveBtn;
	
	
	
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
		if(enableVAXIntegrationToggleBtn1.getAttribute("aria-checked").equalsIgnoreCase("true"))
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

		String childWindow = ldriver.getCurrentUrl();
		ldriver.manage().window().minimize();
		
		ldriver.switchTo().window(MainWindow);
		
	}
	
	
	
	
	
	
	
	
	
	
}	
	
	