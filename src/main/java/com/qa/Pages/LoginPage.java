package com.qa.Pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;


public class LoginPage extends TestBase {
	
	

	//Page Factory 
	
	@FindBy(name= "email")
	WebElement email;
	
	@FindBy(name  = "password")
	WebElement password ;
	
	@FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginbtn;
	
	public LoginPage()  {
		PageFactory.initElements(driver, this);
	}
	
	public String  vaildateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pass) {
		email.sendKeys(un);
		password.sendKeys(pass);
		loginbtn.click();
		
		return new HomePage();
		
		
	}
	
	

}
