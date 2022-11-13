package com.VMS.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vms_Home_MonitoringPage {
	
	WebDriver ldriver;

	public vms_Home_MonitoringPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// Identify webElements
	@FindBy(linkText = "Configuration") 
	WebElement ConfigurationTab;
	
	@FindBy(name = "Search") 
	WebElement SearchTab;
	
	@FindBy(id = "Alarms") 
	WebElement AlarmsTab;
	

	public void openConfigurationPage()
	{
		  try
		   {
			  ConfigurationTab.click();
			 //  Click on Configuration button.
		   } 
		catch (Exception e) 
		   {
			JavascriptExecutor executor = (JavascriptExecutor) ldriver;
			executor.executeScript("arguments[0].click();", ConfigurationTab);
		   }
     }
	
	
	public void openSearchnPage()
	{
		  try
		   {
			  SearchTab.click();
			 //  Click on Configuration button.
		   } 
		catch (Exception e) 
		   {
			JavascriptExecutor executor = (JavascriptExecutor) ldriver;
			executor.executeScript("arguments[0].click();", SearchTab);
		   }
	  System.out.println("Search Page Opened");
     }
	
	
	public void openAlarmPage()
	{
		  try
		   {
			  AlarmsTab.click();
			 //  Click on Configuration button.
		   } 
		catch (Exception e) 
		   {
			JavascriptExecutor executor = (JavascriptExecutor) ldriver;
			executor.executeScript("arguments[0].click();", AlarmsTab);
		   }
	  System.out.println("Alarm Page opened");
     }
	
	
	public void openMonitoringPage()
	{
		 ldriver.navigate().to("http://localhost/#/monitoring");
    }
	
	
	
	
	
	
}
