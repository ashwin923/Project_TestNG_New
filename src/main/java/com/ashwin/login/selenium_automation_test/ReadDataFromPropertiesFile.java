package com.ashwin.login.selenium_automation_test;



import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws Exception {

		
		FileInputStream fi=new FileInputStream(".\\Config\\config.properties");		
		Properties p=new Properties();		
		p.load(fi);
		
		String url=p.getProperty("application_url");
		
		String br=p.getProperty("browser");
		
		System.out.println(url);
		System.out.println(br);
		
		
		fi.close();


	}

}
