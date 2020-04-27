package com.crm.qa.generic;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.util.WebEventListener;

public class TestBase 
{
	public static WebDriver driver;
	Properties prop;
	FileInputStream ip;
	EventFiringWebDriver e_WebDriver;
	WebEventListener eventListener;
	
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
	public static void tearDown() 
	{
		driver.close();
	}

}
