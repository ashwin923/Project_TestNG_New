package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.CarHomeEMI_PageObj;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

//@Listeners(Listener_Package.ListenerClass.class)

@Listeners(com.itview.pagebject.Listeners.class)

public class CarHomeEMI_Test {
	
	CarHomeEMI_PageObj ch=new CarHomeEMI_PageObj();
  
	@BeforeTest
	public void preCondition() throws Exception {

		ch.openBrowser(ch.readDataFromPropertiesFile("browser"));
		
	
		ch.callPageFactoryElement();
		
		ch.openApplicationURL(ch.readDataFromPropertiesFile("application_url"));	
		
	
		
		ch.handleClickEvent(ch.cancelWindow);
		ch.handleClickEvent(ch.Car_Home_Loan_EMI_Link);		
		ch.paeScroll();
		ch.waitForSec(4);
		
		

	}

	@Test(priority = 0, description = "Verify car loan  Amount - > 10 lakh ")
	public void carLoan_10lakh() throws Throwable {	
		
		
		ch.printInfo("Chrome Browser is opened with application URL ");
		
		ch.handleInputEvent(ch.carhomeLoan, "1000000");
		
		ch.handleInputEvent(ch.loanPeriod, "3");
		
		ch.handleDropDown(ch.emiStartFrom, "From next month after disbursement");
		
		ch.handleInputEvent(ch.interestRate, "7");
		
		
		ch.handleClickEvent(ch.SubmitLink);
		

		ch.printInfo("Entered carhomeloan requirement for calculation");

		
		ch.waitForSec(3);		

		ch.printInfo("EMI Value for 10 lakh car loan for 3 years : "+ch.getValidationValue(ch.emiValue));

	}

	
	@AfterTest
	public void postCondition() {
		
	     ch.closeBrowser();
	}

}
