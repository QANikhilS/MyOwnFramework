package com.VMS.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class vms_AlarmsPage {

	
	WebDriver ldriver;
	WebDriverWait wait;
	
	public vms_AlarmsPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(15));
	}
	
	// Identify webElements
	@FindBy(xpath = "//button[text()='New']") 
	public WebElement NewBtn;
	
	@FindBy(xpath = "//button[text()='Delete']") 
	public WebElement DeleteBtn;
	
	@FindBy(css = "input[ng-model='selectedAlarm.name']") 
	public WebElement alarmNameTxtBx;
	
	@FindBy(xpath = "//button[text()=' Integration Partner']") 
	public WebElement eventTypeAsIntegrationPartner;
	
	@FindBy(xpath = "//button[text()=' Valerus']") 
	public WebElement eventTypeAsValerus;
	
	@FindBy(xpath =  "(//div[@class='dropdown-submenu-container'])[2]") 
	public WebElement selectIntegrationPartnerDropdown;
	
	@FindBy(xpath =  "//span[text()='Access Control']") 
	public WebElement selectIntegrationPartnerAsAccessControl;
	
	@FindBy(xpath =  "//multiselect[contains(@ng-show,'access')]/div") 
	public WebElement selectAccessControlNameAsDropdown;
	
	@FindBy(xpath =  "//multiselect[contains(@ng-show,'access')]/div/ul/li[3]/a") 
	public WebElement selectAccessControlNameAsVAX;
	
	
	
	
	
	
	
	@FindBy(xpath =  "//div[@ng-show='selectedAlarm.isPartnerAlarm']/dropdown-submenu[contains(@ng-show,'PartnerAlarm')]//i") 
	public WebElement selectIntegrationPartnerDropdownArrow;
	
	
	
	public void addNewAlarm()
	{
		wait.until(ExpectedConditions.elementToBeClickable(NewBtn));
		NewBtn.click();
	}
	
	
	public void enterAlarmName(String alarmName)
	{
		wait.until(ExpectedConditions.elementToBeClickable(alarmNameTxtBx));
		alarmNameTxtBx.click();
		alarmNameTxtBx.clear();
		alarmNameTxtBx.sendKeys(alarmName);
	}
	
	public void selectEventTypeAsIntegrationPartner()
	{
		eventTypeAsIntegrationPartner.click();
	}
	
	public void selectIntegrationPartnerAsAccessControl() throws Exception
	{
		Actions act = new Actions (ldriver);  
		act.moveToElement(selectIntegrationPartnerDropdown).click().build().perform();		
		Thread.sleep(1000);
		act.moveToElement(selectIntegrationPartnerAsAccessControl).click().build().perform();
	}
	
	public void selectAccessControlPartnerasVAX() throws Exception
	{
		selectAccessControlNameAsDropdown.click();
		selectAccessControlNameAsVAX.click();
	}
	
	
	public void addVAXAlarm(String AlarmName) throws Exception
	{
		addNewAlarm();
		enterAlarmName(AlarmName);
		selectEventTypeAsIntegrationPartner();
		selectIntegrationPartnerAsAccessControl();
		selectAccessControlPartnerasVAX();
		
	}
	
}
