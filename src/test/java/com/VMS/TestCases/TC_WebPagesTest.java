package com.VMS.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_WebPagesTest extends BaseClass
{
    @Test(priority = 0)
	public void OpenWebPages()  
	{
    	webpage.openWebPagespage();
    	log.info("Webpage page is opened");
    	if (driver.getCurrentUrl().equalsIgnoreCase("http://"+readConfigData.getBaseURL()+"/#/configuration/network_entities/web_sites"))
    	{
    		Assert.assertTrue(true, "Webpage is successfuly opened.");
    	}
    	else 
    	{
    		capctureScreenshot(driver, "deleteWebPages");
			log.info(" Something went wrong. Webpages page is not opened");
    		Assert.assertFalse(false, "Webpage is not opened");
    	}
	}
	
	//@Test(priority = 1)
	public void AddSingleWebPages()
	{
		String ExpectedwebPageName = "Alibaba";
		String ExpectedwebURL = "www.alibaba.com";
		webpage.clickOnNewWebpageBtn(); 
        log.info("clicked on NEW button.");
        webpage.addWebPage(ExpectedwebPageName, ExpectedwebURL); 
        BaseClass.wait(1000);
        if(webpage.firstWebPage.getText().equalsIgnoreCase(ExpectedwebPageName))
        {
        	Assert.assertTrue(true);
        }
        else 
        {
        	capctureScreenshot(driver, "deleteWebPages");
			log.info(" Something went wrong. Webpages page is not opened");
    		Assert.assertFalse(false, "Webpage is not opened");
		}
        
     }
	

	//@Test(priority = 2)
	public void deleteWebPages() throws Exception
	 {
		webpage.deleteAllWebPages();
		BaseClass.wait(1000);

		if (webpage.listOfAvailableWebPages.size() == 0) 
		 {
			log.info("deleteWebPages  -  Passed. ");
			Assert.assertTrue(true);
			log.info("All webpages are deleted.");
		 } 
		else 
		 {
			log.info("deleteWebPages  -  Failed. ");
			capctureScreenshot(driver, "deleteWebPages");
			log.info(" Something went wrong. All webpages are not deleted.");
			Assert.assertTrue(false);
		 }
		log.info("************  Test Case - deleteWebPages is finished ************");	
	}
	
	
	@Test
	   public void addAllWebpage() throws Exception 
	   {
           XSSFWorkbook workbook = new XSSFWorkbook(fs);	
           XSSFSheet sheet = workbook.getSheetAt(1);	 
           
           String sheetName = sheet.getSheetName();			
           Row row = sheet.getRow(0);	
           Cell column = row.getCell(0);	
      
           int lengthOfColumnWebpageName = sheet.getLastRowNum();
           
           List<String> listOfWebpagename = new ArrayList<String>() ; 
           List<String> listOfWebpageURL = new ArrayList<String>() ; 	 

           for (int i = 1 ; i< lengthOfColumnWebpageName+1 ; i++)	 
            {		
              String CurrentWebpageNames = sheet.getRow(i).getCell(0).getStringCellValue();		 
              listOfWebpagename.add(CurrentWebpageNames);		 		 
       
                 for ( int j = i ; j<=i ; j++)		 
                   {			 
                       String CurrentWebpageURLs = sheet.getRow(j).getCell(1).getStringCellValue();			 
                       listOfWebpageURL.add(CurrentWebpageURLs);		
                   } 	
            }
           
           //add Webpages 
           for (int i = 0 ; i<listOfWebpagename.size() ; i++)
             {
        	   webpage.clickOnNewWebpageBtn();
        	   String webPageName = listOfWebpagename.get(i);
        	   webpage.enterWebPageName(webPageName);
           
                 for (int j = i ; j<=i ; j++)
                 {
                 	String webPageURL = listOfWebpageURL.get(j);
                  	webpage.enterWebPageURL(webPageURL);
                  	BaseClass.wait(1000);
                  	webpage.clickOnSaveBtn();
                  	log.info("Webpage "+webPageName+" is added.");
                  	BaseClass.wait(2000);
                 }
             }
	   }
	
	
}
