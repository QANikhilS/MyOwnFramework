package com.VMS.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VMS.TestCases.BaseClass;

public class vms_AlarmsPage extends BaseClass
{
	WebDriver ldriver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public vms_AlarmsPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// Identify webElements
	@FindAll(@FindBy(xpath = "//div[@class='ui-grid-canvas']//div[@ng-class='view-row']")) 
	public List<WebElement> listOfAllpresentAlarms;
	
	@FindBy(xpath = "//button[normalize-space()='New']") 
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
	
	@FindBy(xpath  = "//*[@id='parameter']/div/ul/li[3]/a") 
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
	
	@FindBy(xpath = "//input[@ng-show='item.isText']")
	public WebElement messageTextBox;	
	
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

	@FindBy(xpath = "//multiselect[@id='rel-resources']//li[@class='ng-scope']")
	public List<WebElement> listOfRelatedResources;
	
	@FindBy(xpath = "//multiselect[@id='rel-resources']//li[@class='ng-scope']/a/i")
	public List<WebElement> listOfRelatedResourcescheckboxes;
	
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
	
	@FindBy(xpath = "//div[@class='vms-big-btn-footer']/button[2]")
	public WebElement saveButtonOfAlarmsForm;
	
	@FindBy(xpath = "//div[contains(@ng-show,'selectedAlarm.isPartnerAlarm')]//span[text()=' Select']/preceding-sibling::span")
	public WebElement selectEventsRadioButton;
	
	@FindBy(xpath = "//div[contains(@ng-show,'!selectedAlarm.isPartnerAlarm')]//dropdown-submenu[contains(@class,'evenlist-dropdown')]")
	public WebElement eventsDropdown;
	
	@FindBy(xpath = "//span[text()='Analytics Services']")
	public WebElement analyticsServiceEvent;
	
	@FindAll (@FindBy(xpath = "//nav[@id='primary_nav_wrap']//li[@ng-repeat='event in event.events']"))
	public List<WebElement> listOfsubEvents;
	
	@FindAll (@FindBy(xpath = "//nav[@id='primary_nav_wrap']//li[@ng-repeat='event in events']"))
	public List<WebElement> listOfValerusEvents;	
	
	@FindAll (@FindBy(xpath = "//multiselect[@id='subEventType']//li[@class='ng-scope']/a"))
	public List<WebElement> listOfVAXevents;
	
//	@FindAll (@FindBy(xpath = "//multiselect[@id='subEventType']//li[@class='ng-scope']/a"))
//	public List<WebElement> listOfVAXconfigurationParameter;
	
	@FindBy(xpath = "//div[@class='evnt-option-grp']//label[1]")
	public WebElement radioBtnToSelectSingleEvents;
	
	@FindBy(xpath = "(//div[contains(@class,'selected-event')])[1]")
	public WebElement dropdownToSelectEvent;
	
	@FindBy(xpath = "//multiselect[@header='Select Resources']//span[contains(@class,'v-arrow')]")
	public WebElement dropdownToSelectResources;
	
	@FindBy(xpath = "//multiselect[@header='Select Resources']//input")
	public WebElement selectResourcesTxtBx;
	
	@FindAll(@FindBy(xpath = "//nav[@id='primary_nav_wrap']//li[@ng-repeat='event in events']/a/span"))
	public List<WebElement> listOfAllValerusEvents;
	
	@FindAll(@FindBy(xpath = "//multiselect[@header='Select Resources']//li[@class='ng-scope']"))
	public List<WebElement> listOfAvailableResources;
	
	

	
	
	
	public void openAlarmsPage()      
	{
		  vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		  vms_ConfigurationPage cp = hm.openConfigurationPage(); 
		  cp.openAlarmsPage();
		  BaseClass.wait(500);
	}
	
	public void selectResources_Vax_InputORoutput_All(String InputORoutput)
	{
		dropdownToSelectResources.click();
		BaseClass.wait(300);
		selectResourcesTxtBx.sendKeys(InputORoutput);
		BaseClass.wait(200);
		for (int i = 0; i<listOfAvailableResources.size() ; i++)
		{   listOfAvailableResources.get(i).click();
			BaseClass.wait(300);    	}	
		dropdownToSelectResources.click();
	}
	
	public void selectSingleEventRadioBtn()
	{
		radioBtnToSelectSingleEvents.click();
	}
	
	public void openDropdownToSelectEvent()
	{
		dropdownToSelectEvent.click();
	}
	
