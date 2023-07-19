package com.VMS.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VMS.TestCases.BaseClass;


public class vms_EventAlarmsSearchPage {
	
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;  
			
	public vms_EventAlarmsSearchPage(WebDriver rdriver)
	{
	     ldriver = rdriver;
	     PageFactory.initElements(rdriver, this);
	     js = ((JavascriptExecutor) ldriver); 
	     wait = new WebDriverWait(rdriver, Duration.ofSeconds(30));
	}
	
	
   @FindBy(xpath = "//span[text()='Event/Alarm Search']")
   public WebElement eventAlarmSearchBtn;
	
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
   
   @FindBy(xpath = "//div//span[text()='Select an alarm(s)']")
   public WebElement selectAnAlarmDropdown;
   
   @FindBy(xpath = "//div[contains(@class,'event-search-container')]//span[text()='Select days']")
   public WebElement selectDaysDropDownForEvents;
   
   @FindBy(xpath = "//div[@class='event-search-container']//select[contains(@class,'timeFrameDate')]")
   public WebElement selectDaysDropDownForEventsDropdownValues;
      
   @FindBy(xpath = "//div[contains(@class,'alarm-search-container')]//span[text()='Select days']")
   public WebElement selectDaysDropDownForAlarms;

   @FindBy(xpath = "//div[@class='event-search-container']//option[@label='Last 7 days']")
   public WebElement selectLast7DaysForEvents;
   
   @FindBy(xpath = "//div[@class='alarm-search-container']//option[@label='Last 7 days']")
   public WebElement selectLast7DaysForAlarms;
   
   @FindBy(css = "input[placeholder='Search']")
   public WebElement searchFromAlarmDropdown;
   
   @FindBy(linkText = "Name")
   public WebElement selectAllFilteredAlarms;
   
   @FindBy(xpath = "//span[text()='Save Query']")
   public WebElement saveQueryBtn;	
   
   @FindBy(xpath = "//span[text()='Search']")
   public WebElement searchBtn;   
   
   @FindBy(xpath = "//tree-dropdown/div/p")
   public WebElement selectAnEventDropdown;   
   
   @FindBy(xpath = "//div[@class='panel-group']/div[4]/div/h4/div/span/span")
   public WebElement VAXEventFromEventsList;  
   
   @FindAll (@FindBy(xpath = "//div[@class='list']//uib-accordion/div/div/div[1]/h4/div/span"))
   public List<WebElement> eventsListOnEventAlarmSearch;   
   
   @FindAll (@FindBy(xpath = "//div[@class='ms-options']//descendant::li/label"))
   public List<WebElement> alarmsListOnEventAlarmSearch;    

   @FindBy(xpath = "//span[text()='Select resource(s)']")
   public WebElement selectResourcesDropdown;   
   
   @FindBy(xpath = "(//button[@type='button']/preceding::a[text()='Name'])[1]")
   public WebElement selectAllResourcesCheckbox;   
      
   @FindAll (@FindBy(xpath = "//ul[@class='select2-results']/child::li"))
   public List<WebElement> listofDaystoSelecttimeframeForEventQuert;  
   
   @FindBy(xpath = "(//button[contains(@ng-click,'loadAdvancedFilter')])[2]")
   public WebElement advancedFiltersButton;   
    
   @FindBy(xpath = "//multiselect[@id='parameter']/div/button")
   public WebElement parameterDropdown;   
   
   @FindAll (@FindBy(xpath = "//multiselect[@id='parameter']//li[@class='ng-scope']"))
   public List<WebElement> listofParameters;      
   
   @FindBy(xpath = "//multiselect[@id='subEventType']/div/button") 
   public WebElement parameterValueDropdowninAccessControlConfiguration;
   
   @FindAll (@FindBy(xpath = "//multiselect[@id='subEventType']//li[@class='ng-scope']/a"))
   public List<WebElement> listOfVAXevents;
   
   @FindBy(xpath = "//div[@class='lpr-footer']/button[2]")
   public WebElement saveButton;	  
   
    
    	
    	
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
    	
    	
 public void navigateToEventsAlarmsSearchPage() throws Exception
    {
      vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
      hm.openSearchPage();
      openEventsAlarmSearchPage();
   	  Thread.sleep(5000);
    }    	
  
 
    public void clickOnAdvancedFilterConfigureAlarmPage()
    {
    	advancedFiltersButton.click();
    }

        
    public void selectParameterInConfigureAccessControl(String paramerterName) throws Exception
    {	
    	parameterDropdown.click();
    	for (int i = 0 ; i<listofParameters.size() ; i++)
    	{
    		String crntParameter = listofParameters.get(i).getText();
    		if(crntParameter.equalsIgnoreCase(paramerterName))
    		{
    			listofParameters.get(i).click();
    		}
    	}
    }
        
