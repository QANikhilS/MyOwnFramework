package com.VMS.TestCases;

import org.testng.annotations.Test;

import com.VMS.PageObject.vms_AlarmsPage;
import com.VMS.PageObject.vms_ConfigurationPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;

public class TC_AlarmsPageTest extends BaseClass {
	
	@Test
	public void addVAXAlarms() throws Exception
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openConfigurationPage();
		log.info("Configuration page is opened");
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openAlarmsPage();
		
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addVAXAlarm("1. Door Open");
	}
	

}
