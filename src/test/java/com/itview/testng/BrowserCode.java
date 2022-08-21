package com.itview.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCode {
	
   WebDriver w;
	
  @Test(priority = 0, description = "Verify Google Page on 'Chrome'")
  public void chromeBrowser() throws Exception {
	  
	  WebDriverManager.chromedriver().setup();
	  
	  w=new ChromeDriver();
	  w.get("https://www.google.com/");
	  
	  String googlePageTitle=w.getTitle();
	  Assert.assertEquals(googlePageTitle, "Google");
	  
	  Thread.sleep(2000);
	  
	  w.quit();
  }
  
  @Test(priority = 1, description = "Verify Google Page on 'Firefox'")
  public void firefoxBrowser() throws Exception {
	  
	  WebDriverManager.firefoxdriver().setup();
	  
	  w=new FirefoxDriver();
      w.get("https://www.google.com/");
	  
	  String googlePageTitle=w.getTitle();
	  Assert.assertEquals(googlePageTitle, "Google");
	  
	  Thread.sleep(2000);
	  
	  w.quit();
	  
  }
  
  @Test(priority = 2, description = "Verify Google Page on 'Edge'")
  public void edgeBrowser() throws Exception {
	  
	  WebDriverManager.edgedriver().setup();
	  
	  w=new EdgeDriver();
	  
      w.get("https://www.google.com/");
	  
	  String googlePageTitle=w.getTitle();
	  Assert.assertEquals(googlePageTitle, "Google");
	  
	  Thread.sleep(2000);
	  
	  w.quit();
  }
  
  
}
