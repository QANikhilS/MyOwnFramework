package com.VMS.PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VMS.TestCases.BaseClass;

public class vms_DigitalInputsPage {
	
	WebDriver ldriver;
	
	public vms_DigitalInputsPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	     if (ldriver.getCurrentUrl().contains("configuration"))
		 {  vms_ConfigurationPage cp = new vms_ConfigurationPage(ldriver);
		    cp.openDigitalInputPage();       }
		 else 
		 {   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		     vms_ConfigurationPage cp = hm.openConfigurationPage();
		     cp.openDigitalInputPage();      }    
	     BaseClass.wait(1000);
		 BaseClass.log.info("Digital Input page is opened");
	}
	
	@FindAll(@FindBy(xpath = "//div[@class='ui-grid-cell-contents ng-binding ng-scope']/parent::div")) 
	public List<WebElement> listOfpresentDigitalInputs;
	
	@FindBy(xpath = "//input[@type='search']") 
	public WebElement searchBtn;
	
	@FindBy(xpath = "//div[@class='configuration-ditails-form']//div[@class='md-bar']") 
	public WebElement visibleToggleBtn;    

	
	@FindBy(xpath = "//div[@class='configuration-ditails-form']//md-switch") 
	public WebElement checkStateOfToggleBtn;     // Attribute - aria-checked="false"
	
	@FindBy(xpath = "//div[@class='vms-bottom-btn-container bottom-separator-builder']/button[1]") 
	public WebElement SaveBtnOfDigitalInputPage ; 
	
	@FindBy(xpath = "//span[@class='vms-configuration-panel-title']/span[text()='Unsaved changes']") 
	public WebElement unsavedChangesPopupTitle ; 
	
	@FindBy(xpath = "//div[@id='vms-configurationScreen']//div/button[1]") 
	public WebElement saveChanges ; 
	
	@FindBy(xpath = "//div[@id='vms-configurationScreen']//div/button[2]") 
	public WebElement dontSaveChanges ; 

	@FindBy(xpath = "//div[@id='vms-configurationScreen']//div/button[3]") 
	public WebElement cancelChanges ; 
	
	@FindBy(xpath = "//p[@class='vms-configuration-panel-right-text goto-device-outer ng-binding']") 
	public WebElement vaxPanelNameOfDigitalInput ; 
	
	
	

		
	public void visibleAllVAXInputs() throws Exception
	{
		searchBtn.sendKeys("VAX_Input");
		Thread.sleep(2000);
	
		for (int i = 0 ; i<listOfpresentDigitalInputs.size() ; i++)
		{
			listOfpresentDigitalInputs.get(i).click();
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
				System.out.println(listOfpresentDigitalInputs.get(i).getText() +" This Digital input is already visible.");
			}
			Thread.sleep(500);
			SaveBtnOfDigitalInputPage.click();
			Thread.sleep(3000);
		}
	}	
		
	public void visibleAllDigitalInputs() throws Exception
	{  
		Thread.sleep(2000);
		for (int i = 0 ; i<listOfpresentDigitalInputs.size() ; i++)
		{
			JavascriptExecutor js = ((JavascriptExecutor)ldriver);
			js.executeScript("arguments[0].click();", listOfpresentDigitalInputs.get(i));
	    	Thread.sleep(500);
			if(checkStateOfToggleBtn.getAttribute("aria-checked").equalsIgnoreCase("false"))
			{
				Thread.sleep(500);      
				js.executeScript("arguments[0].click();", visibleToggleBtn);
				Thread.sleep(500);
			}
			else
			{
				System.out.println(listOfpresentDigitalInputs.get(i).getText() +" This Digital input is already visible.");
			}
			Thread.sleep(500);
			SaveBtnOfDigitalInputPage.click();
			Thread.sleep(3000);
		}
	}
		
	
	public void handleUnsavedChanges_Save()
	{
		//span[@class='vms-configuration-panel-title']/span[text()='Unsaved changes']
	}
	

}
















