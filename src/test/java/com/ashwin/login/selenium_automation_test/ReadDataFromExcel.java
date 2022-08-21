package com.ashwin.login.selenium_automation_test;



import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args)throws Exception {

     //File Excel -> Workbook - > Sheet - > Rows -> Cells -> Get Data
		// XSSF -> .xlsx
		// HSSF -> .xls
		
		DataFormatter df=new DataFormatter();
		
		FileInputStream fi=new FileInputStream(".\\TestData\\FDCal.xlsx");		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sht=wb.getSheetAt(0);
		
		XSSFRow row=sht.getRow(3);
		
		XSSFCell cell_A =row.getCell(0);
		XSSFCell cell_D =row.getCell(3);
		
		System.out.println(df.formatCellValue(cell_A));
		System.out.println(df.formatCellValue(cell_D));
		
		 int rowCount=sht.getLastRowNum();
		 
		 System.out.println(rowCount);

	}

}
