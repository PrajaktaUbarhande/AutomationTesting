package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div")
	WebElement Dealsummary; 
	
	@FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[3]/span[1]")
	WebElement usernamelable;
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[3]/span")
	WebElement contactlink; 
	
	@FindBy(xpath = "//*[@id=\"main-nav\"]/a[4]/span")
	WebElement companieslink;
	
	public HomePage() {
	PageFactory.initElements(driver, this);
   }
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}


   public Boolean visibleDealsSummary() {
	  return  Dealsummary.isDisplayed();
	   
   }
   

   public Boolean visibleusername() {
		  return  usernamelable.isDisplayed();
		   
	   }
	     
   public Contacts ClickOnContactPage() {
	contactlink.click();
	return new  Contacts() ;
   }

   public CompaniesPage ClickOnComapniesPage() {
	   companieslink.click();
	   
	   return new CompaniesPage();
   }


}