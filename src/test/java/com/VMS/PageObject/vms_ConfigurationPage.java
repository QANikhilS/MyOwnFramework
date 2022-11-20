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
	public WebElement NVRs;
	
	@FindBy(xpath = "//div[contains(@class,'Recording Failover')]") 
	public WebElement RNVRs;
	
	@FindBy(xpath = "//div[contains(@class,'Cameras and Devices')]") 
	public WebElement CamerasAndDevices;

	@FindBy(xpath = "//div[contains(@class,'ViconNet Gateway')]") 
	public WebElement ViconNetGateway;
	
	@FindBy(xpath = "//div[contains(@class,'Integration Partner')]") 
	public WebElement IntegrationPartner;
	
	@FindBy(xpath = "//div[contains(@class,'Analytics Server')]") 
	public WebElement AnalyticsServer;	
	
	@FindBy(xpath = "//div[text()='Home Page']") 
	public WebElement HomePage;	
	
	@FindBy(xpath = "//div[text()='Alarms']") 
	public WebElement AlarmsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Video Channels')]") 
	public WebElement VideoChannelsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Audio Channels')]") 
	public WebElement AudioChannelsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Digital Input')]") 
	public WebElement DigitalInputPage;
	
	@FindBy(xpath = "//div[contains(@class,'Relay Output')]") 
	public WebElement RelayOutputPage;
	
	@FindBy(xpath = "//div[contains(@class,'Web Pages')]") 
	public WebElement WebPagesPage;
	
	@FindBy(xpath = "//div[contains(@class,'Procedures')]") 
	public WebElement ProceduresPage;
	
	@FindBy(xpath = "//div[contains(@class,'Views')]") 
	public WebElement ViewsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Tours')]") 
	public WebElement ToursPage;
	
	@FindBy(xpath = "//div[contains(@class,'Schedules')]") 
	public WebElement SchedulesPage;
	
	@FindBy(xpath = "//div[contains(@class,'Maps')]") 
	public WebElement MapsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Numeric ID')]") 
	public WebElement NumericISsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Monitors')]") 
	public WebElement MonitorsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Doors')]") 
	public WebElement DoorsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Rule')]") 
	public WebElement RulesPage;
	
	@FindBy(xpath = "//div[contains(@class,'External Events')]") 
	public WebElement ExternalEventsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Groups Hierarchy')]") 
	public WebElement GroupsHierarchyPage;
	
	@FindBy(xpath = "//div[contains(@class,'Authentication')]") 
	public WebElement AuthenticationPage;
	
	@FindBy(xpath = "//div[contains(@class,'Authorization Roles')]") 
	public WebElement AuthorizationRolesPage;
	
	@FindBy(xpath = "//div[contains(@class,'Users')]") 
	public WebElement UsersPage;
	
	@FindBy(xpath = "//div[contains(@class,'Internet Gateway')]") 
	public WebElement InternetGatewayPage;
	
	@FindBy(xpath = "//div[contains(@class,'Licensing')]") 
	public WebElement LicensingPage;
	
	@FindBy(xpath = "//div[contains(@class,'App Server Redundancy')]") 
	public WebElement AppServerRedundancyPage;
	
	@FindBy(xpath = "//div[contains(@class,'Events Database Settings')]") 
	public WebElement EventDatabaseSettingsPage;
	
	@FindBy(xpath = "//div[contains(@class,'Access List')]") 
	public WebElement AccessListPage;		
	
	@FindBy(xpath = "//div[contains(@class,'Auto Archive')]") 
	public WebElement AutoArchivesPage;
	
	@FindBy(xpath = "//div[contains(@class,'Upgrade')]") 
	public WebElement SoftwareUpgradePage;
	
	@FindBy(xpath = "//div[contains(@class,'Backup')]") 
	public WebElement BackupPage;
	
	@FindBy(xpath = "//div[contains(@class,'Restore')]") 
	public WebElement RestorePage;
	
	@FindBy(xpath = "//div[contains(@class,'Log Collection')]") 
	public WebElement LogCollectionPage;
	
	
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
