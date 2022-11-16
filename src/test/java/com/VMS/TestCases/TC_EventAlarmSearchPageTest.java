package com.VMS.TestCases;

import org.testng.annotations.Test;

import com.VMS.PageObject.vms_EventAlarmsSearchPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;

public class TC_EventAlarmSearchPageTest extends BaseClass{

	@Test(priority = 1)
	public void addEventAlarmSearch()
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openSearchnPage();
		log.info("Search page has been opened");
				
		vms_EventAlarmsSearchPage ea = new vms_EventAlarmsSearchPage(driver);
		ea.openEventsAlarmSearchPage();
		log.info("Event/Alarm Search page has been opened");
		
		vms_EventAlarmsSearchPage eas = new vms_EventAlarmsSearchPage(driver);
		eas.addNewQuery("1. Intrusion Alarm query", "intrusion");

	}
	
	
	@Test(priority = 2)
	public void addEventAlarmSearch2()
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openSearchnPage();
		log.info("Search page has been opened");
				
		vms_EventAlarmsSearchPage ea = new vms_EventAlarmsSearchPage(driver);
		ea.openEventsAlarmSearchPage();
		log.info("Event/Alarm Search page has been opened");
		
		vms_EventAlarmsSearchPage eas = new vms_EventAlarmsSearchPage(driver);
		eas.addNewQuery("2. Person Moving Alarm query", "person moving");
	}
	
	
	@Test(priority = 3)
	public void addEventAlarmSearch3()
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openSearchnPage();
		log.info("Search page has been opened");
				
		vms_EventAlarmsSearchPage ea = new vms_EventAlarmsSearchPage(driver);
		ea.openEventsAlarmSearchPage();
		log.info("Event/Alarm Search page has been opened");
		
		vms_EventAlarmsSearchPage eas = new vms_EventAlarmsSearchPage(driver);
		eas.addNewQuery("3. Vehicle stoped Alarm query", "vehicle stop");
	}
	
	@Test(priority = 4)
	public void addEventAlarmSearch4()
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openSearchnPage();
		log.info("Search page has been opened");
				
		vms_EventAlarmsSearchPage ea = new vms_EventAlarmsSearchPage(driver);
		ea.openEventsAlarmSearchPage();
		log.info("Event/Alarm Search page has been opened");
		
		vms_EventAlarmsSearchPage eas = new vms_EventAlarmsSearchPage(driver);
		
		eas.addNewQuery("3. Vehicle moving Alarm query", "vehicle moving");
	}
	
	
	
	
	
	
	
	
	
	
}
