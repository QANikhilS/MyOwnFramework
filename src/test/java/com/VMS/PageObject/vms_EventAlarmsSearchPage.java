package com.VMS.PageObject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VMS.TestCases.BaseClass;


public class vms_EventAlarmsSearchPage {
	
	WebDriver ldriver;
	WebDriverWait wait;
			
	public vms_EventAlarmsSearchPage(WebDriver rdriver)
	{
	     ldriver = rdriver;
	     PageFactory.initElements(rdriver, this);
	     wait = new WebDriverWait(rdriver, Duration.ofSeconds(15));
	}
	
	
   @FindBy(xpath = "//span[text()='Event/Alarm Search']")
   public WebElement eventAlarmSearchBtn;
   
   @FindBy(xpath = "//span[text()='Analytics Search']")
   public WebElement analyticsSearchBtn;
   
	
   @FindBy(xpath = "//button[text()='New']")
   public WebElement newQueryBtn;
   
   @FindBy(xpath = "//button[text()='Delete']")
   public WebElement deleteQueryBtn;
   
   @FindBy(xpath = "//div[contains(@class,'left-body')]/input")
   public WebElement queryNameTxtbox;
   
   @FindBy(xpath = "//button[text()='Alarms']")
   public WebElement alarmsToggleBtn;
   
   @FindBy(xpath = "//button[text()='Events']")
   public WebElement eventsToggleBtn;
   
   @FindBy(css = "span[class='checkmark']")
   public WebElement includeOpenAlarmsBtn;
   
   @FindBy(css = "div.ms-options-wrap")
   public WebElement selectAnAlarmTextDropdown;
   
   @FindBy(xpath = "(//b[@role='presentation'])[2]")
   public WebElement selectDaysDropDownForAlarms;

   @FindBy(xpath = "(//option[text()='Last 7 days'])[2]")
   public WebElement selectLast7DaysForAlarms;
   
   @FindBy(css = "input[placeholder='Search']")
   public WebElement searchFromAlarmDropdown;
   
   @FindBy(linkText = "Name")
   public WebElement selectAllFilteredAlarms;
   
   @FindBy(xpath = "//span[text()='Save Query']")
   public WebElement saveQueryBtn;	
   
   @FindBy(xpath = "//span[text()='Save Query']")
   public WebElement searchBtn;   
   
 
   
   
    public void openEventsAlarmSearchPage()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(eventAlarmSearchBtn));
    	try {
			BaseClass.jsClick(eventAlarmSearchBtn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
   
    public void openAnalyticsSearchSearchPage()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(analyticsSearchBtn));
    	try {
			BaseClass.jsClick(analyticsSearchBtn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
   
    public void clickOnNewQueryBtn()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(newQueryBtn));
    	try {
			BaseClass.jsClick(newQueryBtn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 	   
    public void enterAlarmQueryName(String alarmQueryName)
    {
    	queryNameTxtbox.sendKeys(alarmQueryName);
    }
	
    public void selectSearchForEventBtn()
    {
    	eventsToggleBtn.click();
    }
	
    public void selectSearchForAlarmBtn()
    {
    	wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(alarmsToggleBtn));
    	alarmsToggleBtn.click();
    }
	 
    public void enterAlarmNameinSearchAndSelectAlarmFromDropDown(String alarmName)
    {
    	selectAnAlarmTextDropdown.click();
    	searchFromAlarmDropdown.click();
    	searchFromAlarmDropdown.clear();
    	searchFromAlarmDropdown.sendKeys(alarmName);
    	
    	try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	selectAllFilteredAlarms.click();
    	
    }
	
    public void clickOnIncludeOpenAlarmscheckbox()
    {
    	includeOpenAlarmsBtn.click();
    }  
    
	public void selectLast7days()
	{
		selectDaysDropDownForAlarms.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Actions act = new Actions(ldriver);
		act.sendKeys(Keys.DOWN).build().perform();
		act.sendKeys(Keys.DOWN).build().perform();
		act.sendKeys(Keys.DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
	}
	
    public void clickOnSaveQueryBtn()
    {
    	saveQueryBtn.click();
    }  

    public void addNewQuery(String alarmQueryName, String alarmNameToSearch)
    {
		
		clickOnNewQueryBtn();
		BaseClass.log.info("New Query form has been opened");
	
		enterAlarmQueryName(alarmQueryName);
		BaseClass.log.info("Query name has been entered");
		
		selectSearchForAlarmBtn();
		BaseClass.log.info("Search for 'Alarm' toggle button is selected.");
		
		enterAlarmNameinSearchAndSelectAlarmFromDropDown(alarmNameToSearch);
		BaseClass.log.info("Intrusion' alarms is selected.");
	
		clickOnIncludeOpenAlarmscheckbox();
		BaseClass.log.info("Include Open Alarms is selected.");
		
		selectLast7days();
		BaseClass.log.info("Days as last 7 days  is selected.");
		
		clickOnSaveQueryBtn();
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		BaseClass.log.info("clicked on Save Query button.");
     }
    
    
    
}
