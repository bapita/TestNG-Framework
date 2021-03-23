package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class HomePageTest extends TestBase {
	// test cases should be independent to each other. It is the best practice to
	// open and close browser after each test
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutils;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		testutils = new TestUtil();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched");
	}

	@Test(priority = 2)
	public void verifyCorrectUserNameTest() {
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void clickOnContactsLinkTest() {
		contactspage = homepage.clickOnContactsLink();
		homepage.hoverback();
		String contactspagetitile = contactspage.verifyContactsPageName();
		Assert.assertEquals(contactspagetitile, "Contacts", "Contacts page title not matched");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
