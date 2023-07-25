package com.VMS.PageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VMS.TestCases.BaseClass;

public class vms_Home_MonitoringPage {
	
	 static WebDriver ldriver;

	public vms_Home_MonitoringPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Identify webElements
	@FindBy(xpath = "//span[contains(@class,'vms-header-navigation-button vms-nav-button-state-configuration')]") 
	public  WebElement ConfigurationTab;
	
	@FindBy(xpath = "//a[text()='Search']") 
	public  WebElement SearchTab;
	
	@FindBy(css = "span[class*='Alarm']") 
	public  WebElement AlarmsTab;
	
	@FindBy(css = "span[class*='vax']") 
	public  WebElement VaxTab;
	
	
	
	public  vms_ConfigurationPage openConfigurationPage()
	{
		  try
		   {
			  ConfigurationTab.click();
			 //  Click on Configuration button.
		   } 
		catch (Exception e) 
		   {
			BaseClass.jsClick(ConfigurationTab);
		   }
		return new vms_ConfigurationPage(ldriver);
     }
	
	public  void openSearchPage()
	{
		  try
		   {
			  SearchTab.click();
			 //  Click on Configuration button.
		   } 
		catch (Exception e) 
		   {
			BaseClass.jsClick(SearchTab);
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
			BaseClass.jsClick(AlarmsTab);
		   }
	  System.out.println("Alarm Page opened"); 
     }
	
	
	public  void openVAXPageWindow()
	{
		  try
		   {
			  VaxTab.click();
			 //  Click on Configuration button.
		   } 
		catch (Exception e) 
		   {
			BaseClass.jsClick(VaxTab);
		   }
	  System.out.println("VAX webpage is opened in new window."); 
     }
	
	public void openMonitoringPage()
	{
		 ldriver.navigate().to("http://localhost/#/monitoring");
    }
	
	
	
	
	
	
}