	public void selectValerusEvent(String ExpectedEventName)
	{
		for (int i=0; i<listOfAllValerusEvents.size(); i++)
		{
			String CuttrntEvent = listOfAllValerusEvents.get(i).getText();
			if(CuttrntEvent.equalsIgnoreCase(ExpectedEventName))
			  {   listOfAllValerusEvents.get(i).click();
				  BaseClass.wait(400);     }
		}
	}
	
	public void selectEventRadioButton()
	{
		new WebDriverWait(ldriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(selectEventsRadioButton)).click();
		BaseClass.wait(800);
	}
	
	public void selectVASEvent(String eventName) 
	{
		js.executeScript("window.scrollBy(0,300)");
		Actions act = new Actions (ldriver);
		act.moveToElement(eventsDropdown).build().perform();
		BaseClass.wait(1500);
		act.moveToElement(analyticsServiceEvent).build().perform();
		BaseClass.wait(1500);
		for (int i = 0 ; i< listOfsubEvents.size() ; i++)
		{
			String expectedEvent = listOfsubEvents.get(i).getText();
			if (expectedEvent.contains(eventName))
			{
				act.moveToElement(listOfsubEvents.get(i)).build().perform();
				act.click().build().perform();
			}
		}
	}
	
	public void clickOnAddNewAlarmBtn()
	{
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(NewBtn));
		NewBtn.click();
	}
	
	public void enterAlarmName(String alarmName)
	{
	    new WebDriverWait(ldriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(alarmNameTxtBx)).click();
	    alarmNameTxtBx.clear();
	    alarmNameTxtBx.sendKeys(alarmName);
	}
	
	public void selectEventTypeAsIntegrationPartner()
	{
		eventTypeAsIntegrationPartner.click();
	}
	
	public void selectIntegrationPartnerAsAccessControl() 
	{
		Actions act = new Actions (ldriver);  
		act.moveToElement(selectIntegrationPartnerDropdown).click().build().perform();		
		BaseClass.wait(1000);
		act.moveToElement(selectIntegrationPartnerAsAccessControl).click().build().perform();
	}

	public void selectAccessControlPartnerasVAX() 
	{
		selectAccessControlNameAsDropdown.click();
		selectAccessControlNameAsVAX.click();
	}

	public void openAccessControlConfigurationWindow() 
	{
		accesControlConfiguration.click();	
	}
	
	public void selectParameterASEVENTInConfigureAccessControl() 
	{
		parameterDropDownInConfiguration.click();
		BaseClass.wait(500);
		parameterAsEvent.click();
	}
	
	public void selectParameterASMESSAGEInConfigureAccessControl()
	{
		new WebDriverWait(ldriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(parameterDropDownInConfiguration));
		parameterDropDownInConfiguration.click();
		new WebDriverWait(ldriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(parameterAsMessage));
	    BaseClass.jsClick(parameterAsMessage);
	}
	
	public void selectParameterAsCARDHOLDERInConfigureAccessControl() 
	{
		parameterDropDownInConfiguration.click();
		BaseClass.wait(500);
		BaseClass.jsClick(parameterAsCardHolders);
	}
			
	public void selectSubEventInConfigureAccessControl(String eventValue) 
	{
		new WebDriverWait(ldriver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(parameterValueDropdowninAccessControlConfiguration));
	    parameterValueDropdowninAccessControlConfiguration.click();
	 	BaseClass.wait(500);
        for (int i = 0 ; i<listOfVAXevents.size() ; i++)
        {
        	String currentEvent = listOfVAXevents.get(i).getText();
        	if(currentEvent.contains(eventValue))
        	{
        		try
    	 	{
        			listOfVAXevents.get(i).click();
        	 	}
        	 	catch(Exception e)
        	 	{   BaseClass.jsClick(listOfVAXevents.get(i));   
        		}
        	}
        }
	 }
	
	public void EnterMessage(String Message)
	{
		new WebDriverWait(ldriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(messageTextBox));
		messageTextBox.clear();
		messageTextBox.sendKeys(Message);
	}
	
	public void clickSAVEConfigureAccessControl() 
	{
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
         wait.until(ExpectedConditions.elementToBeClickable(saveButton));
         saveButton.click();
	}
		
	public void selectAllResources()
	{
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(selectAllResourceRadioButton));
		selectAllResourceRadioButton.click();
	}
	
	public void selectRelatedResources(String CameraName, String WebPage, String Map) 
	{
	    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(relatedResourceDropdown)).click();
        BaseClass.wait(500);
		relatedResourceDropdownSearchbox.click();
		BaseClass.wait(300);
		relatedResourceDropdownSearchbox.sendKeys(CameraName);
		BaseClass.wait(1500);
	    js.executeScript("arguments[0].click();", filteredRelatedResource);
		BaseClass.wait(1000);
		relatedResourceDropdownSearchbox.click();
		BaseClass.wait(500);
		relatedResourceDropdownSearchbox.clear();
		BaseClass.wait(500);
		relatedResourceDropdownSearchbox.sendKeys(WebPage);
		BaseClass.wait(1500);
		js.executeScript("arguments[0].click();", filteredRelatedResource);
		BaseClass.wait(1000);
		relatedResourceDropdownSearchbox.click();
		BaseClass.wait(500);
		relatedResourceDropdownSearchbox.clear();
		BaseClass.wait(500);
		relatedResourceDropdownSearchbox.sendKeys(Map);
		BaseClass.wait(1500);
		js.executeScript("arguments[0].click();", filteredRelatedResource);  
		BaseClass.wait(500);
		relatedResourceDropdown.click();  
		BaseClass.wait(500);
	}
	
	public void selectProcedure(String procedureNo)
	{
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		procedureDropDown.click();
		procedureDropDownSearchBox.click();
		procedureDropDownSearchBox.sendKeys(procedureNo);
		wait.until(ExpectedConditions.elementToBeClickable(filteredProcedure));
		filteredProcedure.click();
		BaseClass.wait(300);
		}
	
	public void selectAllUsers() 
	{
		usersDropdown.click();
		BaseClass.wait(300);
		for (int i =0; i < listOfUsers.size(); i++)
		{
			BaseClass.wait(200);
			listOfUsers.get(i).click();
		}
		BaseClass.wait(200);
	}
	
	public void setAlarmExipryAsNever() 
	{
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(expirationTimeNever));
		expirationTimeNever.click();
	}
	
	public void clickOnSaveButtonOfAlarmsPage() 
	{
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(saveButtonOfAlarmsForm));
		saveButtonOfAlarmsForm.click();
		wait.until(ExpectedConditions.elementToBeClickable(NewBtn));
	}
	
	public void addVAXAlarm(String AlarmName, String VAXEventType)
	{
		clickOnAddNewAlarmBtn();
		log.debug("Clicked on Add New Alarm button");
		BaseClass.wait(500);
		enterAlarmName(AlarmName);
		log.debug("Alarm name is entered");
		BaseClass.wait(500);
		selectEventTypeAsIntegrationPartner();
		log.debug("Selected Event type as Integration Partner");
		BaseClass.wait(500);
		selectIntegrationPartnerAsAccessControl();
		log.debug("Selected Partner type as Access Control.");
		BaseClass.wait(500);
		selectAccessControlPartnerasVAX();
		log.debug("Selected Partner as VAX.");
		BaseClass.wait(500);
		openAccessControlConfigurationWindow();
		log.debug("VAX Event configuration window is opened.");
		BaseClass.wait(500);
		selectParameterASEVENTInConfigureAccessControl();
		log.debug("Selected Partner type as Access Control.");
		BaseClass.wait(500);
		selectSubEventInConfigureAccessControl(VAXEventType);
		log.debug("Selected event type as "+VAXEventType);
		BaseClass.wait(500);
		clickSAVEConfigureAccessControl();
		log.debug("VAX event configuration is saved.");
		BaseClass.wait(500);
		selectAllResources();
		log.debug("Select all resources/Doors.");
		Actions act = new Actions(ldriver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		BaseClass.wait(200);
        selectRelatedResources("Camera_.3", "NDTV", "Map");
        log.debug("Selected expected related  resources.");
		BaseClass.wait(500);
        selectProcedure("1. Procedure-User must acknowledge");
        log.debug("selected procedure.");
        BaseClass.wait(200);
        selectAllUsers();
        log.debug("selected all users.");
        BaseClass.wait(500);
        setAlarmExipryAsNever();
        log.debug("selected alarms expiry as NEVER.");
        BaseClass.wait(500);
        clickOnSaveButtonOfAlarmsPage();
        log.debug("Click on SAVE button to create new alarm.");
        BaseClass.wait(5000);
	}

	public void addVASAlarm(String AlarmeName, String vasEventName) 
	{
		clickOnAddNewAlarmBtn();
		log.debug("Clicked on Add New Alarm button");
		BaseClass.wait(500);
		enterAlarmName(AlarmeName);
		log.debug("Alarm name is entered");
		BaseClass.wait(500);
		selectEventRadioButton();
		log.debug("Select Event radio button is selected.");
		BaseClass.wait(200);
		selectVASEvent(vasEventName);
		log.debug("selected "+ vasEventName +" events to trigger.");
		BaseClass.wait(500);
		selectAllResources();
		log.debug("selected all resources.");
        BaseClass.wait(200);
		Actions act = new Actions(ldriver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		BaseClass.wait(200);
        selectRelatedResources("Camera_.3", "NDTV", "Map");
        BaseClass.wait(200);
        log.debug("selected expected related resources.");
        selectProcedure("1. Procedure-User must acknowledge");
        log.debug("selected procedure.");
        BaseClass.wait(200);
        selectAllUsers();
        log.debug("selected all users.");
        BaseClass.wait(500);
        setAlarmExipryAsNever();
        log.debug("selected alarms expiry as NEVER.");
        BaseClass.wait(500);
        clickOnSaveButtonOfAlarmsPage();
        log.debug("Click on SAVE button to create new alarm.");
        BaseClass.wait(5000);
	}
	
	public void addVAX_InputsOutputs_Alarm(String AlarmeName, String EventName, String selectVAXinputOROutput)
	{
		clickOnAddNewAlarmBtn();
		log.debug("Clicked on Add New Alarm button");
		BaseClass.wait(500);
		enterAlarmName(AlarmeName);
		log.debug("Alarm name is entered");
	    selectSingleEventRadioBtn();
	    log.debug("Single Event radio button is selected.");
	    openDropdownToSelectEvent();
	    selectValerusEvent(EventName);
	    log.debug("Selected "+EventName+" Event.");
        BaseClass.wait(200);
	    selectResources_Vax_InputORoutput_All(selectVAXinputOROutput);
        BaseClass.wait(200);
		log.debug("selected all resources.");
        BaseClass.wait(200);
        selectRelatedResources("Camera_.3", "NDTV", "Map");
        BaseClass.wait(200);
        log.debug("selected expected related resources.");
        Actions act = new Actions(ldriver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		BaseClass.wait(200);
        selectProcedure("2. Procedure-Enter comment acknowledge");
        log.debug("selected procedure.");
        BaseClass.wait(200);
        selectAllUsers();
        log.debug("selected all users.");
        BaseClass.wait(500);
        setAlarmExipryAsNever(); 
        log.debug("selected alarms expiry as NEVER.");
        BaseClass.wait(500);
        clickOnSaveButtonOfAlarmsPage();
        log.debug("Click on SAVE button to create new alarm.");
        BaseClass.wait(5000);
	}
	
	public void addVAXalarmWithMessageParameter(String AlarmeName, String msg) 
	{
		clickOnAddNewAlarmBtn();
		log.debug("Clicked on Add New Alarm button");
		BaseClass.wait(500);
		enterAlarmName(AlarmeName);
		log.debug("Alarm name is entered");
		BaseClass.wait(500);
		selectEventTypeAsIntegrationPartner();
		log.debug("Selected Event type as Integration Partner");
		BaseClass.wait(500);
		selectIntegrationPartnerAsAccessControl();
		log.debug("Selected Partner type as Access Control.");
		BaseClass.wait(500);
		selectAccessControlPartnerasVAX();
		log.debug("Selected Partner as VAX.");
		BaseClass.wait(500);
		openAccessControlConfigurationWindow();
		log.debug("VAX Event configuration window is opened.");
		BaseClass.wait(500);
		selectParameterASMESSAGEInConfigureAccessControl();
		log.debug("Selected Partner type as Access Control.");
		BaseClass.wait(500);
        EnterMessage(msg);
		BaseClass.wait(500);
		clickSAVEConfigureAccessControl();
		log.debug("VAX event configuration is saved.");
		BaseClass.wait(500);
		selectAllResources();
		log.debug("Select all resources/Doors.");
		Actions act = new Actions(ldriver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		BaseClass.wait(200);
        selectRelatedResources("Camera_.3", "NDTV", "Map");
        log.debug("Selected expected related  resources.");
		BaseClass.wait(500);
        selectProcedure("4. Procedure-Add reference");
        log.debug("selected procedure.");
        BaseClass.wait(200);
        selectAllUsers();
        log.debug("selected all users.");
        BaseClass.wait(500);
        setAlarmExipryAsNever();
        log.debug("selected alarms expiry as NEVER.");
        BaseClass.wait(500);
        clickOnSaveButtonOfAlarmsPage();
        log.debug("Click on SAVE button to create new alarm.");
        BaseClass.wait(5000);
	}
	}
