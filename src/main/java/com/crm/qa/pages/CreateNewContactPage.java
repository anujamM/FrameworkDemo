package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CreateNewContactPage extends TestBase {

	@FindBy(xpath = "//div[text() = 'Create New Contact']")
	private WebElement newContactsLabel;
	
	@FindBy(xpath = "//input[@name = 'first_name']")
	private WebElement input_firstName;
	
	@FindBy(xpath = "//input[@name = 'middle_name']")
	private WebElement input_middleName;
	
	@FindBy(xpath = "//input[@name = 'last_name']")
	private WebElement input_lastName;
	
	@FindBy(xpath = "//input[@placeholder= 'Email address']")
	private WebElement input_Email;
	
	@FindBy(xpath = "//button[text() = 'Save']")
	private WebElement button_Save;
	

	public CreateNewContactPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyNewContactsHeader() {
		return newContactsLabel.isDisplayed();
	}

	public void enterContactDetails(String fName, String mName, String lName, String email) {
		input_firstName.sendKeys(fName);
		input_middleName.sendKeys(mName);
		input_lastName.sendKeys(lName);
		input_Email.sendKeys(email);
		button_Save.click();
	}

}
