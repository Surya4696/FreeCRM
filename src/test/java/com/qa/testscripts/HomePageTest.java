package com.qa.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.generic.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.IntroductionPage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
	IntroductionPage ipg;
	LoginPage lpg;
	HomePage hompg;
	ContactsPage conpg;
	CalendarPage calpg;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public  void setup()
	{
		browserSetup();
		hompg=new HomePage();
		conpg=new ContactsPage();
		calpg=new CalendarPage();
		ipg=new IntroductionPage();
		ipg.clklgn();
		lpg=new LoginPage();
		lpg.setup("sahoosuryakanta11@gmail.com", "Surya4696");	
	}
	
	@Test(priority=0)
	public void verifyLogo()
	{
		boolean xyz=hompg.verifylogo();
		Assert.assertTrue(xyz);
		Reporter.log("Logo is verified",true);
	}
	
	@Test (priority=1)
	public void verifyHomePageTest()
	{
		hompg.verifyHomePage();
		Assert.assertEquals(hompg.verifyHomePage(), "Cogmento CRM","Error in page");
		Reporter.log("home page is verified",true);
	}
	
	@Test (priority=2)
	public void verifyContactslinkTest()
	{
		conpg=hompg.clickOnContactsLink();
		Reporter.log("Contacts Page link is working fine ", true);	
	}
	
	@Test (priority=3)
	public void verifyCalendarTest()
	{
		calpg=hompg.clickOnCalendarLink();
		Reporter.log("Calendar Page link is working fine ", true);	
	}
}
