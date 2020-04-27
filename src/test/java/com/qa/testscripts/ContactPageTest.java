package com.qa.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.generic.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.IntroductionPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.FWUtil;

public class ContactPageTest extends TestBase
{
	IntroductionPage ipg;
	LoginPage lpg;
	HomePage hpg;
	ContactsPage con_pg;
	String sheet_nam="contact";
	
	public ContactPageTest()
	{
		super();
	}
	@BeforeMethod	
	public void setup()
	{
		browserSetup();
		ipg=new IntroductionPage();
		ipg.clklgn();
		lpg=new LoginPage();
		lpg.setup("sahoosuryakanta11@gmail.com", "Surya4696");
		hpg=new HomePage();	
		hpg.clickOnContactsLink();
		con_pg=new ContactsPage();
	}
	
	@Test(priority=1)
	public void verifyContactPageTest()
	{
		con_pg.verifyContactPage();
		Assert.assertEquals(con_pg.verifyContactPage(),"Cogmento CRM");
		Reporter.log("The contact page is verified", true);
	}
	
	@Test(priority=2)
	public void clickOnNewLinkTest() throws InterruptedException
	{
		con_pg.clickOnNewLink();
	}
	
	@DataProvider
	public Object[][] getCRMTestdata()
	{
		Object data[][]=FWUtil.testData(sheet_nam);
		return data;
	}
	
	@Test(priority=0,dataProvider="getCRMTestdata")
	public void validateAddContact(String firstname,String lastname, String company, String category) throws InterruptedException
	{
		con_pg.clickOnNewLink();
		Thread.sleep(3000);
		con_pg.AddContact(firstname, lastname, company, category);
	}
}
