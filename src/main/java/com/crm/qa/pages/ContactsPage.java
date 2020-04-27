package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.generic.TestBase;

public class ContactsPage extends TestBase
{
	
//	@FindBy(xpath="//button[@class='ui linkedin button']")
//	public WebElement save_Button;
	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a")
	public WebElement  newLink;
	
	@FindBy(xpath="//input[@name='first_name']")
	public WebElement first_name;
	
	@FindBy(xpath="//input[@name='last_name']")
	public WebElement last_name;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	public WebElement company_name;
	
	@FindBy(xpath="//div[@name='category']")
	public static WebElement category;
	
	@FindBy(xpath="//div[@name='company']//i[@class='search icon']")
	public static WebElement company_search;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyContactPage()
	{
		String conpg_pageName=driver.getTitle();
		return conpg_pageName;	
	}
	
	public void clickOnNewLink()
	{
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		newLink.click();
	}
	
	public void AddContact(String firstName,String lastName, String Companyname, String category_type)
	{		
		first_name.sendKeys(firstName);
		last_name.sendKeys(lastName);
		company_name.sendKeys(Companyname);
		company_search.click();
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		category.click();
		List<WebElement> cat_name=driver.findElements(By.xpath("//div[@class='visible menu transition']//div[@role='option']"));
		int count = cat_name.size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			String names=cat_name.get(i).getText();
			if(names.contains(category_type))
			{
				cat_name.get(i).click();
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
					
				driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				break;
			}	
		}
	}
}
