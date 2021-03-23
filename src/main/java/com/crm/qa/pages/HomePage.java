package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Creating Page Libraries

//	@FindBy(xpath = "//span[@class=\"user-display\"]")
	@FindBy(xpath = "//span[contains(text(),'Bapita Roy')]")
	WebElement myname;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/div[3]/a")
	WebElement contactsmenu;

	@FindBy(xpath = "//input[@placeholder=\"Search\"]")
	WebElement searchbar;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsmenu;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksmenu;

	@FindBy(xpath = "//a[@href=\"/home\"]")
	WebElement wrapper;

	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div/table/tfoot/tr/th[2]")
	WebElement body;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return myname.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {
		hoverOnLink();
		contactsmenu.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		hoverOnLink();
		dealsmenu.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		hoverOnLink();
		tasksmenu.click();
		return new TasksPage();
	}

	// to hover on the left side navigation panel
	// this function could also been kept under utils package TestUtil class
	public void hoverOnLink() {
		Actions action = new Actions(driver);
		action.moveToElement(wrapper).build().perform();

	}

	public void hoverback() {
		Actions action = new Actions(driver);
		action.moveToElement(body).build().perform();
	}

}
