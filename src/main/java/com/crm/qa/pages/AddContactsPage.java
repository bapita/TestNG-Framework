package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AddContactsPage extends TestBase {

	// Creating Page Libraries

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement savebutton; 

	@FindBy(xpath = "//input[@name=\"first_name\"]")
	WebElement firstname;

	@FindBy(name = "last_name")
	WebElement lastname;

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement createnewcontactname;

	// constructor for Initializing Page objects
	public AddContactsPage() {
		PageFactory.initElements(driver, this);
	}

	// Action methods
	public boolean verifyAddNewContactsPage() {
		return createnewcontactname.isDisplayed();
	}
	

	public void clickOnFirstname() {
		firstname.click();
	}

	public void clickOnLastname() {
		lastname.click();
	}

	public FreeAccountPage createNewContact(String fname, String lname) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		savebutton.click();
		return new FreeAccountPage();
	}

}
