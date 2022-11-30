package com.VMS.TestCases;

import org.testng.annotations.Test;

import com.VMS.PageObject.vms_ConfigurationPage;
import com.VMS.PageObject.vms_Home_MonitoringPage;
import com.VMS.PageObject.vms_ProcedurePage;

public class TC_ProcedurePageTest extends BaseClass{

	@Test(priority = 0)
	public void openProcedurePage()
	{
	vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(driver);
	hm.openConfigurationPage();
	log.info("Configuration page is opened");
	vms_ConfigurationPage cp = new vms_ConfigurationPage(driver);
	cp.openProcedurePage();
	log.info("Procedures page is opened");
	
	}
	
	@Test(priority = 1)
	public void addProcedureToAcknowledge() throws Exception 
	{
		vms_ProcedurePage pp = new vms_ProcedurePage(driver);
		pp.clickOnNEWbtn();
		pp.enterProcedureName("1. Procedure-User must acknowledge");
		pp.selectUserMustAcknowledgeChkBx();
		pp.clickOnSaveBtn();
	}

	@Test(priority = 2)
	public void addProcedureUserMustCommentToAcknowledge() throws Exception 
	{
		vms_ProcedurePage pp = new vms_ProcedurePage(driver);
		pp.clickOnNEWbtn();
		pp.enterProcedureName("2. Procedure-Enter comment acknowledge");
		pp.selectUserMustAcknowledgeChkBx();
		pp.selectCommentToAcknowledgeChkBx();
		pp.clickOnSaveBtn();
	}

	@Test(priority = 3)
	public void addProcedureToOpenNextActionAfterAck() throws Exception 
	{
        vms_ProcedurePage pp = new vms_ProcedurePage(driver);
		pp.clickOnNEWbtn();
		pp.enterProcedureName("3. Procedure-Next Action");
		pp.selectUserMustAcknowledgeChkBx();
		pp.selectCommentToAcknowledgeChkBx();
		pp.selectNextActionAfterAcknowledgeChkBx();
		pp.selectUserMustAcknowledgeChkBx();
		pp.clickOnSaveBtn();
	}
	
	@Test(priority = 4)
	public void addProcedureToAttachFileForReference() throws Exception 
	{
        vms_ProcedurePage pp = new vms_ProcedurePage(driver);
		pp.clickOnNEWbtn();
		pp.enterProcedureName("4. Procedure-Add reference");
		pp.selectUserMustAcknowledgeChkBx();
		pp.selectCommentToAcknowledgeChkBx();
		pp.selectAddReferenceFileWithBrowserandSelectFileChkBx();
		pp.uploadFile(System.getProperty("user.dir")+"\\src\\main\\resource\\Headphone.jpg");
		pp.clickOnSaveBtn();
	}
}
