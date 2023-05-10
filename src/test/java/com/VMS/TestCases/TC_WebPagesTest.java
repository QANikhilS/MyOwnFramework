package com.VMS.TestCases;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_WebPagesTest extends BaseClass
{
    @Test(priority = 0)
	public void OpenWebPages()  
	{
    	webpage.openWebPagespage();
	}
	
	//@Test(priority = 1, groups = {"Setup", "SetupVAX", "SetupVAS"}, dataProvider = "WebpagesTestData")
	public void AddWebPages(String webpageName, String webURL) throws Exception 
	{
		webpage.clickOnNewWebpageBtn(); 
        log.info("clicked on NEW button.");
        webpage.addWebPage(webpageName, webURL); 
		Thread.sleep(300);
     }
	
	@DataProvider(name = "WebpagesTestData")
	public Object[][] addWebpagesDataset()
	{
		return new Object[][] 
				{
                    {"1. Alibaba","http://www.alibaba.com"}, {"2. NDTV","http://www.ndtv.com"} , 
                    {"3. Vicon","https://www.vicon.com/"} , {"4. ZeeNews","http://www.zeenews.com"} , 
                    {"5. Selenium Dev","https://www.selenium.dev/"}, {"6. TestNG","https://testng.org/doc/"} , 
                    {"7. Cemtrex Labs","https://cemtrex.com/"} 
				};
	}
		
	
	
	

	//@Test(priority = 2)
	public void deleteWebPages() throws Exception
	 {
		webpage.deleteAllWebPages();
		Thread.sleep(1000);

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
           //Path of the excel file	   
           //FileInputStream fs = new FileInputStream("C:\\Users\\nikhils\\Music\\OwnFramework\\TestData\\TestData.xlsx");	--> This fs is declared at base class globally	

            //Creating a workbook	
           XSSFWorkbook workbook = new XSSFWorkbook(fs);	
           XSSFSheet sheet = workbook.getSheetAt(1);	 
           
           String sheetName = sheet.getSheetName();			
           Row row = sheet.getRow(0);	
           Cell column = row.getCell(0);	

           System.out.println(sheet.getRow(0).getCell(0)); 
      
           int lengthOfColumnWebpageName = sheet.getLastRowNum();
           
           
           System.out.println("1. Total number of Rows = " + sheet.getLastRowNum()); // Start with 0 that is total 4 rows 
           System.out.println("2. Total number of Columns = " + sheet.getRow(0).getLastCellNum()); 
           System.out.println("3. First cell of first column = " + sheet.getRow(0).getCell(0).getStringCellValue()); 
           System.out.println("4. First cell of second column = " + sheet.getRow(0).getCell(1).getStringCellValue()); 

            List<String> listOfWebpagename = new ArrayList<String>() ; 
            List<String> listOfWebpageURL = new ArrayList<String>() ; 	 

           for (int i = 1 ; i< lengthOfColumnWebpageName+1 ; i++)	 
            {		
             // System.out.println( sheet.getRow(i).getCell(0));	
              String CurrentWebpageNames = sheet.getRow(i).getCell(0).getStringCellValue();		 
              listOfWebpagename.add(CurrentWebpageNames);		 		 
      
              for ( int j = i ; j<=i ; j++)		 
                 {			 
                    //  System.out.println( sheet.getRow(j).getCell(1));			 
                      String CurrentWebpageURLs = sheet.getRow(j).getCell(1).getStringCellValue();			 
                      listOfWebpageURL.add(CurrentWebpageURLs);		
                 } 	
             }
         //  System.out.println(listOfWebpagename  + "++++"); 
          // System.out.println(listOfWebpageURL  + "++++");
           
           
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
                  	Thread.sleep(1000);
                  	webpage.clickOnSaveBtn();
                  	Thread.sleep(2000);
                 }
	        
           }
	
	
	
	
	   }
	
	
}
