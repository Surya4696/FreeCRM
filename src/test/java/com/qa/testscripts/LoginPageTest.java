package com.qa.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.generic.TestBase;
import com.crm.qa.pages.IntroductionPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase 
{	
	IntroductionPage ipg;
	LoginPage lpg;
	
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void Initial_setup() 
	{
		browserSetup();
		ipg=new IntroductionPage();
		ipg.clklgn();
		lpg=new LoginPage();
	}
	
	@Test
	public void LoginPageTest()
	{
		lpg.setup("sahoosuryakanta11@gmail.com", "Surya4696");
		lpg.verifyLoginPage();
		Assert.assertEquals(lpg.verifyLoginPage(), "Cogmento CRM","Error in page.");
		Reporter.log("Loginpage is verified",true);
	}
	
}
