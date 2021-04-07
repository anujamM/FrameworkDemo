package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import bsh.util.Util;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	Util testUtil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		testUtil = new Util();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyPageTitleTest() {
		homePage.verifyHomePageHeader();
		String homepageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "Cogmento CRM", "Homepage title not matched!!");
	}
	
	@Test(priority = 2)
	public void verifyContactLinksTest() {
		contactsPage =  homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
