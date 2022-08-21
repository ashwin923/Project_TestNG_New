package com.itview.pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;

public class TestBase {
	
	
	
	static WebDriver w;
	Logger log=LogManager.getLogger("TestBase");

	
	public void openApplicationURL(String url) {
		
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
	
	
	public String readDataFromPropertiesFile(String passKey) throws Exception   {
		
		FileInputStream fi=new FileInputStream(".\\Config\\config.properties");		
		Properties p=new Properties();		
		p.load(fi);
		
		String returnValue=p.getProperty(passKey);		
		
		fi.close();
		
		return returnValue;
	}
	
	public static void takeScreenshot(String screenshotPath ) throws Exception {
		
		 TakesScreenshot ts=(TakesScreenshot) w;	       
	       File f=ts.getScreenshotAs(OutputType.FILE);       
	       FileUtils.copyFile(f, new File(screenshotPath));
	}
	
	public void printInfo(String message) {
		
		log.info(message);
		
	}
	
public void printError(String message) {
		
		log.error(message);
		
	}

public void printWarn(String message) {
	
	log.warn(message);
	
}

}
