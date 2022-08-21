package com.itview.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginOrangeHRM {
  
	WebDriver w;
	
  @BeforeTest
  public void preConditionOrangeHRM() { 
	  
	  WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
  }
  
  @Test
  public void loginOrangeHRM() throws Exception {
	  
	  w.get("https://opensource-demo.orangehrmlive.com/");		
		
		w.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		
		w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		
		w.findElement(By.cssSelector("input.button")).click();
		
		Thread.sleep(3000);
		
		w.findElement(By.id("welcome")).click();
		
		Thread.sleep(3000);
		
		w.findElement(By.linkText("Logout")).click();	
  }

  @AfterTest
  public void postConditionOrangeHRM() {
	  
	  w.quit();
  }

}
