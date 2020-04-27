package com.qa.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.generic.TestBase;
import com.crm.qa.pages.IntroductionPage;

public class IntroductionTest extends TestBase 
{
	IntroductionPage ipg;
	public IntroductionTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		browserSetup();
		ipg = new IntroductionPage();
	}
	@Test(priority=1)
	public void  IntroductionTest()
	{
		
		Assert.assertEquals(ipg.verifyIntroductionPage(),
					"Free CRM #1 cloud software " + "for any business large or small");
		Reporter.log("Introduction page is verified", true);
		ipg.clklgn();
	}
}
