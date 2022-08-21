package com.itview.testcases;



import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Data_Driven_FixedDeposit {
	
	WebDriver w;
	DataFormatter df;
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sht;
	XSSFRow row;
	XSSFCell principle,ROI,tenurePeriod,frequencyCell,maturityValue;
	
	
  
  @BeforeTest
  public void openBrowser() throws Exception{
	  
	  WebDriverManager.chromedriver().setup();
	  w=new ChromeDriver();
	  w.manage().window().maximize();
	  
	  df=new DataFormatter();
	   fi=new FileInputStream(".\\TestData\\FDCal.xlsx");		
	   wb=new XSSFWorkbook(fi);
	   sht=wb.getSheetAt(0);
	  
  }
  
  
  @Test(priority = 0, description = "validate Fixed deposit with multiple data")
  public void verifyFixedDeposit_SI() throws Exception {
	  
	  

	  int rowCount=sht.getLastRowNum();
	  
	  for(int i=1;i<=rowCount;i++) {
		  
	 //i - > row index
		  
	  row=sht.getRow(i);		  
	
	  principle=row.getCell(0);
	  ROI=row.getCell(1);
	  tenurePeriod=row.getCell(2);
	  frequencyCell=row.getCell(3);
	  maturityValue=row.getCell(4);
	  
	  
	  w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
  
	  try {
	  w.findElement(By.id("wzrk-cancel")).click();
	  }catch(Exception e ) {}
	  
	  w.findElement(By.id("principal")).clear();
	  w.findElement(By.id("principal")).sendKeys(df.formatCellValue(principle).toString());
	  
  
	  w.findElement(By.name("interest")).clear();
	  w.findElement(By.name("interest")).sendKeys(df.formatCellValue(ROI).toString());  
 
	  
	  w.findElement(By.id("tenure")).clear();
	  w.findElement(By.id("tenure")).sendKeys(df.formatCellValue(tenurePeriod).toString());
	  
	  WebElement tenurePeriod=w.findElement(By.id("tenurePeriod"));
	  Select tenurePeriodDropDown=new Select(tenurePeriod);
	  tenurePeriodDropDown.selectByVisibleText("year(s)");
	  
	  WebElement frequency=w.findElement(By.id("frequency"));
	  Select frequencyDropDown=new Select(frequency);
	  frequencyDropDown.selectByVisibleText(df.formatCellValue(frequencyCell).toString());	  
	  
	  
	  w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
	  
	  Thread.sleep(2000);
	  
	  String maturityAmt=w.findElement(By.id("resp_matval")).getText();
	  
	  System.out.println("Maturity Amount : "+maturityAmt+" for principle : "+df.formatCellValue(principle));
	  
	  Assert.assertTrue(maturityAmt.contains(df.formatCellValue(maturityValue)),"Maturity Value is different !!!");
	  
	  }
  }

  @AfterTest
  public void afterTest() {
	  
	  w.quit();
  }

}
