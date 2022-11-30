package com.VMS.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class vms_ProcedurePage {

	WebDriver ldriver;
	WebDriverWait wait ;
	
	public vms_ProcedurePage(WebDriver rdriver)
	{
	     ldriver = rdriver;
	     PageFactory.initElements(rdriver, this);
	     wait = new WebDriverWait(ldriver, Duration.ofSeconds(15));
	
	}
	
	@FindBy(xpath = "//button[text()='New']")
	public WebElement newProcedureBtn;
	
	@FindBy(css = "input[ng-model*='Procedure.Name']")
	public WebElement procedureNameTxtbx;
	
	@FindBy(css = "div[class='md-bar']")
	public WebElement procedureEnableDisableToggleBtn;
	
	@FindBy(xpath = "//div[contains(@id,'-act-col')]//li[1]//span[2]")
	public WebElement userMustAcknowledgeChkbx;

	@FindBy(xpath = "//div[contains(@id,'-act-col')]//li[2]//span[2]")
	public WebElement userMustProvideACommentToAcknowledgeChkbx;

	@FindBy(xpath = "//div[contains(@id,'-act-col')]//li[3]//span[2]")
	public WebElement nxtActionOnlyAfterAcknowledgeChkbx;

	@FindBy(xpath = "//div[contains(@id,'-act-col')]//li[4]//span[2]")
	public WebElement addReferenceFileWithBroser;

	@FindBy(xpath = "//div[@class='vms-big-btn-footer']/button[2]")
	public WebElement saveProcedureButton;
	
	@FindBy(xpath = "//div[@class='vms-big-btn-footer']/button[1]")
	public WebElement CancelProcedureButton;
	
	@FindBy(xpath = "//div[@class='attach-file-div']/div/label/input")
	public WebElement attachFileLink;
		
	@FindBy(xpath = "//button[contains(@ng-click,'createNewActionGroup')]/span")
	public WebElement addAction;
				
	
	
	public void clickOnNEWbtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(newProcedureBtn));
		newProcedureBtn.click();	
	}
	
	public void enterProcedureName(String ProcName)
	{
		wait.until(ExpectedConditions.elementToBeClickable(procedureNameTxtbx));
		procedureNameTxtbx.click();
		procedureNameTxtbx.clear();
		procedureNameTxtbx.sendKeys(ProcName);	
	}
	
	public void clickOnSaveBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(saveProcedureButton));
		saveProcedureButton.click();	
	}
	
	public void selectUserMustAcknowledgeChkBx()
	{
		wait.until(ExpectedConditions.elementToBeClickable(userMustAcknowledgeChkbx));
		userMustAcknowledgeChkbx.click();	
	}
	
	public void selectCommentToAcknowledgeChkBx()
	{
		wait.until(ExpectedConditions.elementToBeClickable(userMustProvideACommentToAcknowledgeChkbx));
		userMustProvideACommentToAcknowledgeChkbx.click();	
	}
	
	public void selectNextActionAfterAcknowledgeChkBx()
	{
		wait.until(ExpectedConditions.elementToBeClickable(nxtActionOnlyAfterAcknowledgeChkbx));
		nxtActionOnlyAfterAcknowledgeChkbx.click();	
	}
	
	public void clickOnAddActionBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addAction));
		addAction.click();	
	}
	
	public void selectAddReferenceFileWithBrowserandSelectFileChkBx()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addReferenceFileWithBroser));
		addReferenceFileWithBroser.click();		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void uploadFile(String FilePath)
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		attachFileLink.sendKeys(FilePath);		
	}
	
	
}
