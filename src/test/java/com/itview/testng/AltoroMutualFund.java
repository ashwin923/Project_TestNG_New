package com.itview.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class AltoroMutualFund {
 
	WebDriver w;
	@BeforeTest
	public void preCondition_openBrowser() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
	}

	@Test(priority = 0,description = "Test Case to validate login - admin functionality",groups = "Login",invocationCount = 1)
	public void loginAdmin() throws Exception {

		w.get("https://demo.testfire.net/login.jsp"); // Step 1 : Open application with url

		w.findElement(By.id("uid")).sendKeys("admin"); // Step 2 : Enter username

		w.findElement(By.id("passw")).sendKeys("admin"); // Step 3 : Enter password

		w.findElement(By.name("btnSubmit")).click(); // Step 4: Click login

		Thread.sleep(3000); // 3000 millisec = 3 sec

		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click(); // Step 5: Click Logout
		
		//Assert.fail("failing for testing");
	}
	
	
	
	@Test(priority = 1, description = "Test Case to validate login - Jsmith functionality",dependsOnMethods = "loginAdmin",groups = "Login",enabled = false)
	public void loginJsmith() throws Exception {

		w.get("https://demo.testfire.net/login.jsp"); 

		w.findElement(By.id("uid")).sendKeys("jsmith"); 

		w.findElement(By.id("passw")).sendKeys("Demo1234"); 

		w.findElement(By.name("btnSubmit")).click(); 

		Thread.sleep(3000); 

		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click(); 
	}
	
	
	@Test(priority = 2, description = "Test Case to validate login - TestUser functionality",dependsOnMethods = "loginAdmin",groups = "Login")
	public void loginTestUser() throws Exception {

		w.get("https://demo.testfire.net/login.jsp"); 

		w.findElement(By.id("uid")).sendKeys("tuser"); 

		w.findElement(By.id("passw")).sendKeys("tuser"); 

		w.findElement(By.name("btnSubmit")).click(); 

		Thread.sleep(3000); 

		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click(); 
	}
	
	

	@AfterTest
	public void postCondition_closeBrowser() {

		w.quit();

	}

}