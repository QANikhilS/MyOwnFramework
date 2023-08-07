package com.VMS.PageObject;

import java.util.List;

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
<<<<<<< HEAD
	     if (ldriver.getCurrentUrl().contains("configuration"))
=======
		if (ldriver.getCurrentUrl().contains("configuration"))
>>>>>>> 2a100a0fd94d72e8f3a4f35948a220a30992cf2c
		 {  vms_ConfigurationPage cp = new vms_ConfigurationPage(ldriver);
		    cp.openDigitalInputPage();       }
		 else 
		 {   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		     vms_ConfigurationPage cp = hm.openConfigurationPage();
<<<<<<< HEAD
		     cp.openDigitalInputPage();      }    
	     BaseClass.wait(1000);
		 BaseClass.log.info("Digital Input page is opened");
=======
		     cp.openDigitalInputPage();      }
	     BaseClass.wait(1000);
		 BaseClass.log.info("Procedure page is opened");
>>>>>>> 2a100a0fd94d72e8f3a4f35948a220a30992cf2c
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
		BaseClass.wait(2000);
	
		for (int i = 0 ; i<listOfpresentDigitalInputs.size() ; i++)
		{
			listOfpresentDigitalInputs.get(i).click();
			BaseClass.wait(500);
			if(checkStateOfToggleBtn.getAttribute("aria-checked").equalsIgnoreCase("false"))
			{
				BaseClass.wait(500);      
				BaseClass.jsClick(visibleToggleBtn);
				BaseClass.wait(500);
			}
			else
			{
				System.out.println(listOfpresentDigitalInputs.get(i).getText() +" This Digital input is already visible.");
			}
			BaseClass.wait(500);
			SaveBtnOfDigitalInputPage.click();
			BaseClass.wait(3000);
		}
	}	
		
	public void visibleAllDigitalInputs() throws Exception
	{  
		BaseClass.wait(2000);
		for (int i = 0 ; i<listOfpresentDigitalInputs.size() ; i++)
		{
			BaseClass.jsClick(listOfpresentDigitalInputs.get(i));
	    	BaseClass.wait(500);
			if(checkStateOfToggleBtn.getAttribute("aria-checked").equalsIgnoreCase("false"))
			{
				BaseClass.wait(500);      
				BaseClass.jsClick(visibleToggleBtn);
				BaseClass.wait(500);
			}
			else
			{
				System.out.println(listOfpresentDigitalInputs.get(i).getText() +" This Digital input is already visible.");
			}
			BaseClass.wait(500);
			SaveBtnOfDigitalInputPage.click();
			BaseClass.wait(3000);
		}
	}
		
	
	public void handleUnsavedChanges_Save()
	{
		//span[@class='vms-configuration-panel-title']/span[text()='Unsaved changes']
	}
	

}
















