package com.VMS.TestCases;

import org.testng.annotations.Test;

public class TC_AlarmsJournalPageTest extends BaseClass

{
	  @Test(priority = 1)
	  public void openAlarmTab()
	  {
		  AlarmTab.openAlarmsJournalPage();
	  }


	 @Test(priority = 2)
	  public void verifyDoorLockedAlarm() throws Exception
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch(" Locked");
		  Thread.sleep(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Locked");  
	  }
	
	
	  @Test(priority = 3)
	  public void verifyDoorUnlockedAlarm() throws Exception
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Unlocked");
		  Thread.sleep(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  Thread.sleep(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Unlocked");  
	  }
	
	  @Test(priority = 4)
	  public void verifyAccessGrantedCardAlarm() throws Exception
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Access Granted");
		  Thread.sleep(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  Thread.sleep(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Access Granted - Card");  
	  }
	
	  @Test(priority = 5)
	  public void verifyAccessDeniedCardAlarm() throws Exception
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Invalid Card");
		  Thread.sleep(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  Thread.sleep(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Access Denied - Invalid Card");  
	  }
	  
	 @Test(priority = 6)
	  public void verifyDoorForcedOpenAlarm() throws Exception
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Forced Open");
		  Thread.sleep(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  Thread.sleep(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Forced Open");  
	  }
	  
	 @Test(priority = 7)
	  public void verifyDoorHeldOpenAlarm() throws Exception
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Held");
		  Thread.sleep(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  Thread.sleep(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Held Open");  
	  }
	  
	  @Test(priority = 8)
	  public void verifyDoorOpenAlarm() throws Exception
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Door Open");
		  Thread.sleep(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  Thread.sleep(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Open");  
	  }
	
	  @Test(priority = 9)
	  public void verifyDoorClosedAlarm() throws Exception
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Closed");
		  Thread.sleep(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  Thread.sleep(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Closed");  
	  }	  
	  
	 @Test(priority = 10)
	  public void verifyDoorOverrideAutoResumeAlarm() throws Exception
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Auto");
		  Thread.sleep(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  Thread.sleep(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Override Auto Resume");  
	  }	

	 @Test(priority = 11)
	  public void verifyDoorOverrideEnableAlarm() throws Exception
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Enable");
		  Thread.sleep(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  Thread.sleep(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Override Enabled");  
	  }	
	  
	  @Test(priority = 12)
	  public void verifyDoorOverrideDisableAlarm() throws Exception
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Disabled");
		  Thread.sleep(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  Thread.sleep(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Override Disabled");  
	  }	
}
