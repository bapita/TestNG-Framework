package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class FreeAccountPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]/text()[3]")
	//*[@id="dashboard-toolbar"]/div[1]
	WebElement createnewcontactname;
	
	// constructor for Initializing Page objects
		public FreeAccountPage() {
			PageFactory.initElements(driver, this);
		}
	
	public String getContactsName() {
		return createnewcontactname.getText();
	}

}
