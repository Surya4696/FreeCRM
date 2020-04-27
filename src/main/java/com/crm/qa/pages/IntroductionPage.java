package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.generic.TestBase;

public class IntroductionPage extends TestBase 
{
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	public WebElement lgnBtn;

	public IntroductionPage() 
	{
		PageFactory.initElements(driver, this);
		
	}
	public String verifyIntroductionPage()
	{
		String ip_pageName = driver.getTitle();
		return ip_pageName;
	}

	public void clklgn() 
	{
		lgnBtn.click();
	}
	
	
	
}
