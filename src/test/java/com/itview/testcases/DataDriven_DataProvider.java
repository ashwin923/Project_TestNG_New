package com.itview.testcases;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DataDriven_DataProvider {

	WebDriver w;

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { 
			new Object[] { "100000", "5","4","Simple Interest" }, 
			new Object[] { "400000", "8.5","10","Simple Interest" }, 
			new Object[] { "800000", "6.5","5","Simple Interest" }, 
		};
	}

	@BeforeTest
	public void preCondition() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
		w.manage().window().maximize();
	}

	@Test(dataProvider = "dp")
	public void fixedDeposit_Test(String principle, String ROI,String tenurePeriodData,String frequencyData) throws Exception {

		  w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		try {
			w.findElement(By.id("wzrk-cancel")).click();
		} catch (Exception e) {
		}

		w.findElement(By.id("principal")).clear();
		w.findElement(By.id("principal")).sendKeys(principle);

		w.findElement(By.name("interest")).clear();
		w.findElement(By.name("interest")).sendKeys(ROI);

		w.findElement(By.id("tenure")).clear();
		w.findElement(By.id("tenure")).sendKeys(tenurePeriodData);

		WebElement tenurePeriod = w.findElement(By.id("tenurePeriod"));
		Select tenurePeriodDropDown = new Select(tenurePeriod);
		tenurePeriodDropDown.selectByVisibleText("year(s)");

		WebElement frequency = w.findElement(By.id("frequency"));
		Select frequencyDropDown = new Select(frequency);
		frequencyDropDown.selectByVisibleText(frequencyData);

		w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();

		Thread.sleep(2000);

		String maturityAmt = w.findElement(By.id("resp_matval")).getText();
		System.out.println("Maturity Amount : " + maturityAmt+" for principle : "+principle);

	//	System.out.println("Maturity Amount : " + maturityAmt + " for principle : " + df.formatCellValue(principle));

	//	Assert.assertTrue(maturityAmt.contains(df.formatCellValue(maturityValue)), "Maturity Value is different !!!");

	}

	@AfterTest
	public void postCondition() {

		w.quit();
	}

}