    public void selectSubEventInConfigureAccessControl(String eventValue) throws Exception
    {
    	new WebDriverWait(ldriver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(parameterValueDropdowninAccessControlConfiguration));
        parameterValueDropdowninAccessControlConfiguration.click();
     	Thread.sleep(300);
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
           	 	{   js.executeScript("arguments[0].click();", listOfVAXevents.get(i));   
           		}
           	}
           }
           saveButton.click();
     }       
        
    public void createVAXeventSearchQuery(String qname, String evntName, String vaxParameterName, String selectSubEvent ) throws Exception
      {
       	clickOnNewQueryBtn();
       	enterQueryName(qname);
       	selectEventtype(evntName);
       	selectAllResources();
       	clickOnAdvancedFilterConfigureAlarmPage();
       	selectParameterInConfigureAccessControl(vaxParameterName);
       	selectSubEventInConfigureAccessControl(selectSubEvent);
       	selectdaysForEventQuery("30");
       	saveQueryBtn.click();
       	new WebDriverWait(ldriver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(newQueryBtn)).isEnabled();
       	Thread.sleep(2000);
      }
           
    public void enterQueryName(String QueryName)
    {
     	queryNameTxtbox.sendKeys(QueryName); 
    }
  
    public void selectEventtype(String eventName) throws Exception
   {
	   selectAnEventDropdown.click();
	   Thread.sleep(1500);
	   wait.until(ExpectedConditions.visibilityOfAllElements(eventsListOnEventAlarmSearch));
	   for(int i=0 ; i<eventsListOnEventAlarmSearch.size(); i++)
	   {
		   if (eventsListOnEventAlarmSearch.get(i).equals(eventName))
		   {
			   eventsListOnEventAlarmSearch.get(i).click();
		   }
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
 	
    public void selectSearchForEventBtn()
    {
    	eventsToggleBtn.click();
    }
	
    public void selectSearchForAlarmBtn()
    {
    	wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(alarmsToggleBtn));
    	alarmsToggleBtn.click();
    }
    
    public void selectAlarmfromDropdown(String alarmName)
    {
    	selectAnAlarmDropdown.click();
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    	for (int i = 1 ; i< alarmsListOnEventAlarmSearch.size() ; i++ )
    	{
    		String CurrentAlarm = alarmsListOnEventAlarmSearch.get(i).getText();
    		if(CurrentAlarm.contains(alarmName))
    		{
    			alarmsListOnEventAlarmSearch.get(i).click();
    		}
    	}
    }
	
    public void clickOnIncludeOpenAlarmscheckbox()
    {
    	includeOpenAlarmsBtn.click();
    }  
   
    public void selectAllResources()
    {
    	selectResourcesDropdown.click();
    	new WebDriverWait(ldriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(selectAllResourcesCheckbox)).click();
    }
    
	public void selectdaysForAlarmQuery(String days)
	{
		selectDaysDropDownForAlarms.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       for(int i=0; i<listofDaystoSelecttimeframeForEventQuert.size() ; i++)
       {
    	  String timeframe = listofDaystoSelecttimeframeForEventQuert.get(i).getText();
    	  if(timeframe.contains(days))
    	  {
    		  listofDaystoSelecttimeframeForEventQuert.get(i).click();
    	  }
       }
	}
    
	public void selectdaysForEventQuery(String days)
	{
		selectDaysDropDownForEvents.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	       for(int i=0; i<listofDaystoSelecttimeframeForEventQuert.size() ; i++)
	       {
	    	  String timeframe = listofDaystoSelecttimeframeForEventQuert.get(i).getText();
	    	  if(timeframe.contains(days))
	    	  {
	    		  listofDaystoSelecttimeframeForEventQuert.get(i).click();
	    	  }
	       }
	}

    public void clickOnSaveQueryBtn() throws Exception
    {
    	BaseClass.jsClick(saveQueryBtn);
    }  

    public void addNewAlarmQuery(String alarmQueryName, String alarmNameToselect) throws Exception
    {
		clickOnNewQueryBtn();
		BaseClass.log.info("New Query form has been opened");
	
		enterQueryName(alarmQueryName);
		BaseClass.log.info("Query name has been entered");
		
		selectSearchForAlarmBtn();
		BaseClass.log.info("Search for 'Alarm' toggle button is selected.");
		
		selectAlarmfromDropdown(alarmNameToselect);
		BaseClass.log.info("Intrusion' alarms is selected.");
	
		clickOnIncludeOpenAlarmscheckbox();
		BaseClass.log.info("Include Open Alarms is selected.");
		
		selectdaysForAlarmQuery("7");
		BaseClass.log.info("Days as last 7 days  is selected.");
		
		clickOnSaveQueryBtn();
		BaseClass.log.info("clicked on Save Query button.");
		Thread.sleep(2000);
		
		ldriver.get(BaseClass.VMSURL+"/#/search/analytics_services");
		Thread.sleep(1500);
		ldriver.navigate().back();
		Thread.sleep(2000);
     }
 
    public void addNewEventQuery(String eventQueryName, String EventName) throws Exception
    {
		
		clickOnNewQueryBtn();
		BaseClass.log.info("New Query form has been opened");
	
		enterQueryName(eventQueryName);
		BaseClass.log.info("Query name has been entered");
		
		selectEventtype(EventName);
		BaseClass.log.info("Event type is has been selected");

        selectResourcesDropdown.click();
        Thread.sleep(500);
        selectAllResourcesCheckbox.click();
        Thread.sleep(500);
		
        selectdaysForEventQuery("30");
		BaseClass.log.info("Days as last 30 days  is selected.");
		
		clickOnSaveQueryBtn();
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		BaseClass.log.info("clicked on Save Query button.");
    }
    
    
    
    
    
    
    
    
    
}
