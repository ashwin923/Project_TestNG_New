package com.itview.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EducationEMI_PageObj extends TestBase{
	
	
	@FindBy(linkText="Education Loan EMI")
	public WebElement Education_Loan_EMI_Link;
	
	@FindBy(id="wzrk-cancel")
	public WebElement cancelWindow;
	
	
	@FindBy(id="educ_loan")
	public WebElement Education_Loan;
	
	@FindBy(id="interest_rate")
	public WebElement interest_rate;
	
	@FindBy(id="loan_period")
	public WebElement loan_period;
	
	@FindBy(id="emi_start_from")
	public WebElement emi_start_from;
	
	@FindBy(id="emi")
	public WebElement emiValue;
	
	@FindBy(linkText="Submit")
	public WebElement SubmitLink;
	

	public void callPageFactoryElement() {		
		PageFactory.initElements(w, this); 
	}
	

}
