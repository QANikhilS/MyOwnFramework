package com.VMS.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vms_VAXWebpagePage
{
    WebDriver ldriver;
    
    public vms_VAXWebpagePage(WebDriver rdriver)
    {
    	ldriver = rdriver;
    	PageFactory.initElements(rdriver, this);
    }
	
    
	@FindBy (xpath = "//input[contains(@data-bind,'userName')]")
	public WebElement vaxUsernametxtbx;
	
	@FindBy (xpath = "//input[contains(@data-bind,'password')]")
	public WebElement vaxPasswordtxtbx;
	
	@FindBy (xpath = "//button[@type='submit']")
	public WebElement vaxLoginBtn;
	
	@FindBy (xpath = "//button[contains(text(),'Advanced')]")
	public WebElement advancedBtn;
	
	@FindBy (xpath = "//a[contains(text(),'Proceed to 192.168.1.')]")
	public WebElement proceedToVAXLogin;
	
	@FindBy (xpath = "//span[contains(@class,'inline-block') and text()='Override']")
	public WebElement overrideBtn;

	@FindBy (xpath = "//label[text()='Default Site']")
	public WebElement selectBothDoors;
	
	@FindBy (xpath = "//label[@for='override_unlock']")
	public WebElement doorUnlock;
	
	@FindBy (xpath = "//label[@for='override_lockdown']")
	public WebElement doorLock;
	
	@FindBy (xpath = "//button[text()='Until Resumed']")
	public WebElement untilResumeBtn;
	
	@FindBy (xpath = "//button[@data-original-title='Resume from an overridden state back to the normal schedule.']")
	public WebElement resumeBtn;
	
	@FindBy (xpath = "//button[@data-bind='click: serverCommunicator.notifications.clear()']")
	public WebElement clearNotificationsBtn;
	
	@FindBy (xpath = "//span[@class='nav-link-text' and text()='Home']")
	public WebElement homeLink;
	
	@FindBy (xpath = "//span[@data-bind='text: Text' and text()='Panels']")
	public WebElement panelsLink;
	
	@FindBy (xpath = "//tbody[@data-view='views/panels/list']/tr[1]/td[1]/button/span")
	public WebElement vaxDemoPanel;
	
	@FindBy (xpath = "//div[@class='nav-bar-item']//span[text()='I/O']")
	public WebElement vaxDemoInputOutput;
	
	@FindBy (xpath = "//div[@class='list-group io-list']//span[@class='title' and text()='Input 4']")
	public WebElement vaxInput4;
	
	
	
	
	
	public void selectVAXinput4()
	{
		vaxInput4.click();
	}
	
	public void openVAXinputOutput()
	{
		vaxDemoInputOutput.click();
	}
	
	public void openVAXDemopanel()
	{
		vaxDemoPanel.click();
	}
	
	public void openVAXhomepage()
	{
		homeLink.click();
	}
	
	public void openPanelsList()
	{
		panelsLink.click();
	}
	
	public void clickOnClearNotificationsBtn()
	{
		clearNotificationsBtn.click();
	}
	
	public void triggerDoorLocked()
	{
		doorLock.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		untilResumeBtn.click();
	}
	
	public void triggerDoorUnlocked()
	{
		doorUnlock.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		untilResumeBtn.click();
	}
	
	public void clickOnUntilResumedBtn()
	{
		untilResumeBtn.click();
	}
	
	public void clickOnResumeBtn()
	{
		//JavascriptExecutor js = ((JavascriptExecutor) ldriver);
		//js.executeScript("arguments[0].click();", resumeBtn);
		resumeBtn.click();
	}
	
	public void clickOnUntilResumeBtn()
	{
		untilResumeBtn.click();
	}
		
	public void selectBothDoors()
	{
		selectBothDoors.click();
	}
	
	public void openOverrideOptions()
	{
		overrideBtn.click();
	}
	
	public void clickOnAdvancedBtn()
	{
		advancedBtn.click();
	}
	
	public void clickOnProceedToOpenVAXpageLink()
	{
		proceedToVAXLogin.click();
	}
	
	public void enterVAXusrname(String VAXuname)
	{
		vaxUsernametxtbx.sendKeys(VAXuname);
	}
	
	public void enterVAXpassword(String VAXpwd)
	{
		vaxPasswordtxtbx.sendKeys(VAXpwd);
	}
    
	public void clickOnVAXLoginbtn()
	{
	    vaxLoginBtn.click();
	}
	
	
}
