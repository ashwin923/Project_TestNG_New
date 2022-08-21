package com.ashwin.login.selenium_automation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) throws Exception {
	
		// interfaceName instance=new implementationClassName();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver w=new ChromeDriver();  // open a blank chrome browser
		
		w.get("http://altoromutual.com:8080/login.jsp"); // step 1 :- open application with url

		w.findElement(By.id("uid")).sendKeys("admin");  //step2 :- enter username
		
		w.findElement(By.id("passw")).sendKeys("admin");  //step3 :- enter password
		
		w.findElement(By.name("btnSubmit")).click(); //step4 :- click login
		
		Thread.sleep(3000); // 3000 millisec =3 sec
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click(); //step5 :- click logout
		
		w.quit(); // close the browser
		
		System.out.println("Admin has succefully Logged-In : Passed");
		
		
	} 

}
