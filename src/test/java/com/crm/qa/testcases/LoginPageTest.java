package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage = new LoginPage();
	HomePage homepage = new HomePage();
	
	public LoginPageTest() {
		super();
	}
		
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.loginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 2/*, invocationCount=5000*/)
	public void loginToCRM() {
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.quit();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
