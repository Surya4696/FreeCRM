package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.generic.TestBase;

public class HomePage extends TestBase
{
	
	@FindBy(xpath="//div[@class='header item']")
	public WebElement logo;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	public WebElement contacts;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	public WebElement calendar;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contacts.click();
		return new ContactsPage();
	}
	
	public CalendarPage clickOnCalendarLink()
	{
		contacts.click();
		return new CalendarPage();
	}
	
	public String verifyHomePage()
	{
		String hp_pageName = driver.getTitle();
		return hp_pageName;
	}
	
	public boolean verifylogo()
	{
		boolean flag=logo.isDisplayed();
		return flag;	
	}
	
}
