package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//div[contains(text(), 'Contacts activity stream')]")
	private WebElement homepageHeader;
	
	@FindBy(xpath = "//span[contains(text(), 'Home')]")
	private WebElement homeLink;
	
	@FindBy(xpath = "//span[contains(text(), 'Calendar')]")
	private WebElement calendarLink;
	
	@FindBy(xpath = "//span[contains(text(), 'Contacts')]")
	private WebElement contactsLink;
	
	@FindBy(xpath = "//span[contains(text(), 'Deals')]")
	private WebElement dealsLink;
	
	@FindBy(xpath = "//span[contains(text(), 'Tasks')]")
	private WebElement tasksLink;
	
	//Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public void verifyHomePageHeader() {
		String test = homepageHeader.getText();
		System.out.println(test);
		Assert.assertEquals(homepageHeader.getText(), "Contacts activity stream", "Homepage header not matched!!");
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTasksLink() {
		tasksLink.click();
		return new TaskPage();
	}
}
