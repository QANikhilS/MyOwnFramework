package com.VMS.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(css = "button[class='config-action-btn access-config-btn']") 
	public WebElement accesControlConfiguration;
	
	@FindBy(css = "multiselect[id='parameter'] div[class='dropdown']") 
	public WebElement parameterDropDownInConfiguration;
	
	@FindBy(xpath  = "//a[@custom-tooltip='Event']") 
	public WebElement parameterAsEvent;
	
	@FindBy(xpath  = "//a[@custom-tooltip='Message']") 
	public WebElement parameterAsMessage;	
	
	@FindBy(xpath = "//a[@custom-tooltip='Card Holders']") 
	public WebElement parameterAsCardHolders;	
	
	@FindBy(css = "multiselect[id='operator'] div[class='dropdown']") 
	public WebElement operatorDropDownInConfiguration;
	
	@FindBy(css = "a[custom-tooltip='Equals (=)']") 
	public WebElement equalsOperator;
	
	@FindBy(xpath =  "//a[contains(@custom-tooltip,'Not Equal')]") 
	public WebElement notEqualsOperator;
	
	@FindBy(xpath = "//multiselect[@id='vaxdummy']//span[@class='vicon-font v-arrow-down ng-scope']") 
	public WebElement parameterValueDropdowninAccessControlConfiguration;
	
	@FindBy(xpath = "//multiselect[@id='parameter']//ul/li/a")
	public List<WebElement> listOfParameterTypes;
	
	@FindBy(xpath = "//multiselect[@id='operator']//ul/li/a")
	public List<WebElement> listOfOperatorTypes;
	
	@FindBy(xpath = "//multiselect[@id='subEventType']//ul/li/a")
	public List<WebElement> listOfEventTypes;
	
	
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

	
	public void selectParameterInConfigureAccessControl(String parameterNAme) throws Exception
	{
		parameterDropDownInConfiguration.click();
		Thread.sleep(500);
		for (int i = 0; i<listOfParameterTypes.size() ; i++)
		{
			listOfParameterTypes.get(i).getText().equalsIgnoreCase(parameterNAme);
			listOfParameterTypes.get(i).click();
		}
	}
	
	public void selectOperatorInConfigureAccessControl(String operatorNAme) throws Exception
	{
		wait.until(ExpectedConditions.elementToBeClickable(operatorDropDownInConfiguration));
		operatorDropDownInConfiguration.click();
		Thread.sleep(500);
		for (int i = 0; i<listOfOperatorTypes.size() ; i++)
		{
			listOfOperatorTypes.get(i).getText().contains(operatorNAme);
			listOfOperatorTypes.get(i).click();
		}
	}
	
	public void selectSubEventInConfigureAccessControl(String eventValue) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parameterValueDropdowninAccessControlConfiguration));
	   try 
	     {
		   parameterValueDropdowninAccessControlConfiguration.click();
	     }
	   catch (Exception e) 
	     {
		// TODO: handle exception
			JavascriptExecutor executor = (JavascriptExecutor)ldriver;
	        executor.executeScript("arguments[0].click();", parameterValueDropdowninAccessControlConfiguration);
	      }
	   finally  
	      {
		       Actions act = new Actions(ldriver);
		       act.moveToElement(parameterValueDropdowninAccessControlConfiguration).click().build().perform();
	      }
		Thread.sleep(500);
		for (int i = 0; i<listOfEventTypes.size() ; i++)
		{
			listOfEventTypes.get(i).getText().equalsIgnoreCase(eventValue);
			listOfEventTypes.get(i).click();
		}
	}
		
	public void configureAccessControlEvent(String parameterType, String operatorType, String subEventType) throws Exception
	{
		
		accesControlConfiguration.click();
		Thread.sleep(500);
		selectParameterInConfigureAccessControl(parameterType);
		Thread.sleep(500);
/*		selectOperatorInConfigureAccessControl(operatorType);
		Thread.sleep(500);     */
		selectSubEventInConfigureAccessControl(subEventType);	
	}
	

	

	
	public void addVAXAlarm(String AlarmName) throws Exception
	{
		addNewAlarm();
		enterAlarmName(AlarmName);
		selectEventTypeAsIntegrationPartner();
		selectIntegrationPartnerAsAccessControl();
		selectAccessControlPartnerasVAX();
		configureAccessControlEvent("Events", "Equals", "Door Open");
	}
	
}
