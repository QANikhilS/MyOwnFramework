package com.VMS.PageObject;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VMS.TestCases.BaseClass;

public class vms_IntegrationPartnerPage {
	
	WebDriver ldriver;

	public vms_IntegrationPartnerPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	     if (ldriver.getCurrentUrl().contains("configuration"))
		 {  vms_ConfigurationPage cp = new vms_ConfigurationPage(ldriver);
		    cp.openIntegrationPartnerPage();       }
		 else 
		 {   vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		     vms_ConfigurationPage cp = hm.openConfigurationPage();
		     cp.openIntegrationPartnerPage();    }    
	     BaseClass.wait(1000);
		 BaseClass.log.info("Integration partner page is opened");
	}

	@FindBy(xpath = "//div[@class='ip-btn-container']/button[1]")
	public WebElement AddPartnerbtn;
	
	@FindBy(xpath =  "//div[@class='ip-btn-container']/button[2]")
	public WebElement DeletePartnerbtn;	
	
	@FindBy(css = "input[type='search']")
	public WebElement SearchBox;	

	@FindAll(@FindBy(xpath = "//div[contains(@class,'container-body')]/div[2]/div/div"))
	public List<WebElement> AvailableIntegrationPartners;
	
	@FindAll(@FindBy(xpath = "//ul[contains(@class,'children')]//span[3]"))
	public List<WebElement> AvailableDoors;
	
	@FindBy(id = "partnerTypeFormat")  
	public WebElement PartnertypeDropdown;
	
	@FindBy(id = "partnerNameFormat")  
	public WebElement PartnerNameDropdown;
	
	@FindBy(xpath = "//input[@ng-model='model.accessControlNameValue']")
	public WebElement AddIntegrationPartnerNameTextBox;
	
	@FindBy(xpath = "//input[@ng-model='model.accessControlIPValue']")
	public WebElement AddIntegrationPartnerIPaddressTextBox;
	
	@FindBy(xpath = "//input[@ng-model='model.accessControlUsernameValue']")
	public WebElement AddIntegrationPartnerUsernameTextBox;
	
	@FindBy(xpath = "//input[@ng-model='model.accessControlPwdValue']")
	public WebElement AddIntegrationPartnerPasswordTextBox;
	
	@FindBy(xpath = "//button[text()='Next']")
	public WebElement AddIntegrationPartnerNextBtn;
	
	@FindBy(xpath = "(//button[text()='Cancel'])[1]")
	public WebElement AddIntegrationPartnerCancelBtn;
	
	@FindBy(xpath = "(//button[text()='Save'])[1]")
	public WebElement AddIntegrationPartnerSaveBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	public WebElement YesBtn;
	
	@FindBy(xpath = "//button[contains(text(),'No')]")
	public WebElement NoBtn;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	public WebElement OKBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Deleted')]")
	public WebElement DeletedConfirmationMessage;

	@FindBy(xpath = "//input[@id='access-ip']")
	public WebElement ipAddressOfVAXInProperties;
	
	@FindBy(css =  "label[class='ng-binding']")
	public WebElement IntPartnerRemovedSuccessMessage;
	
	@FindBy(xpath = "//div[@class='vms-modal-popup-header']/div[2]/span")
	public WebElement ClosebuttonOnDeleteDeviceProcess;	
	
	@FindBy(xpath = "//span[text()='Refresh User Info.']")
	public WebElement RefreshUserInfoBtm;
	
	@FindBy(xpath = "//div[contains(text(),'User Information Refreshed Successfully')]")
	public WebElement RefreshUserInfoConfirmationMessage;
	
	@FindBy(xpath = "//*[@class='vax-props ng-scope'] //*[@id='access-ip']")
	public WebElement ipNameInRHSprop;
	
	@FindBy(xpath = "//span[contains(text(),'VAX-54')]")
	public WebElement addedVAX;
	
	@FindBy(xpath = "//img[@src='/app/images/xls-export-icon.svg']")
	public WebElement exportExcel;
	
	
	
	
	

	
	
    public void openIntegrationPartnerPage()
    {
		vms_Home_MonitoringPage hm = new vms_Home_MonitoringPage(ldriver);
		vms_ConfigurationPage cp = hm.openConfigurationPage();
		cp.openIntegrationPartnerPage();
		BaseClass.wait(1000);
    }

	public String ipOFCurrentVAX()
    {
		ipNameInRHSprop.click();
		String IPvalue = ipNameInRHSprop.getText();
		return IPvalue; 
    }
	
	public void clickOnAddPartner()
    {
    	AddPartnerbtn.click();
    }

    public void PartnerTypeAsAccessControl()
    {
    	Select se = new Select (PartnertypeDropdown);
    	se.selectByVisibleText("Access Control");
    }

    public void PartnerNameAsVAX()
    {
    	Select se = new Select (PartnerNameDropdown);
    	se.selectByVisibleText("VAX");
    }
    
    public void IntrgrationPartnerEnterName(String NameOfVAX)
    {
    	AddIntegrationPartnerNameTextBox.sendKeys(NameOfVAX);
    }
    
    public void IntrgrationPartnerEnterIP(String IPOfVAX)
    {
    	AddIntegrationPartnerIPaddressTextBox.sendKeys(IPOfVAX);
    }
    
    public void IntrgrationPartnerEnterUsername(String usernameOfVAX)
    {
    	AddIntegrationPartnerUsernameTextBox.sendKeys(usernameOfVAX);
    }
    
    public void IntrgrationPartnerEnterpassword(String passwordOfVAX)
    {
    	AddIntegrationPartnerPasswordTextBox.sendKeys(passwordOfVAX);
    }
    
    public void ClickOnNEXTbtn()
    {
    	AddIntegrationPartnerNextBtn.click();
    }
    
    public void selectAllDoors()
    {
    	for (int i = 0; i<AvailableDoors.size(); i++)
    	{
    		AvailableDoors.get(i).click();
    	}	
    }
    
    public void ClickOnSAVEbtn()
    {
    	AddIntegrationPartnerSaveBtn.click();
    }
    
    public int listOfAvailableIPs()
    {
    	
    	int presentIPS = AvailableIntegrationPartners.size();
		return presentIPS;
    }
    
    public void deleteAnyIntegrationPartner()
    {
    	DeletePartnerbtn.click();
    	BaseClass.wait(1000);
    	YesBtn.click();
    	BaseClass.wait(1000);
    }
    
    public String deleteConfirmationMessage()
    {
    	String DCM = DeletedConfirmationMessage.getText();
    	return DCM;
    }

    
    public void closeDeleteProcessWindow()
    {
    	ClosebuttonOnDeleteDeviceProcess.click();    	
    }
    
    public void clickonRefreshUserInfo()
    {
    	RefreshUserInfoBtm.click();
    }
    
    public String refreshUserInfoConfirmationMessage()
    {
    	new WebDriverWait(ldriver, Duration.ofSeconds(45)).until(ExpectedConditions.visibilityOf(RefreshUserInfoConfirmationMessage));
    	String UserInformationRefreshedConfirmationMessage = RefreshUserInfoConfirmationMessage.getText();
    	return UserInformationRefreshedConfirmationMessage;
    }
    
    public boolean refreshUserInfoConfirmationMessageWindowVisibility()
    {
    	new WebDriverWait(ldriver, Duration.ofSeconds(45)).until(ExpectedConditions.visibilityOf(RefreshUserInfoConfirmationMessage));
    	RefreshUserInfoConfirmationMessage.isDisplayed();
		return true;
    }
     
    public void clickOnOKbtn()
    {
    	new WebDriverWait(ldriver, Duration.ofSeconds(45)).until(ExpectedConditions.elementToBeClickable(OKBtn));
    	OKBtn.click();
    }
    
    public String getaddedIntegrationPartnerIP()
    {
    	String elementText="";
    	//JavascriptExecutor js = (JavascriptExecutor) ldriver;
    	WebElement element = ldriver.findElement(By.xpath("//input[@id='access-ip']"));
    	//String elementText = (String) js.executeScript("return arguments[0].innerText;", element);
    	Actions act = new Actions(ldriver);
        act.moveToElement(element).click().build().perform();
        BaseClass.wait(1000);
        act.doubleClick().build().perform();
        BaseClass.wait(1000);
        act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        //act.sendKeys(Keys.DOWN).perform();act.sendKeys(Keys.DOWN).perform();act.sendKeys(Keys.DOWN).perform();
        //act.sendKeys(Keys.ENTER).perform();
        BaseClass.wait(1000);
        try
        {
			elementText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		}
        catch (HeadlessException e) 
        {
			e.printStackTrace();
		}
        catch (UnsupportedFlavorException e) 
        {
			e.printStackTrace();
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		} 
    	 return elementText ;
    }
    

    
}