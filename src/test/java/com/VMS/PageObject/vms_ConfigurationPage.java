package com.VMS.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vms_ConfigurationPage {

	WebDriver ldriver;

	public vms_ConfigurationPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// Identify webElements
	@FindBy(xpath = "//div[contains(@class,'NVRs')]") 
	WebElement NVRs;
	
	@FindBy(xpath = "//div[contains(@class,'Recording Failover')]") 
	WebElement RNVRs;
	
	@FindBy(xpath = "//div[contains(@class,'Cameras and Devices')]") 
	WebElement CamerasAndDevices;

	@FindBy(xpath = "//div[contains(@class,'ViconNet Gateway')]") 
	WebElement ViconNetGateway;
	
	@FindBy(xpath = "//div[contains(@class,'Integration Partner')]") 
	WebElement IntegrationPartner;
	
	@FindBy(xpath = "//div[contains(@class,'Analytics Server')]") 
	WebElement AnalyticsServer;	
	
	@FindBy(xpath = "//div[text()='Home Page']") 
	WebElement HomePage;	
	
	@FindBy(xpath = "//div[text()='Alarms']") 
	WebElement AlarmsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Video Channels')]") 
	WebElement VideoChannelsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Audio Channels')]") 
	WebElement AudioChannelsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Digital Input')]") 
	WebElement DigitalInputPage;
	
	@FindBy(xpath = "//div[contains(@class,'Relay Output')]") 
	WebElement RelayOutputPage;
	
	@FindBy(xpath = "//div[contains(@class,'Web Pages')]") 
	WebElement WebPagesPage;
	
	@FindBy(xpath = "//div[contains(@class,'Procedures')]") 
	WebElement ProceduresPage;
	
	@FindBy(xpath = "//div[contains(@class,'Views')]") 
	WebElement ViewsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Tours')]") 
	WebElement ToursPage;
	
	@FindBy(xpath = "//div[contains(@class,'Schedules')]") 
	WebElement SchedulesPage;
	
	@FindBy(xpath = "//div[contains(@class,'Maps')]") 
	WebElement MapsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Numeric ID')]") 
	WebElement NumericISsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Monitors')]") 
	WebElement MonitorsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Doors')]") 
	WebElement DoorsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Rule')]") 
	WebElement RulesPage;
	
	@FindBy(xpath = "//div[contains(@class,'External Events')]") 
	WebElement ExternalEventsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Groups Hierarchy')]") 
	WebElement GroupsHierarchyPage;
	
	@FindBy(xpath = "//div[contains(@class,'Authentication')]") 
	WebElement AuthenticationPage;
	
	@FindBy(xpath = "//div[contains(@class,'Authorization Roles')]") 
	WebElement AuthorizationRolesPage;
	
	@FindBy(xpath = "//div[contains(@class,'Users')]") 
	WebElement UsersPage;
	
	@FindBy(xpath = "//div[contains(@class,'Internet Gateway')]") 
	WebElement InternetGatewayPage;
	
	@FindBy(xpath = "//div[contains(@class,'Licensing')]") 
	WebElement LicensingPage;
	
	@FindBy(xpath = "//div[contains(@class,'App Server Redundancy')]") 
	WebElement AppServerRedundancyPage;
	
	@FindBy(xpath = "//div[contains(@class,'Events Database Settings')]") 
	WebElement EventDatabaseSettingsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Access List')]") 
	WebElement AccessListPage;		
	
	@FindBy(xpath = "//div[contains(@class,'Auto Archive')]") 
	WebElement AutoArchivesPage;
	
	@FindBy(xpath = "//div[contains(@class,'Upgrade')]") 
	WebElement SoftwareUpgradePage;
	
	@FindBy(xpath = "//div[contains(@class,'Backup')]") 
	WebElement BackupPage;
	
	@FindBy(xpath = "//div[contains(@class,'Restore')]") 
	WebElement RestorePage;
	
	@FindBy(xpath = "//div[contains(@class,'Log Collection')]") 
	WebElement LogCollectionPage;
	
	
	public void openNVRsPage()
	{
		try
		{  
			NVRs.click();
		}
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 NVRs.click();
		}
	}
	
	public void openRNVRsPage()
	{
		try  {  RNVRs.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 RNVRs.click();
		}
	}
		
	public void openCamerasAndDevicesPage()
	{
		try  {  CamerasAndDevices.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 CamerasAndDevices.click();
		}
	}
	
	public void openViconNetGatewayPage()
	{
		try  {  ViconNetGateway.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 ViconNetGateway.click();
		}
	}
	
	
	public void openIntegrationPartnerPage()
	{
		try  {  IntegrationPartner.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 IntegrationPartner.click();
		}
	}
	
	public void openAnalyticsServerPage()
	{
		try  {  AnalyticsServer.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 AnalyticsServer.click();
		}
	}

	public void openVideoChannelsPage()
	{
		try  {  VideoChannelsPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 VideoChannelsPage.click();
		}
	}

	public void openAudioChannelsPage()
	{
		try  {  AudioChannelsPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 AudioChannelsPage.click();
		}
	}
	
	public void openDigitalInputPage()
	{
		try  {  DigitalInputPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 DigitalInputPage.click();
		}
	}
	
	public void openRelayOutputPage()
	{
		try  {  RelayOutputPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 RelayOutputPage.click();
		}
	}
	
	public void openWebPagePage()
	{
		try  {  WebPagesPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 WebPagesPage.click();
		}
	}

	public void openProcedurePage()
	{
		try  {  ProceduresPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 ProceduresPage.click();
		}
	}
	
	public void openViewsPage()
	{
		try  {  ViewsPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 ViewsPage.click();
		}
	}
	
	public void openTourPage()
	{
		try  {  ToursPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 ToursPage.click();
		}
	}
	
	
	public void openAlarmsPage()
	{
		try  {  AlarmsPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 AlarmsPage.click();
		}
	}
	
	public void openVAXDoorsPage()
	{
		try  {  DoorsPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 DoorsPage.click();
		}
	}
	
	public void openRulesPage()
	{
		try  {  RulesPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 RulesPage.click();
		}
	}
	
	public void openExternalEventsPage()
	{
		try  {  ExternalEventsPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 ExternalEventsPage.click();
		}
	}

	public void openGroupHierarchyPage()
	{
		try  {  GroupsHierarchyPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 GroupsHierarchyPage.click();
		}
	}

	public void openAuthenticationPage()
	{
		try  {  AuthenticationPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 AuthenticationPage.click();
		}
	}
	
	public void openAuthorizationRolesPage()
	{
		try  {  AuthorizationRolesPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 AuthorizationRolesPage.click();
		}
	}

	public void openUsersPage()
	{
		try  {  UsersPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 UsersPage.click();
		}
	}

	public void openInternetGatewayPage()
	{
		try  {  InternetGatewayPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 InternetGatewayPage.click();
		}
	}
	
	public void openLicensePage()
	{
		try  {  LicensingPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 LicensingPage.click();
		}
	}
	
	public void openAppServerRedundancyPage()
	{
		try  {  AppServerRedundancyPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 AppServerRedundancyPage.click();
		}
	}
	
	public void openEventDatabaseSettingsPage()
	{
		try  {  EventDatabaseSettingsPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 EventDatabaseSettingsPage.click();
		}
	}
	
	public void openAccessListPage()
	{
		try  {  AccessListPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 AccessListPage.click();
		}
	}
	
	public void openAutoArchivePage()
	{
		try  {  AutoArchivesPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 AutoArchivesPage.click();
		}
	}
	
	public void openSoftwareUpgradePage()
	{
		try  {  SoftwareUpgradePage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 SoftwareUpgradePage.click();
		}
	}
	
	public void openBackupPage()
	{
		try  {  BackupPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 BackupPage.click();
		}
	}
	
	public void openRestorePage()
	{
		try  {  RestorePage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 RestorePage.click();
		}
	}
	
	public void openLogCollectionPage()
	{
		try  {  LogCollectionPage.click(); }
		catch (Exception e)
		{
			 e.printStackTrace();
			 HomePage.click();
			 LogCollectionPage.click();
		}
	}
	
	
}
