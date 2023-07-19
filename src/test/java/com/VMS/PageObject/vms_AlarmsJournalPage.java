package com.VMS.PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.VMS.TestCases.BaseClass;

public class vms_AlarmsJournalPage {
	
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;  
			
	public vms_AlarmsJournalPage(WebDriver rdriver)
	{
	     ldriver = rdriver;
	     PageFactory.initElements(rdriver, this);
	     js = ((JavascriptExecutor) ldriver); 
	     wait = new WebDriverWait(rdriver, Duration.ofSeconds(30));
	}
	
	
   @FindBy(xpath = "//span[@class='vms-header-navigation-button vms-nav-button-state-Alarm']/a")
   public WebElement AlarmsTab;	

   @FindBy(xpath = "//span[text()='Alarm ID']")
   public WebElement Column1_AlarmID;	
	
   @FindBy(xpath = "//div[@class='tbl-header']//tr/th[2]//span[2]")
   public WebElement AlarmID_OrderStatus;	 // get attribute "aria-hidden", if it's value true then Alarm ID are in Ascending order else in Descending order. 

   @FindBy(xpath = "//input[@ng-change='alarmsByFilterText()']")
   public WebElement SearchAlarmTextBox;


   @FindBy(xpath = "//div[@id='alarm_main_table_body']//tr[1]/td[2]/div/span")
   public WebElement FirstAlarmFromTriggeredAlarmsList;
   
   @FindBy(xpath = "//div[@ng-if='alarm.additionalInfo']/div[14]//div")
   public WebElement EventTypeInAdditionalInformation;
 
   @FindBy(xpath = "//div[@ng-if='alarm.additionalInfo']/div[16]//div")
   public WebElement EventMessageInAdditionalInformation;
 

   
   
   
   
   
   
   
   
   public void openAlarmsJournalPage()
   {
	   	wait.until(ExpectedConditions.elementToBeClickable(AlarmsTab));
	   	try {
				BaseClass.jsClick(AlarmsTab);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Actions act = new Actions(ldriver);
				act.moveToElement(AlarmsTab).click().build().perform();
			}
	   	BaseClass.log.info("Alarms Journal page is opened.");
   }
   
   public void EnterAlarmsDetailsToSearch(String alarmDetails)
   {
	   wait.until(ExpectedConditions.elementToBeClickable(SearchAlarmTextBox)).click();
	   SearchAlarmTextBox.clear();
	   SearchAlarmTextBox.sendKeys(alarmDetails);
	   BaseClass.log.info("Alarm details are entered in search textbox of Alarms page.");
	   Actions act = new Actions (ldriver);
	   act.sendKeys(Keys.ENTER).build().perform();
    }
   
   public void selectFirstAlarmFromFilteredAlarmsList() throws Exception
   {
	   wait.until(ExpectedConditions.elementToBeClickable(FirstAlarmFromTriggeredAlarmsList));
	   Thread.sleep(1000);
	   BaseClass.jsClick(FirstAlarmFromTriggeredAlarmsList);
	   BaseClass.log.info("Most recent triggered alarm is selected.");
   } 
   
   public void sortAlarmsInDescendingOrder_BasedOnAlarmID()
   {
	   wait.until(ExpectedConditions.elementToBeClickable(Column1_AlarmID)).click();
	   String currentOrderStatus = AlarmID_OrderStatus.getAttribute("aria-hidden");
	   if (currentOrderStatus.equalsIgnoreCase("true"))
	   {   Column1_AlarmID.click();   }
	   else
	   {   Column1_AlarmID.click(); Column1_AlarmID.click();    }
	   BaseClass.log.info("All triggered alarms are sorted in the Descending order.");
   }
   
   public void verifyEventTypeInAdditionalInformation(String ExpectedEventType)
   {
	   String EventType = EventTypeInAdditionalInformation.getText();
	   try 
	   {if (EventType.equalsIgnoreCase(ExpectedEventType))
	   {
		   System.out.println("**********************************************************");
		   System.out.println(ExpectedEventType+" Alarm is triggered.");
		   System.out.println("**********************************************************");
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   System.out.println(ExpectedEventType+" Alarm is NOT triggered.");
		   Assert.assertTrue(false);
	   }
	   }
	   catch (Exception e) {
		// TODO: handle exception
		   System.out.println("**********************************************************");
		   System.out.println(ExpectedEventType+"\u001B[31mRed Alarm is NOT triggered.");
		   System.out.println("**********************************************************");
		   Assert.assertTrue(false);
	}
		   
   }
   
   
   
   
   
}
