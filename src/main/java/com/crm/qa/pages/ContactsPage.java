package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	// Creating Page Libraries

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactstitle;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement plusbutton;

	@FindBy(xpath = "//a[contains(text(),'Bapita bops Roy')]")
	WebElement contactname;

	@FindBy(xpath = "//a[contains(text(),'Second Member')]")
	WebElement seconduser;

	// @FindBy(xpath="//input[@name='id']")
	// *[@id="main-content"]/div/div[2]/div/table/tbody/tr[1]/td[1]/div/input
	// List<WebElement> checkbox;
	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[1]/td[1]/div")
	WebElement checkbox;

	@FindBy(xpath = "//div[@name=\"action\"]")
	WebElement actiondropdown;

	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	WebElement deleteoption;

	@FindBy(xpath = "//div[@role=\"button\"]")
	WebElement checkmark;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	WebElement deletebtn;

	@FindBy(tagName = "table")
	WebElement baseTable;

	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr/td[2]")
	List<WebElement> tablerows;

	// constructor
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	// Action methods
	public String verifyContactsPageName() {
		return contactstitle.getText();
	}

	public boolean verifyContactsName() {
		return contactname.isDisplayed();
	}

	public boolean verifySecondUserName() {
//		return seconduser.isDisplayed();
		for (int i = 1; i <= tablerows.size(); i++) {
			WebElement secondUser = baseTable
					.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr/td[2]"));
			String str = secondUser.getText();
			if (str.equalsIgnoreCase("Second Member")) {
				return true;
			}
		}
		return false;
	}

	public void clickCheckbox() {
//		Iterator<WebElement> itr = checkbox.iterator();
//		while(itr.hasNext()) {
//			itr.next().click();
//		}

		checkbox.click();
	}

	public void clickActionButton() {
		actiondropdown.click();
	}

	public void deleteOptionClick() {
		deleteoption.click();
	}

	public void clickCheckMark() {
		checkmark.click();
	}

	public void clickDeleteBtn() {
		deletebtn.click();
	}
	
	public AddContactsPage clickPlusButton() {
		plusbutton.click();
		return new AddContactsPage();
	}
	
	public String checkAddedName() {
		
		String addedname = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[1]/td[2]")).getText();
		return addedname;
	}

}
