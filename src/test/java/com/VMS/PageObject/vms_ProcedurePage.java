package com.VMS.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VMS.TestCases.BaseClass;

public class vms_ProcedurePage {

	static WebDriver ldriver;
	WebDriverWait wait ;
	
	public vms_ProcedurePage(WebDriver rdriver)
	{
	     ldriver = rdriver;
	     PageFactory.initElements(rdriver, this);
	     wait = new WebDriverWait(ldriver, Duration.ofSeconds(15));
	     if (ldriver.getCurrentUrl().contains("configuration"))
		 {  vms_ConfigurationPage cp = new vms_ConfigurationPage(ldriver);
		    cp.openProcedurePage();       }
		 else 
		 {   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		     vms_ConfigurationPage cp = hm.openConfigurationPage();
		     cp.openProcedurePage();      }
	     BaseClass.wait(1000);
		 BaseClass.log.info("Procedure page is opened");
	}
	
	@FindBy(xpath = "//button[text()='New']")
	public WebElement newProcedureBtn;
	
	@FindBy(xpath = "//button[text()='Delete']")
	public WebElement deleteProcedureBtn;
	
	@FindBy(xpath = "//h3[text()='Procedure Properties']")
	public WebElement procedurePropertiesLabel;
	
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
	
    @FindAll(@FindBy(xpath = "//div[@class='view-item-in-list ng-binding ng-scope']"))
    public List<WebElement> availableProcedures;
	
				
	
	
	public void openProdecurepage()
	    {
		   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		   vms_ConfigurationPage cp = hm.openConfigurationPage();
		   cp.openProcedurePage();
		   BaseClass.wait(1000);
		   BaseClass.log.info("Procedure page is opened");
	 }
	
	public void clickOnNEWbtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(newProcedureBtn));
		newProcedureBtn.click();
		BaseClass.log.info("Clicked on Add New button.");
	}
	
	public void enterProcedureName(String ProcName)
	{
		wait.until(ExpectedConditions.elementToBeClickable(procedureNameTxtbx));
		procedureNameTxtbx.click();
		procedureNameTxtbx.clear();
		procedureNameTxtbx.sendKeys(ProcName);
		BaseClass.log.info("Procedure name "+ProcName+" is entered");
	}
	
	public void clickOnSaveBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(saveProcedureButton));
		saveProcedureButton.click();
		BaseClass.log.info("Clicked on Save button");
	}
	
	public void selectUserMustAcknowledgeChkBx()
	{
		wait.until(ExpectedConditions.elementToBeClickable(userMustAcknowledgeChkbx));
		userMustAcknowledgeChkbx.click();	
		BaseClass.log.info("selected User must Acknowledge checkbox");
	}
	
	public void selectCommentToAcknowledgeChkBx()
	{
		wait.until(ExpectedConditions.elementToBeClickable(userMustProvideACommentToAcknowledgeChkbx));
		userMustProvideACommentToAcknowledgeChkbx.click();
		BaseClass.log.info("selected User Must Provide a comment to Ack checkbox");
	}
	
	public void selectNextActionAfterAcknowledgeChkBx()
	{
		wait.until(ExpectedConditions.elementToBeClickable(nxtActionOnlyAfterAcknowledgeChkbx));
		nxtActionOnlyAfterAcknowledgeChkbx.click();
		BaseClass.log.info("selected Next Action after Ack checkbox");
	}
	
	public void clickOnAddActionBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addAction));
		addAction.click();	
		BaseClass.log.info("Clicked on Add Action button");
	}
	
	public void selectAddReferenceFileWithBrowserandSelectFileChkBx()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addReferenceFileWithBroser));
		addReferenceFileWithBroser.click();		
		BaseClass.wait(500);
	}
	
	public void uploadFile(String FilePath)
	{
		BaseClass.wait(500);
		attachFileLink.sendKeys(FilePath);		
	}
	
	public boolean verifyProcedureIsAdded(String procName)
	{
		List<String> availableProceduresStringList = new ArrayList<String>();
		for(WebElement e : availableProcedures)
		{
			availableProceduresStringList.add(e.getText());
		}
		if (availableProceduresStringList.contains(procName))
		{  return true;  }
		else
		{  return false;  }
	}
	
}
