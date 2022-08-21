package com.itview.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssertTest {

	WebDriver w;

	@BeforeTest
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Validate Login page")
	public void loginTest() {

		w.get("https://demo.testfire.net/login.jsp");

		String loginTitle = w.getTitle();
		Assert.assertEquals(loginTitle, "Altoro Mutual", "Title is wrong !!!");

		String loginURL = w.getCurrentUrl(); // http://altoromutual.com:8080/login.jsp
		Assert.assertTrue(loginURL.contains("login"), "login URL is wrong !!!");

		String loginPageLabel = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1")).getText();
		Assert.assertTrue(loginPageLabel.contains("Login"), "Label is different !!!");

		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();

	}

	@Test(priority = 1, description = "Validate Logout page", dependsOnMethods = "loginTest")
	public void logoutTest() throws Exception {

		Thread.sleep(3000);

		String homeTitle = w.getTitle();
		Assert.assertEquals(homeTitle, "Altoro Mutual", "Title is wrong !!!");

		String homePageLabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
		Assert.assertTrue(homePageLabel.contains("Admin"), "UserName label is wrong !!!");

		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	}

	@AfterTest
	public void closeBrowser() {

		w.quit();
	}

}
