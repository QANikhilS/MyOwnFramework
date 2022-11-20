package com.VMS.TestCases;

import org.testng.annotations.Test;

import com.VMS.PageObject.vms_EventAlarmsSearchPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;

public class TC_EventAlarmSearchPageTest extends BaseClass{

	@Test(priority = 1)
	public void addEventAlarmSearch() throws Exception
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openSearchnPage();
		log.info("Search page has been opened");
				
		vms_EventAlarmsSearchPage ea = new vms_EventAlarmsSearchPage(driver);
		ea.openEventsAlarmSearchPage();
		log.info("Event/Alarm Search page has been opened");
		
		vms_EventAlarmsSearchPage eas = new vms_EventAlarmsSearchPage(driver);
		eas.addNewQuery("1. Intrusion Alarm query", "intrusion");
		
		driver.navigate().to("http://localhost/#/search/analytics_services");
		Thread.sleep(2000);
		driver.navigate().back();
	}
	
	
	@Test(priority = 2)
	public void addEventAlarmSearch2() throws Exception
	{
/*		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openSearchnPage();
		log.info("Search page has been opened");
				
		vms_EventAlarmsSearchPage ea = new vms_EventAlarmsSearchPage(driver);
		ea.openEventsAlarmSearchPage();
		log.info("Event/Alarm Search page has been opened");    */
		
		vms_EventAlarmsSearchPage eas = new vms_EventAlarmsSearchPage(driver);
		eas.addNewQuery("2. Person Moving Alarm query", "person moving");
				
		driver.navigate().to("http://localhost/#/search/analytics_services");
		Thread.sleep(2000);
		driver.navigate().back();
		
	}
	
	
	@Test(priority = 3)
	public void addEventAlarmSearch3() throws Exception
	{
/*		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openSearchnPage();
		log.info("Search page has been opened");
				
		vms_EventAlarmsSearchPage ea = new vms_EventAlarmsSearchPage(driver);
		ea.openEventsAlarmSearchPage();
		log.info("Event/Alarm Search page has been opened");   */
		
		vms_EventAlarmsSearchPage eas = new vms_EventAlarmsSearchPage(driver);
		eas.addNewQuery("3. Vehicle stoped Alarm query", "vehicle stop");
		
		driver.navigate().to("http://localhost/#/search/analytics_services");
		Thread.sleep(2000);
		driver.navigate().back();
	}
	
	@Test(priority = 4)
	public void addEventAlarmSearch4() throws Exception
	{
	/*	vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openSearchnPage();
		log.info("Search page has been opened");
				
		vms_EventAlarmsSearchPage ea = new vms_EventAlarmsSearchPage(driver);
		ea.openEventsAlarmSearchPage();
		log.info("Event/Alarm Search page has been opened");    */
		
		vms_EventAlarmsSearchPage eas = new vms_EventAlarmsSearchPage(driver);
		
		eas.addNewQuery("3. Vehicle moving Alarm query", "vehicle moving");
		
		driver.navigate().to("http://localhost/#/search/analytics_services");
		Thread.sleep(2000);
		driver.navigate().back();
	
	}
	
	
	
	
	
	
	
	
	
	
}
