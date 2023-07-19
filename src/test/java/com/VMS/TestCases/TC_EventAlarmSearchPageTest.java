package com.VMS.TestCases;

import org.testng.annotations.Test;

public class TC_EventAlarmSearchPageTest extends BaseClass
{

	@Test(priority = -1)
	public void openEventAlarmSearchPage() throws Exception
	{
		EventQuerySearch.navigateToEventsAlarmsSearchPage();
		Thread.sleep(2000);
	}
	
	
	
	//@Test(priority = 5 , groups = {"Setup", "SetupVAS"})
	public void addAllVASeventQuery() throws Exception
	{
		EventQuerySearch.addNewEventQuery("1. Intrusion Event", "Analytics Services - Intrusion");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("2. Loitering Event", "Analytics Services - Loitering");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("3. People Grouping Event", "Analytics Services - People Grouping");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("4. Person Line Cross Event", "Analytics Services - Person Line Cross");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("5. Person Moving Event", "Analytics Services - Person Moving");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("6. Crowding Event", "Analytics Services - Crowding");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("7. Person Tailgating Event", "Analytics Services - Person Tailgating");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("8. Suspicious Object Event", "Analytics Services - Suspicious Object");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("9. Tamper Image Too Bright Event", "Analytics Services - Tamper Image Too Bright");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("10. TamperScene Changed Event", "Analytics Services - TamperScene Changed");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("12. Traffic Congestion Event", "Analytics Services - Traffic Congestion");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("13. Traffic Congestion End", "Analytics Services - Traffic Congestion End");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("14. Traffic Signal Detection Event", "Analytics Services - Traffic Signal Detection");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("15. Vehicle Line Cross Event", "Analytics Services - Vehicle Line Cross");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("16. Vehicle Moving Event", "Analytics Services - Vehicle Moving");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("17. Vehicle Speed Analysis Event", "Analytics Services - Vehicle Speed Analysis");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("18. Vehicle Stopped Event", "Analytics Services - Vehicle Stopped");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("19. Vehicle Tailgating Event", "Analytics Services - Vehicle Tailgating");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("20. Asset Removed Event", "Analytics Services - Asset Removed");
		Thread.sleep(500);
		EventQuerySearch.addNewEventQuery("20. Object Lighting Event", "Analytics Services - Object Lighting");
		Thread.sleep(500);	
	}
	
	//@Test(priority = 1)
	public void addAllVASalarmQuery() throws Exception
	{
		EventQuerySearch.addNewAlarmQuery("1. Intrusion Alarm", "Intrusion");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("2. Loitering Alarm", "Loitering");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("3. People Grouping Alarm", "People Grouping");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("4. Person Line Cross Alarm", "Person Line Cross");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("5. Person Moving Alarm", "Person Moving");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("6. Crowding Alarm", "Crowding");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("7. Person Tailgating Alarm", "Person Tailgating");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("8. Suspicious Object Alarm", "Suspicious Object");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("9. Tamper Image Too Bright Alarm", "Tamper Image Too Bright");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("10. TamperScene Changed Alarm", "TamperScene Changed");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("12. Traffic Congestion Alarm", "Traffic Congestion");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("13. Traffic Congestion End Alarm", "Traffic Congestion End");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("14. Traffic Signal Detection Alarm", "Traffic Signal Detection");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("15. Vehicle Line Cross Alarm", "Vehicle Line Cross");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("16. Vehicle Moving Alarm", "Vehicle Moving");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("17. Vehicle Speed Analysis Alarm", "Vehicle Speed Analysis");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("18. Vehicle Stopped Alarm", "Vehicle Stopped");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("19. Vehicle Tailgating Alarm", "Vehicle Tailgating");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("20. Asset Removed Alarm", "Asset Removed");
		Thread.sleep(500);
		EventQuerySearch.addNewAlarmQuery("20. Object Lighting Alarm", "Object Lighting");
		Thread.sleep(500);	
	}	
	
	
  
	public void addVAXeventQuert() throws Exception
	{
		EventQuerySearch.createVAXeventSearchQuery("1. Door Unlock event query", "VAX Event", "Event", "Door Unlock");
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("2. Door Locked event query", "VAX Event", "Event", "Door Lock"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("3. Door Open event query", "VAX Event", "Event", "Door Open"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("4. Door Close event query", "VAX Event", "Event", "Door Close"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("5. Door override enable query", "VAX Event", "Event", "Override Enable"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("6. Door override Disabled query", "VAX Event","Event", "Override Disable"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("7. Door override AutoResume event query","VAX Event", "Event", "Auto"); 
		Thread.sleep(1000);     
		EventQuerySearch.createVAXeventSearchQuery("8. Door Open event query","VAX Event", "Event", "Door Open"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("9. Door Close event query","VAX Event", "Event", "Door Close"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("10. Door Forced Open event query","VAX Event", "Event", "Forced"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("11. Door Held Open event query","VAX Event", "Event", "Held"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("12. Access Granted -card event query","VAX Event", "Event", "Granted - Card"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("13. Access Denied -card event query","VAX Event", "Event", "Denied - Card"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("14. Access Denied - Start Date event query","VAX Event", "Event", "Start"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("15. Access Denied - End Date event query","VAX Event", "Event", "End"); 
		Thread.sleep(1000);
		EventQuerySearch.createVAXeventSearchQuery("15. Access Denied - Security level event query","VAX Event", "Event", "Security"); 
		Thread.sleep(1000);
	}
	
    
	@Test(priority = 21)
	public void addVAXAlarmQuery() throws Exception
	{
		EventQuerySearch.addNewAlarmQuery("1.Alarm Search-Door Open", "Door Open");
		Thread.sleep(1000);
		EventQuerySearch.addNewAlarmQuery("2.Alarm Search-Door Close", "Door Close");
		Thread.sleep(1000);	
		EventQuerySearch.addNewAlarmQuery("3.Alarm Search-Door Locked", "Door Locked");
		Thread.sleep(1000);	
		EventQuerySearch.addNewAlarmQuery("4.Alarm Search-Door Unlocked", "Door Unlocked");
		Thread.sleep(1000);	
		EventQuerySearch.addNewAlarmQuery("5.Alarm Search-Door Forced open", "Forced");
		Thread.sleep(1000);	
		EventQuerySearch.addNewAlarmQuery("6.Alarm Search-Door Held Open", "Held");
		Thread.sleep(1000);	
		EventQuerySearch.addNewAlarmQuery("7.Alarm Search-Access Granted-Card", "Access Granted - Card");
		Thread.sleep(1000);	
		EventQuerySearch.addNewAlarmQuery("8.Alarm Search-Access Denied-Card", "Access Denied - Invalid Card");
		Thread.sleep(1000);  
		EventQuerySearch.addNewAlarmQuery("9.Alarm Search-Auto Resume", "Auto");
		Thread.sleep(1000);	
	}
	
}
