package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.Contacts;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Util.TestUtil;

public class HomePageTestCases extends TestBase {
	
	LoginPage  loginPage;
	HomePage   homePage;
	Contacts   contactPage;
	TestUtil   testUtil;
	
	
	
	public HomePageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactPage = new Contacts();
		testUtil    = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority= 1)
	public void validateHomePageTitle() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals("Cogmento CRM", "Cogmento CRM");
	}
	
	@Test(priority = 2)
    public void validateusernamelable() throws InterruptedException {
		//testUtil.switchToFrame();
		Thread.sleep(3000);
		Assert.assertTrue(homePage.visibleusername());
	}	
	 @Test(priority = 3)
	 public void validatedealSummary() throws InterruptedException {
		 Thread.sleep(5000);
		Assert.assertTrue( homePage.visibleDealsSummary());
	 }
	
	 @Test(priority = 4)
	 public void ClickOnContactPage () throws InterruptedException {
		 Thread.sleep(5000);
		 contactPage = homePage.ClickOnContactPage();
	 }
	 
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	

}
