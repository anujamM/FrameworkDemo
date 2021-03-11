package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath = "//div[@id='dashboard-toolbar']/div[text() = 'Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//button[contains(text(), 'New')]")
	WebElement newButton;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsHeader() {
		return contactsLabel.isDisplayed();
	}
	
	public CreateNewContactPage clickOnNewButton() {
		newButton.click();
		return new CreateNewContactPage();
	}
}
