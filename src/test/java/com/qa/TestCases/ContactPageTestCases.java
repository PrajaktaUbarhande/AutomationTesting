package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.Contacts;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Util.TestUtil;

public class ContactPageTestCases extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	Contacts contactPage;
	TestUtil testUtil;
	
	String sheetName = "ContactData";
	
	public ContactPageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		contactPage = new Contacts();
		testUtil    = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		contactPage = homePage.ClickOnContactPage();
		Thread.sleep(3000);
	}
	
	@Test(priority= 1)
	public void validateContactTitle() {
		String contactPageTitle = contactPage.vaildateContactPageTitle();
		Assert.assertEquals("Cogmento CRM", "Cogmento CRM");
	}
	
	@Test(priority= 2)
	public void vailadteContactLable() {
		Assert.assertTrue(contactPage.verifyContactLable(),"Contact lable is missing on page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority= 3,dataProvider="getCRMTestData")
	public void validateCreateContact(String firstname , String lastname)  {
		contactPage.ClickOnNewContact( );
		//contactPage.createNewContact("Prajakta", "Ubarahnde");
		
		contactPage.createNewContact(firstname, lastname);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
