package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.CarHomeEMI_PageObj;
import com.itview.pageobject.EducationEMI_PageObj;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class EducationEMI_Test {
	
	EducationEMI_PageObj ed=new EducationEMI_PageObj();
  
	@BeforeTest
	public void preCondition() throws Exception {

		ed.openBrowser("chrome");
		ed.callPageFactoryElement();
		
		ed.openApplicationURL();		
		ed.handleClickEvent(ed.cancelWindow);
		ed.handleClickEvent(ed.Education_Loan_EMI_Link);		
		ed.paeScroll();
		ed.waitForSec(4);

	}

	@Test(priority = 0, description = "Verify Education  Amount - > 4 lakh ")
	public void educationLoan_4lakh() throws Throwable {	
		
		
		ed.handleInputEvent(ed.Education_Loan, "400000");
		
		ed.handleInputEvent(ed.interest_rate, "6");		
		
		ed.handleInputEvent(ed.loan_period, "3");
		
		ed.handleClickEvent(ed.SubmitLink);
		
		ed.waitForSec(3);
		
		System.out.println("EMI Value for 4 lakh  (Education Loan) : "+ed.getValidationValue(ed.emiValue));
		
	}

	
	@AfterTest
	public void postCondition() {
		
	     ed.closeBrowser();
	}

}
