package com.VMS.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.VMS.PageObject.vms_Login;
import com.VMS.Utilities.ReadExcelFile;

public class TC_loginPageTest2 extends BaseClass
{
	
	@Test(priority = 1, dataProvider = "LoginDataProvider")
	public void verifyADMINLogin(String username, String password) throws IOException
	{
		
		vms_Login lgpg = new vms_Login(driver);
		lgpg.clickOnUserNamefromTopCorner();
		lgpg.clickOnLogOutBtbn();
	
		
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
			try {
				capctureScreenshot(driver, "DoLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
		}

		lgpg.clickOnUserNamefromTopCorner();
		lgpg.clickOnLogOutBtbn();
		
	}
	
	//@Test(priority = 2)
	public void verifyLogOut()
	{
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
			try {
				capctureScreenshot(driver, "verifyLogOut");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
		}
		
	}
	


}
