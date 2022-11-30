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
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
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
	
	@FindBy(xpath  = "//*[@id='parameter']/div/ul/li[2]") 
	public WebElement parameterAsEvent;
	
	@FindBy(xpath  = "//*[@id='parameter']/div/ul/li[3]") 
	public WebElement parameterAsMessage;	
	
	@FindBy(xpath = "//*[@id='parameter']/div/ul/li[4]") 
	public WebElement parameterAsCardHolders;	
	
	@FindBy(css = "multiselect[id='operator'] div[class='dropdown']") 
	public WebElement operatorDropDownInConfiguration;
	
	@FindBy(css = "a[custom-tooltip='Equals (=)']") 
	public WebElement equalsOperator;
	
	@FindBy(xpath =  "//a[contains(@custom-tooltip,'Not Equal')]") 
	public WebElement notEqualsOperator;
	
	@FindBy(xpath = "//multiselect[@id='subEventType']/div/button") 
	public WebElement parameterValueDropdowninAccessControlConfiguration;
	
	@FindBy(xpath = "//multiselect[@id='parameter']//ul/li/a/i")
	public List<WebElement> listOfParameterTypes;
	
	@FindBy(xpath = "//multiselect[@id='operator']//ul/li/a")
	public List<WebElement> listOfOperatorTypes;
	
	@FindBy(xpath = "//multiselect[@id='subEventType']//ul/li/a")
	public List<WebElement> listOfEventTypes;
	
	@FindBy(xpath = "//multiselect[@id='subEventType']//li[1]/input")
	public WebElement eventTypesSearchBox;
	
	@FindBy(xpath = "//multiselect[@id='subEventType']//li[2]")
	public WebElement filteredEventType;	
	
	@FindBy(xpath = "//div[@class='lpr-footer']/button[2]")
	public WebElement saveButton;	

	@FindBy(xpath = "//div[@class='lpr-footer']/button[1]")
	public WebElement cancelButton;	
	
	@FindBy(xpath = "//div[@class='resources-options']//label[2]/span")
	public WebElement selectAllResourceRadioButton;	

	@FindBy(xpath = "//multiselect[@header='Select related resources']//span[2]")
	public WebElement relatedResourceDropdown;	
	
	@FindBy(xpath = "//multiselect[@header='Select related resources']//input")
	public WebElement relatedResourceDropdownSearchbox;	
		
	@FindBy(xpath = "//multiselect[@header='Select related resources']//li[2]/a/i")
	public WebElement filteredRelatedResource;	

	@FindBy(xpath = "//multiselect[@header='Select Procedure']//span[2]")
	public WebElement procedureDropDown;
	
	@FindBy(xpath = "//multiselect[@header='Select Procedure']//input")
	public WebElement procedureDropDownSearchBox;	
	
	@FindBy(xpath = "//multiselect[@header='Select Procedure']//li[2]")
	public WebElement filteredProcedure;	
	
	@FindBy(xpath = "//multiselect[@header='Select roles']//button")
	public WebElement usersDropdown;	
	
	@FindBy(xpath = "//multiselect[@header='Select roles']/div/ul/li")
	public List<WebElement> listOfUsers;

	@FindBy(xpath = "//button[text()='Never']")
	public WebElement expirationTimeNever;
	
	@FindBy(xpath = "//div[@class='vms-big-btn-footer']//button[@ng-click='submitForm()']")
	public WebElement saveButtonOfAlarmsForm;
	
	
	
	
	
	
	
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

	
	public void selectParameterASEVENTInConfigureAccessControl() throws Exception
	{
		parameterDropDownInConfiguration.click();
		Thread.sleep(500);
		parameterAsEvent.click();
	}
	
	public void selectParameterASMESSAGEInConfigureAccessControl() throws Exception
	{
		parameterDropDownInConfiguration.click();
		Thread.sleep(500);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", parameterAsMessage);
	}
	
	public void selectParameterAsCARDHOLDERInConfigureAccessControl() throws Exception
	{
		parameterDropDownInConfiguration.click();
		Thread.sleep(500);
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();", parameterAsCardHolders);
	}
	
	public void openAccessControlConfigurationWindow() throws Exception
	{
		accesControlConfiguration.click();	
	}
		
	public void selectSubEventInConfigureAccessControl(String eventValue) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parameterValueDropdowninAccessControlConfiguration));
	    parameterValueDropdowninAccessControlConfiguration.click();
	 	Thread.sleep(300);
	 	eventTypesSearchBox.sendKeys(eventValue);
	 	wait.until(ExpectedConditions.elementToBeClickable(filteredEventType));
	 	filteredEventType.click();
	}
	
	public void clickSAVEConfigureAccessControl() throws Exception
	{
         wait.until(ExpectedConditions.elementToBeClickable(saveButton));
         saveButton.click();
	}
		
	public void selectAllResources()
	{
		wait.until(ExpectedConditions.elementToBeClickable(selectAllResourceRadioButton));
		selectAllResourceRadioButton.click();
	}
	
	public void selectRelatedResources(String CameraName, String WebPage, String Map) throws Exception
	{
        wait.until(ExpectedConditions.elementToBeClickable(relatedResourceDropdown));
        Thread.sleep(500);
        relatedResourceDropdown.click();
		Thread.sleep(300);
		relatedResourceDropdownSearchbox.click();
		relatedResourceDropdownSearchbox.sendKeys(CameraName);
		wait.until(ExpectedConditions.elementToBeClickable(filteredRelatedResource));
		Thread.sleep(500);
		try {
			filteredRelatedResource.click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) ldriver;
			executor.executeScript("arguments[0].click();", filteredRelatedResource);
		}
		Thread.sleep(200);
		relatedResourceDropdownSearchbox.click();
		relatedResourceDropdownSearchbox.clear();
		relatedResourceDropdownSearchbox.sendKeys(WebPage);
		wait.until(ExpectedConditions.elementToBeClickable(filteredRelatedResource));
		Thread.sleep(500);
		try {
			filteredRelatedResource.click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) ldriver;
			executor.executeScript("arguments[0].click();", filteredRelatedResource);
		}
		Thread.sleep(200);
		relatedResourceDropdownSearchbox.click();
		relatedResourceDropdownSearchbox.clear();
		relatedResourceDropdownSearchbox.sendKeys(Map);
		wait.until(ExpectedConditions.elementToBeClickable(filteredRelatedResource));
		Thread.sleep(500);
		try {
			filteredRelatedResource.click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) ldriver;
			executor.executeScript("arguments[0].click();", filteredRelatedResource);
		}
		Thread.sleep(200);
		relatedResourceDropdown.click();
	}
	
	public void selectProcedure(String procedureNo) throws Exception
	{
		procedureDropDown.click();
		procedureDropDownSearchBox.click();
		procedureDropDownSearchBox.sendKeys(procedureNo);
		wait.until(ExpectedConditions.elementToBeClickable(filteredProcedure));
		filteredProcedure.click();
		Thread.sleep(300);
		}
	
	public void selectAllUsers() throws Exception
	{
		usersDropdown.click();
		Thread.sleep(300);
		for (int i =0; i < listOfUsers.size(); i++)
		{
			Thread.sleep(200);
			listOfUsers.get(i).click();
		}
		Thread.sleep(200);
	}
	
	public void setAlarmExipryAsNever() throws Exception
	{
		wait.until(ExpectedConditions.elementToBeClickable(expirationTimeNever));
		expirationTimeNever.click();
	}
	
	public void clickOnSaveButtonOfAlarmsPage() throws Exception
	{
		wait.until(ExpectedConditions.elementToBeClickable(saveButtonOfAlarmsForm));
		saveButtonOfAlarmsForm.click();
		  Thread.sleep(1500);
	}
	
	public void addVAXAlarm(String AlarmName) throws Exception
	{
		addNewAlarm();
		enterAlarmName(AlarmName);
		selectEventTypeAsIntegrationPartner();
		selectIntegrationPartnerAsAccessControl();
		selectAccessControlPartnerasVAX();
		openAccessControlConfigurationWindow();
		selectParameterASEVENTInConfigureAccessControl();
		selectSubEventInConfigureAccessControl("Security");
		clickSAVEConfigureAccessControl();
		selectAllResources();
        Thread.sleep(200);
        selectRelatedResources("Camera_.3", "NDTV", "Map");
        Thread.sleep(200);
        selectProcedure("1. Procedure-User must acknowledge");
        Thread.sleep(200);
        selectAllUsers();
        setAlarmExipryAsNever();
        clickOnSaveButtonOfAlarmsPage();
	}
	
}
