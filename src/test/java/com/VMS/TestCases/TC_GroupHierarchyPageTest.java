package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_GroupHierarchyPage;

public class TC_GroupHierarchyPageTest extends BaseClass {

    public vms_GroupHierarchyPage GroupH;
 	
   @BeforeClass
	public void OpenGroupHierarchyPage() throws Exception 
	{
	   GroupH = new vms_GroupHierarchyPage(driver);
    }
   
   @Test(priority = 0)
   public void verifyGroupHierarchyPageisOpened()
   {  
   	if (driver.getCurrentUrl().equalsIgnoreCase(readConfigData.getBaseURL()+"/#/configuration/network_entities/web_sites"))
	       {    Assert.assertTrue(true, "Group Hierarchy page is successfuly opened.");   log.info("Group Hierarchy page is successfuly opened.");     	}
	   else 
	       {   capctureScreenshot(driver, "verifyGroupHierarchyPageisOpened");
		       log.info(" Something went wrong. Group Hierarchy page is not opened");
		       Assert.assertTrue(false, "Group Hierarchy page is not opened");
	       }
   }


	//@Test(priority = 0)
	public void OpenAlarmsPage() throws Exception
	{
		GroupH.openGroupHierarchyPage();
    }
	
	
	//@Test(priority = 1)
	public void addGroups() throws Exception
	{
		GroupH.clickOnAddGroupBtn(5);     //  -- Number of Groups user wants to add.
		GroupH.clickOnSaveGroupBtn();
	}
 
    //@Test(priority = 2)
	public void deleteAllExistingGroups() throws Exception
	{
		GroupH.deleteAllGroups();
	}
	
	//@Test(priority = 2)
	public void createSubGroupsInAllGroups() throws Exception
	{
		GroupH.clickOnFirstSubGroup();
	}

}
