package com.itview.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarHomeEMI_PageObj extends TestBase{
	
	@FindBy(id="carhome_loan")
	public WebElement carhomeLoan;
	
	@FindBy(id="loan_period")
	public WebElement loanPeriod;	
	
	@FindBy(css="select.custselect")
	public WebElement emiStartFrom;
	
	@FindBy(id="interest_rate")
	public WebElement interestRate;
	
	@FindBy(id="upfront_charges")
	public WebElement upfrontCharges;
	
	@FindBy(xpath="/html/body/div[13]/section[1]/div/div/div[1]/div[1]/div/div[2]/div/div[5]/a[1]")
	public WebElement SubmitLink;
	
	@FindBy(linkText="Car/Home Loan EMI")
	public WebElement Car_Home_Loan_EMI_Link;
	
	@FindBy(id="wzrk-cancel")
	public WebElement cancelWindow;
	
	@FindBy(id="emi")
	public WebElement emiValue;
	

	public void callPageFactoryElement() {		
		PageFactory.initElements(w, this); 
	}
	

}
