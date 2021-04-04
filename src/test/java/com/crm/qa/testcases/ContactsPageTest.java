package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	CreateNewContactPage createNewContactPage;
	
	String dataSheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyContactLinksTest() throws InterruptedException {
		contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsHeader(), "Contact header is not present. Test Failed!!!");
		Thread.sleep(5000);
		createNewContactPage = contactsPage.clickOnCreateButton();
		Assert.assertTrue(createNewContactPage.verifyNewContactsHeader(),
				"New Contact header is not present. Test Failed!!!");
	}
	
	@DataProvider
	public Object[][] getExcelTestData() {
		Object data[][] = TestUtil.getTestData(dataSheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getExcelTestData")
	public void validateCreateContactName(String fName, String mName, String lName, String email) throws InterruptedException {
		contactsPage = homePage.clickOnContactsLink();
		Thread.sleep(5000);
		createNewContactPage = contactsPage.clickOnCreateButton();
		Thread.sleep(5000);
		createNewContactPage.enterContactDetails(fName, mName, lName, email);
	}

	// @AfterMethod
	// public void teardown() {
	// driver.quit();
	// }

}
