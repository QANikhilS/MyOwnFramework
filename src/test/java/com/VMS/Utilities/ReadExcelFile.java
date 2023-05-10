package com.VMS.Utilities;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelFile {
	
	public static FileInputStream inputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
		
	
	public static String getCellValue(String sheetName, int rowNo, int cellNo/*column no*/)
	{
	  try
	  {
		inputStream = new FileInputStream("C:\\Users\\nikhils\\Music\\OwnFramework\\TestData\\TestData.xlsx");
		workBook = new XSSFWorkbook(inputStream);
		excelSheet = workBook.getSheet(sheetName);
		cell = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
		
		workBook.close();
		
		return cell.getStringCellValue();
	  }
	  catch (Exception e)
	  {
		  return "";
	  }
	}
	
	
	public static int getRowCount(String sheetName) throws Exception
	{
	  try
	  {
		inputStream = new FileInputStream("C:\\Users\\nikhils\\Music\\OwnFramework\\TestData\\TestData.xlsx");
		//Create XSSFWorkBook class object for excel file manipulation.
		
		workBook = new XSSFWorkbook(inputStream);
		excelSheet = workBook.getSheet(sheetName);
		
		int totalRows = excelSheet.getLastRowNum()+1;
		
		workBook.close();
		return totalRows;
	  }
	  catch(Exception e)
	  {
		  return 0;
	  }
	}
	
	
	public static int getColCount(String sheetName) throws Exception
	{
	  try
	  {
		inputStream = new FileInputStream("C:\\Users\\nikhils\\Music\\OwnFramework\\TestData\\TestData.xlsx");
		//Create XSSFWorkBook class object for excel file manipulation.
		
		workBook = new XSSFWorkbook(inputStream);
		excelSheet = workBook.getSheet(sheetName);
		
		int totalCels = excelSheet.getRow(0).getLastCellNum();
		
		workBook.close();
		return totalCels;
	  }
	  catch(Exception e)
	  {
		  return 0;
	  }
	}
	
	
	
	

	public void getexceldata() throws Exception
	{
		System.out.println(getCellValue("webpages", 4, 1));

	}

}
