package com.itview.pageobject;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
		
	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Case Passed : " + result.getMethod().getDescription());
		
		try {
			TestBase.takeScreenshot(".\\Screenshot\\Pass\\"+result.getMethod().getMethodName()+".png");
			
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("Test Case Failed : " + result.getMethod().getDescription());
		
		try {
			TestBase.takeScreenshot(".\\Screenshot\\Fail\\"+result.getMethod().getMethodName()+".png");
			
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Test Case Skipped : " + result.getMethod().getDescription());
		
		try {
			TestBase.takeScreenshot(".\\Screenshot\\Skip\\"+result.getMethod().getMethodName()+".png");
			
		} catch (Exception e) {	
			e.printStackTrace();
		}

	}

}

