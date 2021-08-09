package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath = "//div[@id='dashboard-toolbar']/div[text() = 'Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//div[@id='dashboard-toolbar']/div[text() = 'Contacts']")
	List<WebElement> test;
	
	@FindBy(xpath = "//button[contains(text(), 'Create')]")
	WebElement createButton;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsHeader() {
		return contactsLabel.isDisplayed();
	}
	
	public CreateNewContactPage clickOnCreateButton() {
		createButton.click();
		return new CreateNewContactPage();
	}
	
	public void test() {
		test = driver.findElements(By.xpath("..."));
//		test = driver.findElement(By.)
	}
}
