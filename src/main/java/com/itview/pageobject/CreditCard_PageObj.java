package com.itview.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCard_PageObj extends TestBase {
	
	
//	WebElement outstandingAmt=w.findElement(By.id("debtpayoff"));
	
	@FindBy(id="debtpayoff")
	public WebElement outstandingAmt;
	
	@FindBy(id="payment_plan_every_month")
	public WebElement paymentPlan;
	
	@FindBy(id="monthly_interest")
	public WebElement monthlyInterest;
	
	@FindBy(linkText="Submit")
	public WebElement SubmitLink;
	
	@FindBy(id="total_payment")
	public WebElement totalPaymentCalculated;
	
	@FindBy(id="wzrk-cancel")
	public WebElement cancelWindow;
	
	public void callPageFactoryElement() {		
		PageFactory.initElements(w, this); 
	}
	
}
