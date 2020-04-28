package com.crm.qa.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.crm.qa.util.FWUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase 
{
	public static WebDriver driver;
	Properties prop;
	FileInputStream ip;
	EventFiringWebDriver e_WebDriver;
	WebEventListener eventListener;
	static String screenshot_Path="D:/FRAMEWORK/FreeCRMTEST/screenshot/";
	
	public TestBase() 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	
		prop=new Properties();
		try 
		{
			ip = new FileInputStream("D:/FRAMEWORK/FreeCRMTEST/src/main/java/config.properties");
			prop.load(ip);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
    
	public  void browserSetup() 
	{
		
		String browsername=prop.getProperty("browser");
		try 
		{
			if (browsername.equals("chrome")) 
			{
				driver = new ChromeDriver();
			} 
			else if (browsername.equals("FF")) 
			{
				driver = new FirefoxDriver();
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		e_WebDriver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		
		e_WebDriver.register(eventListener);
		driver=e_WebDriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public static void tearDown(ITestResult res) 
	{
		int status=res.getStatus();
		String name=res.getName();
		String filename=screenshot_Path+name;
		if(status==1)
		{
			System.out.println("Test Pass");
		}
		else
		{
			FWUtil.takeScreenshotAtEndOfTest(driver, filename+".png");
		}
		
		driver.close();
	}

}
