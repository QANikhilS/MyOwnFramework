package com.VMS.TestCases;

import org.testng.annotations.Test;

public class TC_VAXResourcesTest extends BaseClass{

	
	@Test(priority = 0)
	public void OpenProcedurePage() throws Exception 
	{
		  procedure.openProdecurepage();
	}
		
	
	@Test(priority = 1, groups = "Setup")
	public void addProcedureToAcknowledge() throws Exception 
	{
		  procedure.clickOnNEWbtn();
		  procedure.enterProcedureName("1. Procedure-User must acknowledge");
		  procedure.selectUserMustAcknowledgeChkBx(); 
		  procedure.clickOnSaveBtn();
		  log.info("Procedure '1. Procedure-User must acknowledge' is added.");
	}

	@Test(priority = 2, groups = {"Setup", "SetupVAX", "SetupVAS"})
	public void addProcedureUserMustCommentToAcknowledge() throws Exception 
	{
		procedure.clickOnNEWbtn();
		procedure.enterProcedureName("2. Procedure-Enter comment acknowledge");
		procedure.selectUserMustAcknowledgeChkBx();
		procedure.selectCommentToAcknowledgeChkBx();
		procedure.clickOnSaveBtn();
		log.info("Procedure '2. Procedure-Enter comment acknowledge' is added.");
	}

	@Test(priority = 3,groups = {"Setup", "SetupVAX", "SetupVAS"})
	public void addProcedureToOpenNextActionAfterAck() throws Exception 
	{
		procedure.clickOnNEWbtn();
		procedure.enterProcedureName("3. Procedure-Next Action");
		procedure.selectUserMustAcknowledgeChkBx();
		procedure.selectCommentToAcknowledgeChkBx();
		procedure.selectNextActionAfterAcknowledgeChkBx();
		procedure.selectUserMustAcknowledgeChkBx();
		procedure.clickOnSaveBtn();
	}
	
	@Test(priority = 4, groups = {"Setup", "SetupVAX", "SetupVAS"})
	public void addProcedureToAttachFileForReference() throws Exception 
	{
		procedure.clickOnNEWbtn();
		procedure.enterProcedureName("4. Procedure-Add reference");
		procedure.selectUserMustAcknowledgeChkBx();
		procedure.selectCommentToAcknowledgeChkBx();
		procedure.selectAddReferenceFileWithBrowserandSelectFileChkBx();
		procedure.uploadFile(System.getProperty("user.dir")+"\\src\\main\\resource\\Headphone.jpg");
		procedure.clickOnSaveBtn();
	}
}
