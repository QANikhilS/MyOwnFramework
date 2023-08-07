package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_ProcedurePage;


public class TC_ProcedurePageTest extends BaseClass
{
	public vms_ProcedurePage procedure ;
	
    @BeforeClass
	public void OpenProcedurePage() throws Exception 
	{
    	procedure = new vms_ProcedurePage(driver);
	}
    	
    @Test(priority = 0)
    public void verifyProcedurePageisOpened()
    {
    	if (driver.getCurrentUrl().equalsIgnoreCase(readConfigData.getBaseURL()+"/#/configuration/network_entities/procedures"))
    	{    Assert.assertTrue(true, "Procedure is successfuly opened.");       log.info("Procedure is successfuly opened.");  	}
    	else 
    	{   capctureScreenshot(driver, "verifyProcedurePageisOpened");
			log.info(" Something went wrong. Procedure page is not opened");
    		Assert.assertTrue(false, "Procedure is not opened");
    	}
	}	
	
	//@Test(priority = 1, groups = "Setup")
	public void addProcedureToAcknowledge() throws Exception 
	{
		  procedure.clickOnNEWbtn();
		  procedure.enterProcedureName("1. Procedure-User must acknowledge");
		  procedure.selectUserMustAcknowledgeChkBx(); 
		  procedure.clickOnSaveBtn();
		  if (procedure.verifyProcedureIsAdded("1. Procedure-User must acknowledge") == true )
		  {   Assert.assertTrue(true);
			  BaseClass.log.info("Procedure '1. Procedure-User must acknowledge' is added successfully.");
		  }	 
		  else 
		  {  BaseClass.log.info("Procedure '1. Procedure-User must acknowledge' is not added.");   Assert.fail();}
	}

	//@Test(priority = 2, groups = {"Setup", "SetupVAX", "SetupVAS"})
	public void addProcedureUserMustCommentToAcknowledge() throws Exception 
	{
		procedure.clickOnNEWbtn();
		procedure.enterProcedureName("2. Procedure-Enter comment acknowledge");
		procedure.selectUserMustAcknowledgeChkBx();
		procedure.selectCommentToAcknowledgeChkBx();
		procedure.clickOnSaveBtn();
		if (procedure.verifyProcedureIsAdded("2. Procedure-Enter comment acknowledge") == true )
		  {   Assert.assertTrue(true);
			  BaseClass.log.info("Procedure '2. Procedure-Enter comment acknowledge' is added successfully.");
		  }	 
		else 
		  {  BaseClass.log.info("Procedure '2. Procedure-Enter comment acknowledge' is not added.");   Assert.fail();}
	}		

	//@Test(priority = 3,groups = {"Setup", "SetupVAX", "SetupVAS"})
	public void addProcedureToOpenNextActionAfterAck() throws Exception 
	{
		procedure.clickOnNEWbtn();
		procedure.enterProcedureName("3. Procedure-Next Action");
		procedure.selectUserMustAcknowledgeChkBx();
		procedure.selectCommentToAcknowledgeChkBx();
		procedure.selectNextActionAfterAcknowledgeChkBx();
		procedure.selectUserMustAcknowledgeChkBx();
		procedure.clickOnSaveBtn();
		if (procedure.verifyProcedureIsAdded("3. Procedure-Next Action") == true )
		  {   Assert.assertTrue(true);
			  BaseClass.log.info("Procedure '3. Procedure-Next Action' is added successfully.");
		  }	 
		else 
		  {  BaseClass.log.info("Procedure '3. Procedure-Next Action' is not added.");   Assert.fail();}
	}	
	
	//@Test(priority = 4, groups = {"Setup", "SetupVAX", "SetupVAS"})
	public void addProcedureToAttachFileForReference() throws Exception 
	{
		procedure.clickOnNEWbtn();
		procedure.enterProcedureName("4. Procedure-Add reference");
		procedure.selectUserMustAcknowledgeChkBx();
		procedure.selectCommentToAcknowledgeChkBx();
		procedure.selectAddReferenceFileWithBrowserandSelectFileChkBx();
		procedure.uploadFile(System.getProperty("user.dir")+"\\src\\main\\resource\\Headphone.jpg");
		procedure.clickOnSaveBtn();
		if (procedure.verifyProcedureIsAdded("4. Procedure-Add reference") == true )
		  {   Assert.assertTrue(true);
			  BaseClass.log.info("Procedure '4. Procedure-Add reference' is added successfully.");
		  }	 
		else 
		  {  BaseClass.log.info("Procedure '4. Procedure-Add reference' is not added.");   Assert.fail();}
	}	
}
