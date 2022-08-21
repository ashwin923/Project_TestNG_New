package com.itview.pageobject;

import java.time.Duration;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	String url="https://www.moneycontrol.com/personal-finance/tools/credit-card-debt-payoff-calculator.html";
	WebDriver w;
	
	
	public void openApplicationURL() {
		
		w.get(url);
	}
	
	public void openBrowser(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			w=new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			w=new FirefoxDriver();
			
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			w=new EdgeDriver();			
		}
		
		w.manage().window().maximize();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void closeBrowser() {
		w.quit();
	}
	
	public void handleInputEvent(WebElement we,String value) {		
		we.clear();
		we.sendKeys(value);		
	}
	
	public void handleClickEvent(WebElement we) {		
		we.click();		
	}
	
	public void handleDropDown(WebElement we,String value) {
		
		Select sel=new Select(we);
		sel.selectByVisibleText(value);
	}
	
	public void waitForSec(int sec) throws Exception {		
		Thread.sleep(1000 * sec);
	}
	
	public void handleAlert() {
		try {
		w.switchTo().alert().accept();
		}
		catch(Exception e) {
			
		}
	}
	
	public void handleFrame(String frameName) {
		w.switchTo().frame(frameName);
	}
	

	public String getValidationValue(WebElement we) {
		
		return we.getText();
	}
	
	public String getPageTitle() {
		
		return w.getTitle();
	}
	
	public void paeScroll() {	
		JavascriptExecutor js=(JavascriptExecutor) w;
		js.executeScript("window.scrollBy(0,300)");
	}
	

}
