package com.VMS.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VMS.TestCases.BaseClass;

public class vms_GroupHierarchyPage {
	
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;  
			
	public vms_GroupHierarchyPage(WebDriver rdriver)
	{
	     ldriver = rdriver;
	     PageFactory.initElements(rdriver, this);
	     js = ((JavascriptExecutor) ldriver); 
	     wait = new WebDriverWait(rdriver, Duration.ofSeconds(30));
	}
	
	
   @FindBy(xpath = "//button[text()='Add Group']")
   public WebElement addGroupBtn;
   
   @FindBy(xpath = "//div[contains(@class,'footer bottom')]/button[1]")
   public WebElement saveGroupBtn;

   @FindBy(xpath = "(//div[@class='vms-resource-group-view' and @default-tree-state='groupView']/dl/div[2]/dd//span[@class='vms-treeview-label' and contains(text(),'Group')])[1]")
   public WebElement firstGroup;
   
   @FindBy(xpath = "(//div[@class='vms-resource-group-view' and @default-tree-state='groupView']/dl/div[2]/dd//span[@class='vms-treeview-label' and contains(text(),'Group')])[last()]")
   public WebElement lastGroup;
   
   @FindAll(@FindBy(xpath = "//div[@class='vms-resource-group-view' and @default-tree-state='groupView']/dl/div[2]/dd//span[@class='vms-treeview-label' and contains(text(),'Group')]"))
   public List<WebElement> listOfAllPresentGroups;
   
   @FindAll(@FindBy(xpath = "//div[@class='vms-resource-group-view' and @default-tree-state='groupView']/dl/div[2]/dd//span[@class='vms-treeview-label' and contains(@title,'/')]"))
   public List<WebElement> listOfAllPresentSubGroups;
   
   
   
 
   
   
   @FindBy(xpath = "//div[@class='vms-treeview-edit-buttons-container']/i[1]")
   public WebElement addSubGroupBtn;
   
   
 
   
   
   @FindBy(xpath = "//div[@class='hierarchy-panel-buttons']/nav/button[4]")
   public WebElement deleteSelectedBtn;
   
   @FindBy(xpath = "//div[@class='modal-footer-confirm']/button[1]")
   public WebElement yesBtnFromConfirmationWindow; 
   
   @FindBy(xpath = "//div[@class='vms-treeview-edit-buttons-container']/i[3]")
   public WebElement editGroupNamePencilIcon; 
   
   @FindBy(xpath = "//div[@class='vms-treeview-edit-buttons-container']/i[5]")
   public WebElement saveGroupNameCheckIcon; 
   
   @FindBy(xpath = "//input[@class='vms-treeview-node-edit']")
   public WebElement editGroupNameTextBox; 
   
   
 
 
 
 
   
   
   
   
   
   
   
   public void openGroupHierarchyPage()      
	{
		ldriver.navigate().to(BaseClass.VMSURL+"/#/configuration/advanced/hierarchy_groups");
		new WebDriverWait(ldriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(addGroupBtn));
	}
   
   public void clickOnAddGroupBtn(int ExpectedGroupCount) throws Exception
   {    
	   Actions act = new Actions(ldriver);
      for (int i = 1; i<ExpectedGroupCount ; i++)	   
	   {
    	  act.moveToElement(addGroupBtn).click().build().perform();
    	  wait.until(ExpectedConditions.elementToBeClickable(lastGroup));
    	  act.moveToElement(lastGroup).build().perform();
    	  wait.until(ExpectedConditions.elementToBeClickable(editGroupNamePencilIcon));
    	  act.click(editGroupNamePencilIcon).build().perform();
    	  Thread.sleep(500);
    	  wait.until(ExpectedConditions.elementToBeClickable(editGroupNameTextBox));
    	  String grpid = String.valueOf(i);
    	  editGroupNameTextBox.sendKeys(grpid);               
    	  Thread.sleep(500);
    	  act.sendKeys(Keys.ENTER).build().perform();
    	  Thread.sleep(1000);
	   }
      //this.firstGroup.click();
   }

   public void clickOnFirstSubGroup() throws Exception
   {
	   Actions act = new Actions(ldriver);
	      for (int i = 0; i<=listOfAllPresentGroups.size() ; i++)	   
		   {
	    	  act.moveToElement(listOfAllPresentGroups.get(i)).click().build().perform();
	    	  wait.until(ExpectedConditions.elementToBeClickable(addSubGroupBtn));
	    	  act.moveToElement(addSubGroupBtn).click().build().perform();
	    	  Thread.sleep(500);
	    	}    
	    	    
	    	//  wait.until(ExpectedConditions.elementToBeClickable(editGroupNamePencilIcon));
	    	//  editGroupNamePencilIcon.click();
	    	//  String grpid = String.valueOf(i);
	    	//  Thread.sleep(500);
	    	//  editGroupNameTextBox.sendKeys(grpid);
	    //	  Thread.sleep(500);
	    	//  act.sendKeys(Keys.ENTER).build().perform();
		 
   }
   
   
   
   
   
   
   
   public void clickOnSaveGroupBtn()
   {    wait.until(ExpectedConditions.elementToBeClickable(saveGroupBtn)).click();       }
   
   public void deleteAllGroups() throws Exception
   {
	   System.out.println(" Total groups present in the VMS are = "+listOfAllPresentGroups.size());
	   js.executeScript("arguments[0].click();", firstGroup);
	   int i = listOfAllPresentGroups.size();
	   while  (i!=0)
	   {
		  js.executeScript("arguments[0].click();", firstGroup);
		  Thread.sleep(1000);
		  wait.until(ExpectedConditions.elementToBeClickable(deleteSelectedBtn)).click();
		  Thread.sleep(500);
		  wait.until(ExpectedConditions.elementToBeClickable(yesBtnFromConfirmationWindow)).click();
		  Thread.sleep(500);
		  i--;
		}
	   this.clickOnSaveGroupBtn();
    }
   
}
