package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.generic.TestBase;

public class LoginPage extends TestBase 
{
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement email_Address_name;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	public WebElement lgnBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setup(String un, String pwd)
	{
		email_Address_name.sendKeys(un);
		password.sendKeys(pwd);
		lgnBtn.click();		
	}
	
	public String verifyLoginPage()
	{
		String lp_pageName = driver.getTitle();
		return lp_pageName;
	}
}
