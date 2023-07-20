package com.VMS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_Login;

public class TC_loginPageTest extends BaseClass
{
	
	@Test(priority = 1)
	public void verifyADMINLogin()
	{
	  log.info("************  Test Case - verifyADMINLogin is started ************");	
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "http://localhost/#/monitoring";
		
		if (currentURL.equals(expectedURL))
		{
			log.info("DoLogin  -  Passed. ");
			Assert.assertTrue(true);
			log.info("User has logged in to VMS successfully.");
		}
		else
		{
			log.info("DoLogin  -  Failed.");
			capctureScreenshot(driver, "DoLogin");
			Assert.assertTrue(false);
		}
		  log.info("************  Test Case - verifyADMINLogin is finish ************");		
	}
	
	@Test(priority = 2)
	public void verifyLogOut()
	{
		log.info("************  Test Case - verifyLogOut is started ************");	
		vms_Login lg = new vms_Login(driver);
		lg.clickOnUserNamefromTopCorner();
		log.info("Clicked on ADMIN button from the Right top corner.");
		lg.clickOnLogOutBtbn();
		log.info("Clicked on Log out button.");
		if (lg.loginTextbox.isDisplayed())
		{
			log.info("verifyLogOut  -  Passed. ");
			Assert.assertTrue(true);
			log.info("User has logged Out from VMS successfully.");
		}
		else
		{
			log.info("verifyLogOut  -  Failed.");
			capctureScreenshot(driver, "verifyLogOut");
			Assert.assertTrue(false);
		}
		log.info("************  Test Case - verifyLogOut is finished ************");	
		
	}

}
