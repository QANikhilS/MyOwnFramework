package com.VMS.TestCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_AlarmsPage;
import com.VMS.PageObject.vms_ConfigurationPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;

public class TC_AlarmsPageTest extends BaseClass {
	
	@Test(priority = 1)
	public void addVAXAlarmsDoorLocked() throws Exception
	{
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
		hm.openConfigurationPage();
		log.info("Configuration page is opened");
		vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
		cp.openAlarmsPage();
		
		String AlarmName =  "1. Door Locked";
		String desiredEventName = "Door Locked";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Thread.sleep(200);
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * ap.selectRelatedResources("Camera_.1", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	@Test(priority = 2)
	public void addVAXAlarmsDoorUnlocked() throws Exception
	{
		String AlarmName =  "2. Door Unlocked";
		String desiredEventName = "Unlocked";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(200);		
		/*
		 * ap.selectRelatedResources("Camera_.2", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected."); Thread.sleep(200);
		 */
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	@Test(priority = 3)
	public void addVAXAlarmsDoorOverrideEnable() throws Exception
	{
		String AlarmName =  "3. Door Override Enable";
		String desiredEventName = "Door Override Enable";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(200);
		/*
		 * ap.selectRelatedResources("Camera_.3", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
		
	@Test(priority = 4)
	public void addVAXAlarmsDoorOverrideDisable() throws Exception
	{
		String AlarmName =  "4. Door Override Disable";
		String desiredEventName = "Door Override Disable";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(200);
		/*
		 * ap.selectRelatedResources("Camera_.4", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected."); Thread.sleep(200);
		 */
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	@Test(priority = 5)
	public void addVAXAlarmsDoorOpen() throws Exception
	{
		String AlarmName =  "5. Door Open";
		String desiredEventName = "Door Open";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(200);
		/*
		 * ap.selectRelatedResources("Camera_.5", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected."); Thread.sleep(200);
		 */
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	@Test(priority = 6)
	public void addVAXAlarmsDoorClose() throws Exception
	{
		String AlarmName =  "6. Door Close";
		String desiredEventName = "Door Close";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_.6", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	@Test(priority = 7)
	public void addVAXAlarmsDoorFocedOpen() throws Exception
	{
		String AlarmName =  "7. Door Forced Open";
		String desiredEventName = "Door Forced Open";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_.7", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	@Test(priority = 8)
	public void addVAXAlarmsDoorHeldOpen() throws Exception
	{
		String AlarmName =  "8. Door Held Open";
		String desiredEventName = "Door Held Open";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Thread.sleep(200);
		/*
		 * ap.selectRelatedResources("Camera_.8", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected."); Thread.sleep(200);
		 */
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	@Test(priority = 9)
	public void addVAXAlarmsDoorOverrideAutoResume() throws Exception
	{
		String AlarmName =  "9. Door Override Auto Resume";
		String desiredEventName = "Auto Resume";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_.9", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}

	@Test(priority = 10)
	public void addVAXAlarmsAccessGrantedCard() throws Exception
	{
		String AlarmName =  "10. Access Granted - Card";
		String desiredEventName = "granted - card";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_10", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	@Test(priority = 11)
	public void addVAXAlarmsAccessGrantedMaster() throws Exception
	{
		String AlarmName =  "11. Access Granted - Master Privilege";
		String desiredEventName = "granted - Master";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_10", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	@Test(priority = 12)
	public void addVAXAlarmsAccessDeniedWrongTimeZone() throws Exception
	{
		String AlarmName =  "12. Access Denied - Wrong time zone";
		String desiredEventName = "time zone";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_10", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	@Test(priority = 13)
	public void addVAXAlarmsAccessDeniedInvalidCard() throws Exception
	{
		String AlarmName =  "13. Access Denied - Invalid card";
		String desiredEventName = "Denied - invalid card";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_10", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	@Test(priority = 14)
	public void addVAXAlarmsAccessDeniedInvalidStartDate() throws Exception
	{
		String AlarmName = "14. Access Denied - Invalid Start Date";
		String desiredEventName = "Start Date";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_10", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}

	@Test(priority = 15)
	public void addVAXAlarmsAccessDeniedInvalidEndDate() throws Exception
	{
		String AlarmName = "15. Access Denied - Invalid End Date";
		String desiredEventName = "End Date";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_10", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}

	@Test(priority = 16)
	public void addVAXAlarmsAccessDeniedNoPrivilege() throws Exception
	{
		String AlarmName = "16. Access Denied - No Privilege";
		String desiredEventName = "No Privilege";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_10", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}

	@Test(priority = 17)
	public void addVAXAlarmsAccessDeniedInvalidSecurityLevel() throws Exception
	{
		String AlarmName = "17. Access Denied - Invalid Security Level";
		String desiredEventName = "Security Level";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_10", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}

	@Test(priority = 18)
	public void addVAXAlarmsAccessDeniedUnknownCardFormat() throws Exception
	{
		String AlarmName = "18. Access Denied - Unknown Card Format";
		String desiredEventName = "Unknown Card Format";
		vms_AlarmsPage ap = new vms_AlarmsPage(driver);
		ap.addNewAlarm();
		log.info("New alarm form is opened.");
		ap.enterAlarmName(AlarmName);
		log.info("Alarm name -"+AlarmName+" is entered in Alarms name textbox.");
		ap.selectEventTypeAsIntegrationPartner();
		log.info("Event as 'Intergartion partner' is selected");
		ap.selectIntegrationPartnerAsAccessControl();
		log.info("Integration Partner is selected as 'Access Control'.");
		ap.selectAccessControlPartnerasVAX();
		log.info("Integration Partner name is selected as 'VAX'.");
		ap.openAccessControlConfigurationWindow();
		log.info("VAX Alarm configuration windoe is opened.");
		ap.selectParameterASEVENTInConfigureAccessControl();
		log.info("Selected Parameter as 'EVENT' in the configure access control window.");
		ap.selectSubEventInConfigureAccessControl(desiredEventName);
		log.info("Selected event type as -"+desiredEventName);
		ap.clickSAVEConfigureAccessControl();
		log.info("Access Control event is configured");
		ap.selectAllResources();
		log.info("Selected all available resources.");
		Actions act = new Actions (driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		/*
		 * Thread.sleep(200); ap.selectRelatedResources("Camera_10", "NDTV", "Map1");
		 * log.info("Expected related  resources are selected."); Thread.sleep(200);
		 * ap.selectProcedure("3. Procedure-Next Action");
		 * log.info("Expected procedure is selected.");
		 */
        Thread.sleep(200);
        ap.selectAllUsers();
        log.info("selected all users.");
        ap.setAlarmExipryAsNever();
        log.info("Set Alarm expiration time as NEVER");
        ap.clickOnSaveButtonOfAlarmsPage();		
        log.info("Clicked on SAVE button to create '"+ AlarmName +"' Alarm");
        Thread.sleep(1500);
	}
	
	
}	