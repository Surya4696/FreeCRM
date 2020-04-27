package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FWUtil
{
	
		static Workbook work_Book;
		static String excel_sheet_path="D:\\FRAMEWORK\\FreeCRMTEST\\src\\main\\"
		                                  +"java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
		static String sheet_name;
		static Sheet sheet;
		static String path= "D:\\FRAMEWORK\\FreeCRMTEST\\src\\main\\java\\screenshot";
	
		public static void takeScreenshotAtEndOfTest( WebDriver driver) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File des= new File (path);
			FileUtils.copyFile(src, des);		
		}
	
	public static Object[][] testData(String sheet_name)
	{
		try 
		{
			work_Book=WorkbookFactory.create(new FileInputStream(excel_sheet_path));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		sheet = work_Book.getSheet(sheet_name);
		Object data[] []=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 
		 for (int i = 0; i < sheet.getLastRowNum(); i++) 
		 {
			 for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) 
			 {
				data[i] [j]=sheet.getRow(1+i).getCell(j).toString();
			 }			
		 }
		return data;		
	}
}
