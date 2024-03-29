package com.VMS.TestCases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_AlarmsPage;
import com.VMS.Utilities.ReadExcelFile;


public class TC_AlarmsPageTest extends BaseClass {
	
	static List<String> stringList = new ArrayList<String>(); 
    public vms_AlarmsPage alarm ;
 	
   @BeforeClass
	public void OpenAlarmsPage() throws Exception 
	{
	   alarm = new vms_AlarmsPage(driver);
   }
	
	
	//@Test(groups = {"Setup", "SetupVAS"})
	public void addVASalarm() throws Exception
	{
		alarm.addVASAlarm("aaaaaaaa1. Intrusion", "Intrusion");	
		BaseClass.wait(300);
		alarm.addVASAlarm("aaaaaaaa2. Loitering", "Loitering");	
		BaseClass.wait(300);
		alarm.addVASAlarm("aaaaaaaa3. Person Moving", "Person Moving");	
		BaseClass.wait(300);
		alarm.addVASAlarm("aaaaaaaa4. Crowding", "Crowding");	
		BaseClass.wait(300);
		alarm.addVASAlarm("aaaaaaaa5. People Gruoping", "Grouping");	
		BaseClass.wait(300);
		alarm.addVASAlarm("aaaaaaaa6. Person Line Cross", "Person Line Cross");	
		BaseClass.wait(300);
		alarm.addVASAlarm("aaaaaaaa7. Vehicle Stopped", "Vehicle Stopped");	
		BaseClass.wait(300);
		alarm.addVASAlarm("aaaaaaaa8. Vehicle Moving", "Vehicle Moving");	
		BaseClass.wait(300);
		alarm.addVASAlarm("aaaaaaaa9. Vehicle Line cross", "Vehicle Line Cross");	
		BaseClass.wait(300);
		alarm.addVASAlarm("aaaaaaaa10. Asset Protection", "Asset Removed");	
		BaseClass.wait(300);
	}
	
	
	@Test(priority = 1 , groups = {"Setup", "SetupVAX"})
	public void addVAXDigitalInputAlarm() 
	{
		alarm.addVAX_InputsOutputs_Alarm(ReadExcelFile.getCellValue("vaxalarms", 20, 0), "Digital Input","VAX_Input 4");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(alarm.listOfAllpresentAlarms)); 
		 for (WebElement element : alarm.listOfAllpresentAlarms ) 
		   {
              stringList.add(element.getText().toString());
		   }
		if (stringList.contains("VAX Digital Input"))
			{
			   Assert.assertTrue(true);
			   System.out.println("'20. VAX Digital Input' Alarm got added.");
			}
	}
	
	
	@Test(priority = 2, groups = {"Setup", "SetupVAX"})
	public void addVAXRelayOutputAlarm() throws Exception
	{
		alarm.addVAX_InputsOutputs_Alarm(ReadExcelFile.getCellValue("vaxalarms", 21, 0), "Relay","Output 3_VAX Demo"); 
		 for (WebElement element : alarm.listOfAllpresentAlarms ) 
		   {
             stringList.add(element.getText().toString());
		   }
		if (stringList.contains("VAX Relay Output"))
			{
			   Assert.assertTrue(true);
			   System.out.println("'21. VAX Relay Output' Alarm got added.");
			}
	}
	
	
	@Test(priority = 3 ,groups = {"Setup", "SetupVAX"})
	public void addVAXalarmOfDoorFromVAXWebpage() throws Exception
	{
		  alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 1, 0), "Door Locked");
		  alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 2, 0), "Unlock"); 
		  alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 7, 0), "Enabled");
		  alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 8, 0), "Disabled");
		  alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 9, 0), "Auto");
	}


	@Test(priority = 4) 
	public void addVAXalarmOfDoorFromPanel() throws Exception
	{
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 3, 0),"Door Open"); 
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 4, 0), "Door Close");
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 5, 0), "Forced");
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 6, 0), "Held");
	}


	@Test(priority = 5)
	public void addVAXalarmOfAccessCard() throws Exception 
	{
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 10, 0), "Granted - Card");
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 11, 0), "Granted - Pin");
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 12, 0), "Granted - Master");
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 13, 0), "Wrong Time Zone");
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 14, 0), "No Privilege");
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 15, 0), "Invalid Card");
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 16, 0), "Start");
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 17, 0), "End");
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 18, 0), "Invalid Security");
		alarm.addVAXAlarm(ReadExcelFile.getCellValue("vaxalarms", 19, 0), "Unknown Card");   
	}


	@Test(priority = 6)
	public void addVAXalarmOfAccessCardForMessage() throws Exception 
	{           
		alarm.addVAXalarmWithMessageParameter(ReadExcelFile.getCellValue("vaxalarms", 22, 0), "is Now Locked");
		alarm.addVAXalarmWithMessageParameter(ReadExcelFile.getCellValue("vaxalarms", 23, 0), "is Now Unlocked");
		alarm.addVAXalarmWithMessageParameter(ReadExcelFile.getCellValue("vaxalarms", 24, 0), "has been overridden");
		alarm.addVAXalarmWithMessageParameter(ReadExcelFile.getCellValue("vaxalarms", 25, 0), "Now Open");
		alarm.addVAXalarmWithMessageParameter(ReadExcelFile.getCellValue("vaxalarms", 26, 0), "Now Closed");
		alarm.addVAXalarmWithMessageParameter(ReadExcelFile.getCellValue("vaxalarms", 27, 0), "Now Forced Open");
		alarm.addVAXalarmWithMessageParameter(ReadExcelFile.getCellValue("vaxalarms", 28, 0), "Held");
		alarm.addVAXalarmWithMessageParameter(ReadExcelFile.getCellValue("vaxalarms", 29, 0), "granted");
		alarm.addVAXalarmWithMessageParameter(ReadExcelFile.getCellValue("vaxalarms", 30, 0), "due to Invalid Card");
		alarm.addVAXalarmWithMessageParameter(ReadExcelFile.getCellValue("vaxalarms", 31, 0), "due to Start Date");
		alarm.addVAXalarmWithMessageParameter(ReadExcelFile.getCellValue("vaxalarms", 32, 0), "due to Expiry Date");
	}

	
	

	
	
}	