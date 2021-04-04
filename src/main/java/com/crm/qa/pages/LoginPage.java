package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name = "email")
	private WebElement username; 
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//div[contains(@class, 'ui fluid large blue submit button')]")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	private WebElement signUpLnk;
	
	//Initialize Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String loginPageTitle() {
		return driver.getTitle(); //Cogmento CRM
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
}
