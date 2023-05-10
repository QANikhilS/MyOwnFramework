package com.VMS.TestCases;

import org.testng.annotations.Test;

public class TC_GroupHierarchyPageTest extends BaseClass {
	


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
