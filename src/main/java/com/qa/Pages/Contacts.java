package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.Base.TestBase;

public class Contacts extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement LabelOfContact; 
	
	@FindBy(xpath =" //*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button/i")
	WebElement clickonNew;
	
	@FindBy(name = "first_name")
	WebElement enterFirstName;
	
	@FindBy(name= "last_name")
	WebElement enterLastName;
	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement savedata;
	
	
	public Contacts() {
		PageFactory.initElements(driver, this);
	}
	
	public String  vaildateContactPageTitle() {
		return driver.getTitle();
	}
	
	
	
	public boolean verifyContactLable() {
		return LabelOfContact.isDisplayed();
	}
	
	public void ClickOnNewContact() {
		clickonNew.click();
	}
	
	public void createNewContact(String ftname , String lttname )  {
		enterFirstName.sendKeys(ftname);
		enterLastName.sendKeys(lttname);
//		Select select = new Select (driver.findElement(By.name("status")));
//		Thread.sleep(3000);
//		select.selectByVisibleText(status);
		savedata.click();
		
	}
	

}
