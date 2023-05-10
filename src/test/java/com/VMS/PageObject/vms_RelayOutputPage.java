package com.VMS.PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vms_RelayOutputPage 
{
	WebDriver ldriver;
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public vms_RelayOutputPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindAll(@FindBy(xpath = "//div[@class='ui-grid-cell-contents ng-binding ng-scope']/parent::div")) 
	public List<WebElement> listOfpresentRelayOutputs;
	
	@FindBy(xpath = "//input[@type='search']") 
	public WebElement searchBtn;
	
	@FindBy(xpath = "//div[@class='configuration-ditails-form']//div[@class='md-bar']") 
	public WebElement visibleToggleBtn;    

	
	@FindBy(xpath = "//div[@class='configuration-ditails-form']//md-switch") 
	public WebElement checkStateOfToggleBtn;     // Attribute - aria-checked="false"
	
	@FindBy(xpath = "//div[@class='vms-bottom-btn-container bottom-separator-builder']/button[1]") 
	public WebElement SaveBtnOfRelayOutputPage ; 
	
	@FindBy(xpath = "//span[@class='vms-configuration-panel-title']/span[text()='Unsaved changes']") 
	public WebElement unsavedChangesPopupTitle ; 
	
	@FindBy(xpath = "//div[@id='vms-configurationScreen']//div/button[1]") 
	public WebElement saveChanges ; 
	
	@FindBy(xpath = "//div[@id='vms-configurationScreen']//div/button[2]") 
	public WebElement dontSaveChanges ; 

	@FindBy(xpath = "//div[@id='vms-configurationScreen']//div/button[3]") 
	public WebElement cancelChanges ; 
	
	@FindBy(xpath = "//button[text()='Test Active']") 
	public WebElement testActiveBtn ; 

	@FindBy(xpath = "//button[text()='Test Inactive']") 
	public WebElement testInactiveBtn ; 
	
	
	
	
	public void openRelayOutputPage()      
	{
	   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
	   vms_ConfigurationPage cp = hm.openConfigurationPage(); 
	   cp.openRelayOutputPage();
	}
		
	public void visibleAllVAXOutputs() throws Exception
	{
		searchBtn.sendKeys("VAX_Output");
		Thread.sleep(2000);
	
		for (int i = 0 ; i<listOfpresentRelayOutputs.size() ; i++)
		{
			listOfpresentRelayOutputs.get(i).click();
			Thread.sleep(500);
			if(checkStateOfToggleBtn.getAttribute("aria-checked").equalsIgnoreCase("false"))
			{
				Thread.sleep(500);      
				JavascriptExecutor js = ((JavascriptExecutor)ldriver);
				js.executeScript("arguments[0].click();", visibleToggleBtn);
				Thread.sleep(500);
			}
			else
			{
				System.out.println(listOfpresentRelayOutputs.get(i).getText() +" This Relay output is already visible.");
			}
			Thread.sleep(500);
			SaveBtnOfRelayOutputPage.click();
			Thread.sleep(3000);
		}
	}	
		
	public void visibleAllRelayOutputs() throws Exception
	{  
		Thread.sleep(2000);
		for (int i = 0 ; i<listOfpresentRelayOutputs.size() ; i++)
		{
			JavascriptExecutor js = ((JavascriptExecutor)ldriver);
			js.executeScript("arguments[0].click();", listOfpresentRelayOutputs.get(i));
	    	Thread.sleep(500);
			if(checkStateOfToggleBtn.getAttribute("aria-checked").equalsIgnoreCase("false"))
			{
				Thread.sleep(500);      
				js.executeScript("arguments[0].click();", visibleToggleBtn);
				Thread.sleep(500);
			}
			else
			{
				System.out.println(listOfpresentRelayOutputs.get(i).getText() +" This Relay output is already visible.");
			}
			Thread.sleep(500);
			SaveBtnOfRelayOutputPage.click();
			Thread.sleep(3000);
		}
	}
		
	public void triggerRelayOutput(String relayOutputName) throws Exception
	{
		JavascriptExecutor js = ((JavascriptExecutor)ldriver);
		Thread.sleep(2000);
		for (int i = 0 ; i<listOfpresentRelayOutputs.size() ; i++)
		{
			String currentRelayOP = listOfpresentRelayOutputs.get(i).getText();
			if (currentRelayOP.equalsIgnoreCase(relayOutputName))
			{
				
			    js.executeScript("arguments[0].click();", listOfpresentRelayOutputs.get(i));
	    	    Thread.sleep(1000);
	    	    
	    	    testActiveBtn.click();      Thread.sleep(3000);
				testInactiveBtn.click();    Thread.sleep(3000);
				testActiveBtn.click(); 		Thread.sleep(3000);
				testInactiveBtn.click(); 	Thread.sleep(3000);
				testActiveBtn.click();   	Thread.sleep(3000);
				testInactiveBtn.click();   	Thread.sleep(3000);
				testActiveBtn.click();		Thread.sleep(3000);
				testInactiveBtn.click();    Thread.sleep(3000);
			}
			
		}	
	}
	

}

















	
	
	
	

