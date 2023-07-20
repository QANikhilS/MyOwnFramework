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
	  public void verifyDoorLockedAlarm() 
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch(" Locked");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Locked");
		  BaseClass.wait(1000);
	  }
	
	
	  @Test(priority = 3)
	  public void verifyDoorUnlockedAlarm() 
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Unlocked");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Unlocked");  
		  BaseClass.wait(1000);
	  }
	
	  @Test(priority = 4)
	  public void verifyAccessGrantedCardAlarm() 
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Access Granted");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Access Granted - Card");
		  BaseClass.wait(1000);
	  }
	  
	  @Test(priority = 5)
	  public void verifyAccessGrantedCardAlarmMasterAccess()
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Master");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Access Granted - Master Privilege");
		  BaseClass.wait(1000);
	  }
	
	  @Test(priority = 6)
	  public void verifyAccessDeniedCardAlarm() 
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Invalid Card");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Access Denied - Invalid Card");
		  BaseClass.wait(1000);
	  }
	  
	  @Test(priority = 7)
	  public void verifyAccessDeniedSecurityLevelAlarm() 
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Security");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Access Denied - Invalid Security Level");
		  BaseClass.wait(1000);
	  }
	  	  
	 @Test(priority = 8)
	  public void verifyDoorForcedOpenAlarm() 
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Forced Open");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Forced Open");
		  BaseClass.wait(1000);
	  }
	  
	 @Test(priority = 9)
	  public void verifyDoorHeldOpenAlarm() 
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Held");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Held Open");
		  BaseClass.wait(1000);
	  }
	  
	  @Test(priority = 10)
	  public void verifyDoorOpenAlarm() 
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Door Open");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Open");
		  BaseClass.wait(1000);
	  }
	
	  @Test(priority = 11)
	  public void verifyDoorClosedAlarm() 
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Closed");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Closed");
		  BaseClass.wait(1000);
	  }	  
	  
	 @Test(priority = 10)
	  public void verifyDoorOverrideAutoResumeAlarm()
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Auto");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Override Auto Resume");
		  BaseClass.wait(1000);
	  }	

	 @Test(priority = 11)
	  public void verifyDoorOverrideEnableAlarm()
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Enable");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Override Enabled");
		  BaseClass.wait(1000);
	  }	
	  
	  @Test(priority = 12)
	  public void verifyDoorOverrideDisableAlarm() 
	  {
		  AlarmTab.EnterAlarmsDetailsToSearch("Disabled");
		  BaseClass.wait(1000);
		  AlarmTab.sortAlarmsInDescendingOrder_BasedOnAlarmID();
		  AlarmTab.selectFirstAlarmFromFilteredAlarmsList();
		  BaseClass.wait(1000);
		  AlarmTab.verifyEventTypeInAdditionalInformation("Door Override Disabled");
		  BaseClass.wait(1000);
	  }	
}
